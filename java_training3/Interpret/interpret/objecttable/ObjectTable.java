package interpret.objecttable;

import interpret.InterpretFrame;
import interpret.fieldtable.FieldTable;
import interpret.methodtable.MethodTable;
import interpret.utility.UtilityClass;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ObjectTable  extends JTable{
	DefaultTableModel tableModel = new ObjectTableModel();
	List<Object> objectList;

	FieldTable fieldTable;
	MethodTable methodTable;

	InterpretFrame interpretFrame;

	boolean updateRelatedTables = true;

	public ObjectTable(final List<Object> objectList){
		this.objectList = objectList;

		super.setModel(this.tableModel);
		super.setRowHeight((int)(super.getRowHeight() * 1.5) );
		this.setClickListener();
		super.setPreferredScrollableViewportSize(new Dimension(500, 250));
		this.refreshTable();

		final ListSelectionModel selectionModel=super.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}


	public void refreshTable(){
		this.updateRelatedTables = true;
		final int rowNum = this.tableModel.getRowCount();
		final int selectedRowIndex = super.getSelectedRow();

		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}

		int index = 0;
		for(final Object object : this.objectList){
			//this.tableModel.addRow(new Object[]{object.getClass().toString(), object.hashCode(), object.toString()});
			if(object.getClass().isArray() == false){
				this.tableModel.addRow(new Object[]{index++, object.getClass().toString(), object.toString()});
			}else{
				final String arrayString = UtilityClass.arrayToString(object);
				this.tableModel.addRow(new Object[]{index++, object.getClass().toString(), arrayString});
			}

		}

		if(selectedRowIndex >= 0){
			super.addRowSelectionInterval(selectedRowIndex, selectedRowIndex);
		}
	}


	public void refreshTable(final boolean updateRelatedTables){
		this.updateRelatedTables = updateRelatedTables;

		final int rowNum = this.tableModel.getRowCount();
		final int selectedRowIndex = super.getSelectedRow();
		for(int i = 0; i < rowNum; i++){
			this.tableModel.removeRow(0);
		}

		int index = 0;
		for(final Object object : this.objectList){
			//this.tableModel.addRow(new Object[]{object.getClass().toString(), object.hashCode(), object.toString()});
			if(object.getClass().isArray() == false){
				this.tableModel.addRow(new Object[]{index++, object.getClass().toString(), object.toString()});
			}else{
				final String arrayString = UtilityClass.arrayToString(object);
				this.tableModel.addRow(new Object[]{index++, object.getClass().toString(), arrayString});
			}
		}

		if(selectedRowIndex >= 0){
			super.addRowSelectionInterval(selectedRowIndex, selectedRowIndex);
		}
	}


	public void setFieldTable(final FieldTable fieldTable){
		this.fieldTable = fieldTable;
	}


	public void setMethodTable(final MethodTable methodTable){
		this.methodTable = methodTable;
	}


	public void setInterpretFrame(final InterpretFrame interpretFrame){
		this.interpretFrame = interpretFrame;
	}

	public Object getSelectedObject(){
		if(this.objectList != null && super.getSelectedRow() >= 0){
			return this.objectList.get(super.getSelectedRow());
		}
		return null;
	}


	private void setClickListener(){

		super.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(final MouseEvent event) {
				if (event.getButton() == MouseEvent.BUTTON1) {
					ObjectTable.this.updateRelatedTables = true;

					final boolean isArray = ObjectTable.this.getSelectedObject().getClass().isArray();
					if(event.getClickCount() == 2 && isArray == true){

					}
				}
			}

		});

		super.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(final ListSelectionEvent event) {
				//ObjectTable.this.refreshTable();
				if(ObjectTable.this.updateRelatedTables == false){
					return;
				}

				final Object selectedObject = ObjectTable.this.getSelectedObject();
				if(ObjectTable.this.fieldTable == null || selectedObject == null){
					return;
				}
				ObjectTable.this.fieldTable.refreshTable(selectedObject);

				final Class<?> selectedClass = selectedObject.getClass();
				if(ObjectTable.this.methodTable== null || selectedClass == null){
					return;
				}
				ObjectTable.this.methodTable.refreshTable(selectedClass);
			}

		});
	}
}
