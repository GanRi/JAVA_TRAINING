package interpret.fieldtable;

import interpret.objecttable.ObjectTable;
import interpret.utility.ComboBoxFactory;
import interpret.utility.ExceptionProcessor;
import interpret.utility.FinalExceptionHandler;
import interpret.utility.UtilityClass;

import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FieldTableCellEditor extends DefaultCellEditor{

	List<Object> objectList;
	protected JComboBox comboBox = null;
	protected volatile JTextField textField = null;
	protected JLabel label = null;
	//Class<?> klass = null;
	Class<?>[] fieldTypes;

	Field[] fields;
	Object selectedObject;

	ObjectTable relatedObjectTable;

	public   FieldTableCellEditor(final List<Object> objectList, final Class<?>[] fieldTypes,
			final Field[] fields, final Object object, final ObjectTable relatedObjectTable){
		super(new JComboBox());
		this.objectList = objectList;
		this.fieldTypes = fieldTypes;

		this.fields = fields;
		this.selectedObject = object;

		this.relatedObjectTable = relatedObjectTable;
	}


	@Override
	public Component getTableCellEditorComponent(final JTable table, final Object value,
			final boolean isSelected, final int rowIndex, final int vColIndex) {

		this.init();
		//System.out.println("isSelect = " + isSelected + ", row = " + rowIndex + ", col = " + vColIndex);
		if(value != null)
		{
			if( this.fieldTypes[rowIndex].isPrimitive() || this.fieldTypes[rowIndex] == String.class )
			{
				this.textField = new JTextField(value.toString(),SwingConstants.CENTER);

				this.textField.addFocusListener(new FocusAdapter(){

					@Override
					public   void   focusLost(final FocusEvent event)   {
						Thread.currentThread().setUncaughtExceptionHandler(new FinalExceptionHandler());//TODO
						final JTextField sourceTextField = (JTextField)event.getSource();
						final Object fieldValue = UtilityClass.convertValue(FieldTableCellEditor.this.fieldTypes[rowIndex], sourceTextField.getText());
						try {
							if(FieldTableCellEditor.this.fieldTypes[rowIndex] == String.class && ((String)fieldValue).equals("null")){
								FieldTableCellEditor.this.fields[rowIndex].set(FieldTableCellEditor.this.selectedObject, null);
							}else{
								FieldTableCellEditor.this.fields[rowIndex].set(FieldTableCellEditor.this.selectedObject, fieldValue);
							}

							FieldTableCellEditor.this.relatedObjectTable.refreshTable(false);

						} catch (final Exception e) {
							ExceptionProcessor.processException(e);
							return;
						}
					}

				});

				return this.textField;
			}else{
				//this.comboBox = ComboBoxFactory.getComboBox(this.objectList, value.getClass());
				//this.comboBox = ComboBoxFactory.getComboBox(this.objectList, this.klass);
				this.comboBox = ComboBoxFactory.getComboBox(this.objectList, this.fieldTypes[rowIndex]);

				final List<Object> subList = UtilityClass.findSubList(this.objectList, this.fieldTypes[rowIndex]);
				if(subList.contains(value) == false){
					this.comboBox.addItem(value);
				}

				this.comboBox.setSelectedItem(value);

				this.comboBox.addFocusListener(new FocusAdapter(){

					@Override
					public   void   focusLost(final FocusEvent event)   {
						final JComboBox sourceComboBox = (JComboBox)event.getSource();
						final Object fieldValue = UtilityClass.convertValue(FieldTableCellEditor.this.fieldTypes[rowIndex], sourceComboBox.getSelectedItem());
						try {
							if(! (fieldValue instanceof String)){
								FieldTableCellEditor.this.fields[rowIndex].set(FieldTableCellEditor.this.selectedObject, fieldValue);
							}else{//when set to null
								FieldTableCellEditor.this.fields[rowIndex].set(FieldTableCellEditor.this.selectedObject, null);
							}

							FieldTableCellEditor.this.relatedObjectTable.refreshTable(false);

						} catch (final Exception e) {
							ExceptionProcessor.processException(e);
							return;
						}
					}

				});

				return this.comboBox;
			}
		}

		return null;

	}

	@Override
	public Object getCellEditorValue() {
		if(this.comboBox != null){
			return this.comboBox.getSelectedItem();
		}else if(this.textField != null){
			return this.textField.getText();
		}else{
			//return this.label.getText();
			return null;
		}

	}


	private void init(){
		this.comboBox = null;
		this.textField = null;
		this.label = null;
	}

}
