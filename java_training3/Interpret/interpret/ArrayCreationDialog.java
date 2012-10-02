package interpret;


import interpret.arraytable.ArrayTable;
import interpret.utility.ExceptionProcessor;
import interpret.utility.UtilityClass;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class ArrayCreationDialog extends JDialog{

	List<Object> objectList;

	final protected JTextField classNameTextField;
	final protected JTextField arraySizeTextField;
	final protected ArrayTable arrayTable;

	final protected JButton createButton = new JButton("Create");
	final protected JButton cancelButton = new JButton("Cancel");


	public ArrayCreationDialog(final JFrame ownerFrame, final List<Object> objectList){
		super(ownerFrame, true);

		this.objectList = objectList;
		this.classNameTextField = new JTextField();
		this.arraySizeTextField = new JTextField();
		this.arrayTable = new ArrayTable(objectList);

	}


	public void init(){
		this.initLayout();
		this.initEventHandler();

		super.setTitle("Create Array");
		super.pack();
	}



	protected void initLayout(){

		final JScrollPane arrayTableScrollPane = new JScrollPane(this.arrayTable);

		final Container container = super.getContentPane();

		final JPanel classNamePanel = new JPanel();
		final JLabel classNameLabel = new JLabel("Class Name: ");
		classNamePanel.add(classNameLabel);
		classNamePanel.add(this.classNameTextField);
		this.classNameTextField.setPreferredSize(new Dimension(400, 30));

		final JPanel arraySizePanel = new JPanel();
		final JLabel arraySizeLabel = new JLabel("Array Size: ");
		arraySizePanel.add(arraySizeLabel);
		arraySizePanel.add(this.arraySizeTextField);
		this.arraySizeTextField.setPreferredSize(new Dimension(400, 30));

		final JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(2, 1));
		textPanel.add(classNamePanel);
		textPanel.add(arraySizePanel);

		final JPanel arrayTablePanel = new JPanel();
		arrayTablePanel.setLayout(new BorderLayout());
		final JLabel arrayTableLabel = new JLabel("Object Array");
		arrayTablePanel.add(arrayTableLabel, BorderLayout.NORTH);
		arrayTablePanel.add(arrayTableScrollPane, BorderLayout.CENTER );

		final JPanel buttonPanel = new JPanel();
		buttonPanel.add(this.createButton);
		buttonPanel.add(this.cancelButton);


		container.add(textPanel, BorderLayout.NORTH);
		container.add(arrayTablePanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);

		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


	}


	protected void initEventHandler(){
		this.initArraySizeTextFieldHandler();
		this.initButtonsHandler();
	}


	protected void initArraySizeTextFieldHandler(){
		this.arraySizeTextField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final String className = ArrayCreationDialog.this.classNameTextField.getText();
				Class<?> klass;

				try {
					klass = UtilityClass.getPrimitiveTypeClass(className);
					if(klass == null){
						klass = Class.forName(className);
					}
					final String arraySizeString = ArrayCreationDialog.this.arraySizeTextField.getText();
					final int arraySize = new Integer(arraySizeString);

					ArrayCreationDialog.this.arrayTable.refreshTable(klass, arraySize);
				} catch (final ClassNotFoundException e) {
					ExceptionProcessor.processException(e);
				}

			}

		});
	}


	protected void initButtonsHandler(){
		this.createButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final Object array = ArrayCreationDialog.this.arrayTable.getArray();
				if(array == null){
					JOptionPane.showMessageDialog(null, "Please input the correct value of class and size");
					return;
				}

				ArrayCreationDialog.this.objectList.add(array);
				//ArrayCreationDialog.this.objectTable.refreshTable();
				ArrayCreationDialog.super.dispose();

			}


		});

		this.cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				ArrayCreationDialog.super.dispose();
			}


		});

	}


}
