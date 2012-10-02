package interpret.arraytable;

import interpret.parametertable.ParameterTableCellEditor;
import interpret.parametertable.ParameterTableCellRenderer;
import interpret.utility.ComboBoxFactory;
import interpret.utility.UtilityClass;

import java.awt.Dimension;
import java.lang.reflect.Array;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class ArrayTable extends JTable{
	DefaultTableModel tableModel = new ArrayTableModel();

	List<Object> objectList;
	Class<?> componentClass;
	int arraySize;

	public ArrayTable(final List<Object> objectList){
		this.objectList = objectList;

		super.setModel(this.tableModel);
		super.setRowHeight((int)(super.getRowHeight() * 1.5) );
		//this.setClickListener();
		super.setPreferredScrollableViewportSize(new Dimension(500, 250));
		super.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

	}


	public void refreshTable(final Class<?> klass , final int size){

		this.componentClass = klass;
		this.arraySize = size;

		final Class<?>[] classTypes = new Class<?>[size];
		for(int i = 0; i < classTypes.length; i++){
			classTypes[i] = klass;
		}

		super.getColumnModel().getColumn(1).setCellEditor(null);
		super.getColumnModel().getColumn(1).setCellRenderer(null);

		final ParameterTableCellEditor editor = new ParameterTableCellEditor(this.objectList, classTypes);
		final ParameterTableCellRenderer renderer = new ParameterTableCellRenderer(this.objectList, classTypes);
		//super.setDefaultEditor(parameterType, editor);
		final TableColumn column1 = super.getColumnModel().getColumn(1);
		column1.setCellEditor(editor);
		//column1.setCellRenderer(renderer);

		final int rowNum = this.tableModel.getRowCount();
		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}


		for(int i = 0; i < classTypes.length; i++){
			final Class<?> classType = classTypes[i];

			if(classType.isPrimitive() || classType == String.class ){
				this.tableModel.addRow(new Object[]{i, new String("")});
			}else{
				final JComboBox comboBox = ComboBoxFactory.getComboBox(this.objectList, classType);
				//				if(comboBox.getItemAt(0) != null){
				//					this.tableModel.addRow(new Object[]{parameterType.toString(), comboBox.getItemAt(0)});
				//					//					super.setDefaultEditor(parameterType, new ParameterTableCellEditor(this.objectList));
				//					//					super.setDefaultRenderer(parameterType, new ParameterTableCellRenderer(this.objectList));
				//
				//					//super.setDefaultEditor(parameterType, new ParameterTableCellEditor(this.objectList, parameterType));
				//					//super.setDefaultRenderer(parameterType, new ParameterTableCellRenderer(this.objectList, parameterType));
				//
				//					//final ParameterTableCellEditor editor = new ParameterTableCellEditor(this.objectList, parameterType);
				//					//					final ParameterTableCellEditor editor = new ParameterTableCellEditor(this.objectList, this.parameterTypes);
				//					//					super.setDefaultEditor(parameterType, editor);
				//					//super.getColumnModel().getColumn(1).setCellEditor(editor);
				//
				//				}else{
				//					this.tableModel.addRow(new Object[]{parameterType.toString()});
				//				}
				this.tableModel.addRow(new Object[]{i, comboBox.getItemAt(0)});

			}

		}
		super.removeEditor();
		//super.repaint();

		//		TableCellEditor editor1 = super.getDefaultEditor(Integer.class);
		//		TableCellEditor editor2 = super.getDefaultEditor(Point.class);
		//
		//		System.out.println(editor1);
		//		System.out.println(editor2);
	}


	public void refreshTable(final Object selectedArray){


		this.componentClass = selectedArray.getClass().getComponentType();
		this.arraySize = Array.getLength(selectedArray);


		final Class<?>[] classTypes = new Class<?>[this.arraySize];
		for(int i = 0; i < classTypes.length; i++){
			classTypes[i] = this.componentClass;
		}

		super.getColumnModel().getColumn(1).setCellEditor(null);
		super.getColumnModel().getColumn(1).setCellRenderer(null);

		final ParameterTableCellEditor editor = new ParameterTableCellEditor(this.objectList, classTypes);
		final ParameterTableCellRenderer renderer = new ParameterTableCellRenderer(this.objectList, classTypes);
		//super.setDefaultEditor(parameterType, editor);
		final TableColumn column1 = super.getColumnModel().getColumn(1);
		column1.setCellEditor(editor);
		//column1.setCellRenderer(renderer);

		final int rowNum = this.tableModel.getRowCount();
		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}


		final Class<?> classType = selectedArray.getClass().getComponentType();
		for(int i = 0; i < classTypes.length; i++){
			//final Class<?> classType = classTypes[i];
			final Object componentValue = Array.get(selectedArray, i);

			if(classType.isPrimitive() || classType == String.class ){
				//this.tableModel.addRow(new Object[]{i, new String("")});
				this.tableModel.addRow(new Object[]{i, componentValue != null ? componentValue.toString() : "null"});
			}else{
				//final JComboBox comboBox = ComboBoxFactory.getComboBox(this.objectList, classType);
				//				if(comboBox.getItemAt(0) != null){
				//					this.tableModel.addRow(new Object[]{parameterType.toString(), comboBox.getItemAt(0)});
				//					//					super.setDefaultEditor(parameterType, new ParameterTableCellEditor(this.objectList));
				//					//					super.setDefaultRenderer(parameterType, new ParameterTableCellRenderer(this.objectList));
				//
				//					//super.setDefaultEditor(parameterType, new ParameterTableCellEditor(this.objectList, parameterType));
				//					//super.setDefaultRenderer(parameterType, new ParameterTableCellRenderer(this.objectList, parameterType));
				//
				//					//final ParameterTableCellEditor editor = new ParameterTableCellEditor(this.objectList, parameterType);
				//					//					final ParameterTableCellEditor editor = new ParameterTableCellEditor(this.objectList, this.parameterTypes);
				//					//					super.setDefaultEditor(parameterType, editor);
				//					//super.getColumnModel().getColumn(1).setCellEditor(editor);
				//
				//				}else{
				//					this.tableModel.addRow(new Object[]{parameterType.toString()});
				//				}
				this.tableModel.addRow(new Object[]{i, componentValue != null ? componentValue : "null"});

			}

		}
		super.removeEditor();
		//super.repaint();

		//		TableCellEditor editor1 = super.getDefaultEditor(Integer.class);
		//		TableCellEditor editor2 = super.getDefaultEditor(Point.class);
		//
		//		System.out.println(editor1);
		//		System.out.println(editor2);
	}


	public Object getArray(){

		if(this.componentClass == null || this.arraySize == 0){
			return null;
		}

		final Class<?>[] classTypes = new Class<?>[this.arraySize];
		for(int i = 0; i < classTypes.length; i++){
			classTypes[i] = this.componentClass;
		}

		final Object newArray = Array.newInstance(this.componentClass, this.arraySize);


		final int parameterNum = classTypes.length;
		for(int i = 0; i < parameterNum; i++){
			Object value = super.getValueAt(i, 1);
			value = UtilityClass.convertValue(classTypes[i], value);
			if(value instanceof String && ((String)value).equals("null")){
				value = null;
			}
			//((Object[])newArray)[i] = value;
			Array.set(newArray, i, value);
		}

		return newArray;

	}
}

