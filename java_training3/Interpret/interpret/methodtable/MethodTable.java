package interpret.methodtable;

import interpret.parametertable.ParameterTable;
import interpret.utility.UtilityClass;

import java.awt.Dimension;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class MethodTable extends JTable{
	boolean isConstructor = false;
	DefaultTableModel tableModel = new MethodTableModel();
	ParameterTable parameterTable = null;

	Member[] members;

	public MethodTable(final boolean isConstructor){
		this.isConstructor = isConstructor;
		super.setModel(this.tableModel);
		super.setRowHeight((int)(super.getRowHeight() * 1.5) );
		this.setClickListener();
		super.setPreferredScrollableViewportSize(new Dimension(500, 250));

		final ListSelectionModel selectionModel=super.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}


	public MethodTable(){
		this(false);
	}


	public void refreshTable(final Class<?> klass){
		if(klass == null){
			return;
		}

		if(this.isConstructor){
			this.members = klass.getDeclaredConstructors();//TODO
			AccessibleObject.setAccessible((Constructor[])this.members, true);
		}else{
			//this.members = klass.getDeclaredMethods();//TODO
			this.members = UtilityClass.getNecessaryMethods(klass);
			AccessibleObject.setAccessible((Method[])this.members, true);
		}

		super.clearSelection();

		final TableColumn column0 = super.getColumnModel().getColumn(0);
		column0.setCellRenderer(new MethodTableCellRenderer());

		final int rowNum = this.tableModel.getRowCount();
		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}

		for(final Member member : this.members){
			this.tableModel.addRow(new String[]{member.toString()});
		}

		//super.addRowSelectionInterval(2, 2);
		final int newRowNum = this.tableModel.getRowCount();
		if(newRowNum > 0){
			super.addRowSelectionInterval(0, 0);
		}else if(this.parameterTable != null){
			this.parameterTable.removeAllRows();
		}
	}


	public void setParameterTable(final ParameterTable parameterTable){
		this.parameterTable = parameterTable;
	}


	public Member getSelectedMember(){
		if(this.members != null && super.getSelectedRow() >= 0){
			return this.members[super.getSelectedRow()];
		}
		return null;
	}


	private void setClickListener(){
		super.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(final ListSelectionEvent event) {
				//System.out.println(MethodTable.this.getSelectedRow() + ", " + MethodTable.this.getSelectedColumn());
				if(MethodTable.this.parameterTable != null){
					final int selectedRowIndex = MethodTable.this.getSelectedRow();
					if(selectedRowIndex >= 0){
						MethodTable.this.parameterTable.refreshTable(MethodTable.this.members[selectedRowIndex]);
					}
				}

			}

		});
	}

}

