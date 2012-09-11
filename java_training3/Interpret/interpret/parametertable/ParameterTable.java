package interpret.parametertable;

import interpret.utility.ComboBoxFactory;
import interpret.utility.UtilityClass;

import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class ParameterTable extends JTable{
	DefaultTableModel tableModel = new ParameterTableModel();

	Class<?>[] parameterTypes;
	List<Object> objectList;


	public ParameterTable(final List<Object> objectList){
		this.objectList = objectList;

		super.setModel(this.tableModel);
		super.setRowHeight((int)(super.getRowHeight() * 1.5) );
		//this.setClickListener();
		super.setPreferredScrollableViewportSize(new Dimension(500, 250));
		super.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

		final ListSelectionModel selectionModel=super.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	public void refreshTable(final Member member){
		if(member == null){
			return;
		}

		if(member instanceof Method){
			this.parameterTypes = ((Method)member).getParameterTypes();
		}else if(member instanceof Constructor<?>){
			this.parameterTypes = ((Constructor<?>)member).getParameterTypes();
		}

		super.getColumnModel().getColumn(1).setCellEditor(null);
		super.getColumnModel().getColumn(1).setCellRenderer(null);

		final ParameterTableCellEditor editor = new ParameterTableCellEditor(this.objectList, this.parameterTypes);
		final ParameterTableCellRenderer renderer = new ParameterTableCellRenderer(this.objectList, this.parameterTypes);
		//super.setDefaultEditor(parameterType, editor);
		final TableColumn column1 = super.getColumnModel().getColumn(1);
		column1.setCellEditor(editor);
		column1.setCellRenderer(renderer);

		final int rowNum = this.tableModel.getRowCount();
		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}

		for(final Class<?> parameterType : this.parameterTypes){

			if(parameterType.isPrimitive() || parameterType == String.class ){
				this.tableModel.addRow(new Object[]{parameterType.toString(), new String("")});
			}else{
				final JComboBox comboBox = ComboBoxFactory.getComboBox(this.objectList, parameterType);
				this.tableModel.addRow(new Object[]{parameterType.toString(), comboBox.getItemAt(0)});

			}

		}
		super.removeEditor();
	}


	public Object[] getParameterArray(){
		if(this.parameterTypes == null){
			return null;
		}

		final ArrayList<Object> parameterList = new ArrayList<Object>();
		final int parameterNum = this.parameterTypes.length;
		for(int i = 0; i < parameterNum; i++){
			Object value = super.getValueAt(i, 1);
			value = UtilityClass.convertValue(this.parameterTypes[i], value);
			if(value instanceof String && ((String)value).equals("null")){
				value = null;
			}
			parameterList.add(value);
		}

		return parameterList.toArray();

	}


	public void removeAllRows(){
		final int rowNum = this.tableModel.getRowCount();
		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}
	}
}

