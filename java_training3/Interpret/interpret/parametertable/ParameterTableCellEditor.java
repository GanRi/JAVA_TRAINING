package interpret.parametertable;

import interpret.utility.ComboBoxFactory;

import java.awt.Component;
import java.util.List;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ParameterTableCellEditor extends DefaultCellEditor{

	List<Object> objectList;
	protected JComboBox comboBox = null;
	protected JTextField textField = null;
	protected JLabel label = null;
	Class<?>[] parameterTypes;

	public   ParameterTableCellEditor(final List<Object> objectList, final Class<?>[] parameterTypes){
		super(new JComboBox());
		this.objectList = objectList;
		this.parameterTypes = parameterTypes;
	}


	@Override
	public Component getTableCellEditorComponent(final JTable table, final Object value,
			final boolean isSelected, final int rowIndex, final int vColIndex) {

		this.init();

		if(value != null)
		{
			if( this.parameterTypes[rowIndex].isPrimitive() || this.parameterTypes[rowIndex] == String.class )
			{
				this.textField = new JTextField(value.toString(),SwingConstants.CENTER);
				return this.textField;
			}else{
				//this.comboBox = ComboBoxFactory.getComboBox(this.objectList, value.getClass());
				//this.comboBox = ComboBoxFactory.getComboBox(this.objectList, this.klass);
				this.comboBox = ComboBoxFactory.getComboBox(this.objectList, this.parameterTypes[rowIndex]);
				this.comboBox.setEditable(true);
				this.comboBox.setSelectedItem(value);
				return this.comboBox;
			}
		}

		//this.label = new JLabel("", SwingConstants.CENTER);
		//return this.label;
		return null;

	}


	// This method is called when editing is completed.
	// It must return the new value to be stored in the cell.
	@Override
	public Object getCellEditorValue() {
		if(this.comboBox != null){
			//test
			final ComboBoxEditor editor = this.comboBox.getEditor();
			final Object item = editor.getItem();
			return item;

		}else if(this.textField != null){
			return this.textField.getText();
		}else{
			//return this.label.getText();
			return null;
		}

	}


	private void init(){
		this.comboBox = null;
		this.textField = null;
		this.label = null;
	}

}
