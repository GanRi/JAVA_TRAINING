package interpret.arraytable;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ArrayTableModel extends DefaultTableModel{
	String[] columnNames = new String[]{"Index", "Value"};

	public ArrayTableModel(){
		super.setColumnIdentifiers(this.columnNames);
	}


	@Override
	public boolean isCellEditable(final int row, final int column) {
		if(column == 1){
			return true;
		}
		return false;
	}


	@Override
	public Class<?> getColumnClass(final int c) {
		if(this.getValueAt(0, c) != null){
			return this.getValueAt(0, c).getClass();
		}else{
			return Object.class;
		}
	}

}
