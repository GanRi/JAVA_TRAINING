package interpret.fieldtable;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;


@SuppressWarnings("serial")
public class FieldTableCellRenderer extends DefaultTableCellRenderer
{
	List<Object> objectList;
	JComboBox comboBox = null;
	JTextField textField = null;
	JLabel label = null;
	Class<?>[] parameterTypes;

	public FieldTableCellRenderer(final List<Object> objectList, final Class<?>[] parameterTypes){
		
	}

	private void init(){
		this.comboBox = null;
		this.textField = null;
		this.label = null;
	}
}
