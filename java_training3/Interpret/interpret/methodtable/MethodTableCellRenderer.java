package interpret.methodtable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


@SuppressWarnings("serial")
public class MethodTableCellRenderer extends DefaultTableCellRenderer
{

	@Override
	public Component getTableCellRendererComponent(final JTable table,
			final Object value,final boolean isSelected,final boolean hasFocus,
			final int row,final int column)
	{

		if(this.needColor((String)value)) {
			this.setForeground(Color.RED);
		}else{
			this.setForeground(Color.BLACK);
		}

		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);


	}


	private boolean needColor(final String value){
		if(value.contains("setVisible") || value.contains("setTitle")
				|| value.contains("setSize") || value.contains("setBackground")){
			return true;
		}else{
			return false;
		}
	}


}
