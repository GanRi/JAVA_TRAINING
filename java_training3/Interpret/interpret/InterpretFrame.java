package interpret;

import interpret.fieldtable.FieldTable;
import interpret.methodtable.MethodTable;
import interpret.objecttable.ObjectTable;
import interpret.parametertable.ParameterTable;
import interpret.utility.ExceptionProcessor;
import interpret.utility.UtilityClass;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class InterpretFrame extends JFrame{

	private final List<Object> objectList = UtilityClass.createObjectList();

	protected final JButton createObjectButton = new JButton("Create Object");
	//public final JButton createArrayButton = new JButton("Create Array");

	ObjectTable objectTable = new ObjectTable(this.objectList);
	FieldTable fieldTable = new FieldTable(this.objectList);

	MethodTable methodTable = new MethodTable(false);
	ParameterTable parameterTable  = new ParameterTable(this.objectList);

	final JButton executeMethodButton = new JButton("Execute Method");
	final JLabel returnValueLabel = new JLabel("Return Value");

	public InterpretFrame(){
		super.setName("Interpret");
		this.setTablesRelation();

		this.initLayout();
		this.initEventHandler();

		super.setSize(new Dimension(1000, 1600));
		super.pack();
		super.setVisible(true);
	}


	private void setTablesRelation(){
		this.objectTable.setFieldTable(this.fieldTable);
		this.objectTable.setMethodTable(this.methodTable);
		this.objectTable.setInterpretFrame(this);
		this.methodTable.setParameterTable(this.parameterTable);
		this.fieldTable.setObjectTable(this.objectTable);
	}


	private void initLayout(){
		final Container container = super.getContentPane();

		final JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());

		final JPanel buttonPanel = new JPanel();
		buttonPanel.add(this.createObjectButton);
		//buttonPanel.add(this.createArrayButton);

		final JPanel objectTablePanel = new JPanel();
		objectTablePanel.setLayout(new BorderLayout());
		final JLabel objectTableLabel = new JLabel("Object List");
		final JScrollPane objectTableScrollPanel = new JScrollPane(this.objectTable);
		objectTablePanel.add(objectTableLabel, BorderLayout.NORTH);
		objectTablePanel.add(objectTableScrollPanel, BorderLayout.CENTER );

		final JPanel fieldTablePanel = new JPanel();
		fieldTablePanel.setLayout(new BorderLayout());
		final JLabel fieldTableLabel = new JLabel("Field List");
		final JScrollPane fieldTableScrollPane1 = new JScrollPane(this.fieldTable);
		fieldTablePanel.add(fieldTableLabel, BorderLayout.NORTH);
		fieldTablePanel.add(fieldTableScrollPane1, BorderLayout.CENTER );

		final JPanel leftTwoTablePanel = new JPanel();
		leftTwoTablePanel.setLayout(new GridLayout(2,1));
		leftTwoTablePanel.add(objectTablePanel);
		leftTwoTablePanel.add(fieldTablePanel);

		leftPanel.add(buttonPanel, BorderLayout.NORTH);
		leftPanel.add(leftTwoTablePanel, BorderLayout.CENTER);

		final JPanel methodTablePanel = new JPanel();
		methodTablePanel.setLayout(new BorderLayout());
		final JLabel methodTableLabel = new JLabel("Method List");
		final JScrollPane methodTableScrollPane = new JScrollPane(this.methodTable);
		methodTablePanel.add(methodTableLabel, BorderLayout.NORTH);
		methodTablePanel.add(methodTableScrollPane, BorderLayout.CENTER );

		final JPanel parameterTablePanel = new JPanel();
		parameterTablePanel.setLayout(new BorderLayout());
		final JLabel parameterTableLabel = new JLabel("Method Parameter List");
		final JScrollPane parameterTableScrollPane = new JScrollPane(this.parameterTable);
		parameterTablePanel.add(parameterTableLabel, BorderLayout.NORTH);
		parameterTablePanel.add(parameterTableScrollPane, BorderLayout.CENTER );

		final JPanel rightTwoTablesPanel = new JPanel();
		rightTwoTablesPanel.setLayout(new GridLayout(2, 1));
		rightTwoTablesPanel.add(methodTablePanel);
		rightTwoTablesPanel.add(parameterTablePanel);

		final JPanel returnValuePanel = new JPanel();
		returnValuePanel.setLayout(new GridLayout(2,1));
			
		returnValuePanel.add(this.executeMethodButton);
		returnValuePanel.add(this.returnValueLabel);

		final JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(rightTwoTablesPanel, BorderLayout.CENTER );
		rightPanel.add(returnValuePanel, BorderLayout.SOUTH);

		final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

		container.add(splitPane, BorderLayout.CENTER);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void initEventHandler(){
		this.initButtonsHandler();
	}


	private void initButtonsHandler(){

		this.createObjectButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final ObjectCreationDialog objectCreateDialog= new ObjectCreationDialog(InterpretFrame.this, InterpretFrame.this.objectList);

				objectCreateDialog.addWindowListener(new WindowAdapter(){

					@Override
					public void windowClosed(final WindowEvent arg0) {
						InterpretFrame.this.objectTable.refreshTable();
					}

				});

				objectCreateDialog.setVisible(true);


			}


		});

		this.executeMethodButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final Object selectedObject = InterpretFrame.this.objectTable.getSelectedObject();
				final Method selectedMethod = (Method)InterpretFrame.this.methodTable.getSelectedMember();
				final Object[] parameters = InterpretFrame.this.parameterTable.getParameterArray();

				selectedMethod.setAccessible(true);

				try {
					final Object returnValue = selectedMethod.invoke(selectedObject, parameters);
					InterpretFrame.this.returnValueLabel.setText(returnValue != null? returnValue.toString() : "null");

					InterpretFrame.this.objectTable.refreshTable(false);
					InterpretFrame.this.fieldTable.refreshTable(InterpretFrame.this.objectTable.getSelectedObject());
				} catch (final Exception e) {
					ExceptionProcessor.processException(e);
				}

			}


		});
	}

}
