package interpret.parametertable;

import interpret.utility.ComboBoxFactory;

import java.awt.Component;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


@SuppressWarnings("serial")
public class ParameterTableCellRenderer extends DefaultTableCellRenderer
{
	List<Object> objectList;
	JComboBox comboBox = null;
	JTextField textField = null;
	JLabel label = null;
	Class<?>[] parameterTypes;

	public   ParameterTableCellRenderer(final List<Object> objectList, 	final Class<?>[] parameterTypes){
		this.objectList = objectList;
		this.parameterTypes = parameterTypes;
	}


	@Override
	public Component getTableCellRendererComponent(final JTable table,
			final Object value,final boolean isSelected,final boolean hasFocus,
			final int row,final int column)
	{

		this.init();

		if(value != null)
		{
			if(this.parameterTypes[row].isPrimitive() || this.parameterTypes[row] == String.class )
			{
				this.textField = new JTextField(value.toString(),SwingConstants.CENTER);
				return this.textField;
			}else{
				//this.comboBox = ComboBoxFactory.getComboBox(this.objectList, value.getClass());
				//this.comboBox = ComboBoxFactory.getComboBox(this.objectList, this.klass);
				this.comboBox = ComboBoxFactory.getComboBox(this.objectList,  this.parameterTypes[row]);
				this.comboBox.setSelectedItem(value);
				return this.comboBox;
			}
		}

		//this.label = new JLabel("", SwingConstants.CENTER);
		//return this.label;
		return null;
	}


	private void init(){
		this.comboBox = null;
		this.textField = null;
		this.label = null;
	}
}
