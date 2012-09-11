package interpret.methodtable;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
class MethodTableModel extends DefaultTableModel{
	String[] columnNames = new String[]{"Method"};

	public MethodTableModel(){
		super.setColumnIdentifiers(this.columnNames);
	}

	@Override
	public boolean isCellEditable(final int row, final int column) {
		return false;
	}

}
