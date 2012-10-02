package interpret;


import interpret.utility.ExceptionProcessor;
import interpret.utility.UtilityClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ArrayEditDialog extends ArrayCreationDialog{

	Object selectedArray;

	public ArrayEditDialog(final JFrame ownerFrame, final List<Object> objectList, final Object selectedArray){
		super(ownerFrame, objectList);
		if(selectedArray.getClass().isArray() == false){
			throw new IllegalArgumentException("Must be a Array object");
		}
		this.selectedArray = selectedArray;
	}


	@Override
	protected void initLayout(){
		super.initLayout();
		this.classNameTextField.setEnabled(false);

		final Class<?> arrayComponentClass = this.selectedArray.getClass().getComponentType();
		this.classNameTextField.setText(arrayComponentClass.getName());

		this.arraySizeTextField.setText(String.valueOf(Array.getLength(this.selectedArray)));

		this.createButton.setText("Save");

		this.arrayTable.refreshTable( this.selectedArray);

	}


	@Override
	protected void initArraySizeTextFieldHandler(){
		this.arraySizeTextField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final String className = ArrayEditDialog.this.classNameTextField.getText();
				Class<?> klass;

				try {
					klass = UtilityClass.getPrimitiveTypeClass(className);
					if(klass == null){
						klass = Class.forName(className);
					}
					final String newSizeString = ArrayEditDialog.this.arraySizeTextField.getText();
					final int newSize = new Integer(newSizeString);

					final int oldSize = Array.getLength(ArrayEditDialog.this.selectedArray);

					Object newArray = null;
					if(newSize != oldSize){
						newArray = UtilityClass.changeArrayLength(ArrayEditDialog.this.selectedArray, newSize);
					}

					if(newArray != null){
						ArrayEditDialog.this.arrayTable.refreshTable( newArray);
					}else{
						ArrayEditDialog.this.arrayTable.refreshTable( ArrayEditDialog.this.selectedArray);
					}

				} catch (final ClassNotFoundException e) {
					ExceptionProcessor.processException(e);
				}

			}

		});
	}


	@Override
	protected void initButtonsHandler(){
		this.createButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				final Object newArray = ArrayEditDialog.this.arrayTable.getArray();
				if(newArray == null){
					JOptionPane.showMessageDialog(null, "Please input the correct value of class and size");
					return;
				}

				final int index = ArrayEditDialog.this.objectList.indexOf(ArrayEditDialog.this.selectedArray);
				ArrayEditDialog.this.objectList.remove(ArrayEditDialog.this.selectedArray);
				ArrayEditDialog.this.objectList.add(index, newArray);//TODO
				//ArrayCreationDialog.this.objectTable.refreshTable();
				ArrayEditDialog.super.dispose();

			}


		});

		this.cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(final ActionEvent actionevent) {
				ArrayEditDialog.super.dispose();
			}


		});

	}


}
