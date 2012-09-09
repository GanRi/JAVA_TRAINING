package interpret;

import interpret.methodtable.MethodTable;
import interpret.objecttable.ObjectTable;
import interpret.parametertable.ParameterTable;
import interpret.utility.ExceptionProcessor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class ObjectCreationDialog extends JDialog{

	List<Object> objectList;
	ObjectTable objectTable = null;

	final JTextField classNameTextField;
	final MethodTable methodTable;
	final ParameterTable parameterTable;

	final JButton createButton = new JButton("Create");
	final JButton cancelButton = new JButton("Cancel");


	public ObjectCreationDialog(final JFrame ownerFrame, final List<Object> objectList){
		super(ownerFrame, true);

		this.objectList = objectList;
		this.classNameTextField = new JTextField();
		this.methodTable = new MethodTable(true);
		this.parameterTable = new ParameterTable(objectList);

		this.methodTable.setParameterTable(this.parameterTable);
		this.initLayout();
		this.initEventHandler();

		super.setTitle("Create Object");
		//super.setSize(new Dimension(1000, 600));
		super.pack();
		//super.setVisible(true);
	}


	public void setObjectTable(final ObjectTable objectTable){
		this.objectTable = objectTable;
	}


	private void initLayout(){


		final JScrollPane methodTableScrollPane = new JScrollPane(this.methodTable);
		final JScrollPane parameterTableScrollPane = new JScrollPane(this.parameterTable);

		final Container container = super.getContentPane();

		final JPanel classNamePanel = new JPanel();
		final JLabel classNameLabel = new JLabel("Class Name: ");
		classNamePanel.add(classNameLabel);
		classNamePanel.add(this.classNameTextField);
		this.classNameTextField.setPreferredSize(new Dimension(400, 30));

		final JPanel methodTablePanel = new JPanel();
		methodTablePanel.setLayout(new BorderLayout());
		final JLabel methodTableLabel = new JLabel("Constructor List");
		methodTablePanel.add(methodTableLabel, BorderLayout.NORTH);
		methodTablePanel.add(methodTableScrollPane, BorderLayout.CENTER );

		final JPanel parameterTablePanel = new JPanel();
		parameterTablePanel.setLayout(new BorderLayout());
		final JLabel parameterTableLabel = new JLabel("Parameter List");
		parameterTablePanel.add(parameterTableLabel, BorderLayout.NORTH);
		parameterTablePanel.add(parameterTableScrollPane, BorderLayout.CENTER );

		final JPanel twoTablesPanel = new JPanel();
		twoTablesPanel.setLayout(new GridLayout(2, 1));
		twoTablesPanel.add(methodTablePanel);
		twoTablesPanel.add(parameterTablePanel);

		final JPanel buttonPanel = new JPanel();
		buttonPanel.add(this.createButton);
		buttonPanel.add(this.cancelButton);


		container.add(classNamePanel, BorderLayout.NORTH);
		container.add(twoTablesPanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);


		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


	}


	private void initEventHandler(){
		this.initClassNameTextFieldHandler();
		this.initButtonsHandler();
	}


	private void initClassNameTextFieldHandler(){
		this.classNameTextField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final String className = ObjectCreationDialog.this.classNameTextField.getText();
				try {
					final Class<?> klass = Class.forName(className);
					ObjectCreationDialog.this.methodTable.refreshTable(klass);
					//ObjectCreationFrame.this.parameterTable.remover
				} catch (final ClassNotFoundException e) {
					ExceptionProcessor.processException(e);
				}

			}

		});
	}


	private void initButtonsHandler(){
		this.createButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final Constructor<?> selectedConstructor = (Constructor<?>)ObjectCreationDialog.this.methodTable.getSelectedMember();
				//System.out.println(selectedConstructor);
				selectedConstructor.setAccessible(true);
				final Object[] parameters = ObjectCreationDialog.this.parameterTable.getParameterArray();
				try {
					final Object instance = selectedConstructor.newInstance(parameters);
					ObjectCreationDialog.this.objectList.add(instance);
					//ObjectCreationFrame.this.objectTable.refreshTable();
					ObjectCreationDialog.super.dispose();
				} catch (final Exception e) {
					ExceptionProcessor.processException(e);
				}
			}


		});

		this.cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				ObjectCreationDialog.super.dispose();
			}


		});

	}



}
