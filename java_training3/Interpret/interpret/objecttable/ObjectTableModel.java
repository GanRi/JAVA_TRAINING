package interpret.objecttable;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
class ObjectTableModel extends DefaultTableModel{

	String[] columnNames = new String[]{"Object No.", "Class", "Value"};

	public ObjectTableModel(){
		super.setColumnIdentifiers(this.columnNames);
	}


	@Override
	public boolean isCellEditable(final int row, final int column) {
		return false;
	}

}
