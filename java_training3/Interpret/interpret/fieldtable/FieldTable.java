package interpret.fieldtable;


import interpret.objecttable.ObjectTable;
import interpret.utility.ExceptionProcessor;
import interpret.utility.UtilityClass;

import java.awt.Dimension;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class FieldTable extends JTable{

	final DefaultTableModel tableModel = new FieldTableModel();
	Field[] fields;
	List<Object> objectList;
	Object selectedObject;

	ObjectTable objectTable;

	public FieldTable(final List<Object> objectList){
		this.objectList = objectList;

		super.setModel(this.tableModel);
		super.setRowHeight((int)(super.getRowHeight() * 1.5) );
		super.setPreferredScrollableViewportSize(new Dimension(500, 250));
		super.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

		final ListSelectionModel selectionModel=super.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}


	public void refreshTable(final Object object){
		if(object == null){
			return;
		}

		this.selectedObject = object;
		final Class<?> klass = object.getClass();

		//this.fields = klass.getDeclaredFields();//TODO : should get public fields from super class too.
		this.fields = UtilityClass.getNecessaryFields(klass);

		AccessibleObject.setAccessible(this.fields, true);
		final ArrayList<Integer> finalRemovedIndexList =  UtilityClass.removeFinalAccessor(this.fields);

		super.getColumnModel().getColumn(3).setCellEditor(null);
		super.getColumnModel().getColumn(3).setCellRenderer(null);

		final Class<?>[] fieldTypes = this.getFieldTypes();
		final FieldTableCellEditor editor = new FieldTableCellEditor(this.objectList, fieldTypes, this.fields, this.selectedObject, this.objectTable);
		
		final TableColumn column3 = super.getColumnModel().getColumn(3);
		column3.setCellEditor(editor);
		//column2.setCellRenderer(renderer);
		column3.setCellRenderer(new DefaultTableCellRenderer());

		final int rowNum = this.tableModel.getRowCount();
		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}


		for(int i = 0; i < fieldTypes.length; i++){

			final Class<?> fieldType = fieldTypes[i];
			Object fieldValue;

			try {
				fieldValue = this.fields[i].get(object);
			} catch (final Exception e) {
				ExceptionProcessor.processException(e);
				return;
			}

			final String modifierSuffix = finalRemovedIndexList.contains(i) ? " final" : "";
			final int modifiers = this.fields[i].getModifiers();

			if(fieldType.isPrimitive() || fieldType == String.class ){
				//this.tableModel.addRow(new Object[]{fieldType.toString(), this.fields[i].getName(), fieldValue.toString()});//TODO
				this.tableModel.addRow(new Object[]{Modifier.toString(modifiers) + modifierSuffix, fieldType.toString(), this.fields[i].getName(), fieldValue != null ? fieldValue.toString() : "null"});//TODO
			}else{
				this.tableModel.addRow(new Object[]{Modifier.toString(modifiers) + modifierSuffix, fieldType.toString(), this.fields[i].getName(), fieldValue != null ? fieldValue : "null"});
			}

		}

		super.removeEditor();
	}


	public void printFieldArray(){
		if(this.fields == null){
			return;
		}

		for(final Field field : this.fields){
			Object fieldValue;
			try {
				fieldValue = field.get(this.selectedObject);
			} catch (final Exception e) {
				ExceptionProcessor.processException(e);
				return;
			}
			if(fieldValue == null){
				System.out.println("null pointer");
			}else{
				System.out.println(fieldValue);
			}
		}

	}


	public void setObjectTable(final ObjectTable objectTable){
		this.objectTable = objectTable;
	}


	private Class<?>[] getFieldTypes(){
		if(this.fields == null){
			return null;
		}

		final Class<?>[] fieldTypes = new Class<?>[this.fields.length];
		for(int i = 0; i < fieldTypes.length; i++){
			fieldTypes[i] = this.fields[i].getType();
		}
		return fieldTypes;
	}

}
