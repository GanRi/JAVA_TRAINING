package interpret.utility;

import java.util.List;

import javax.swing.JComboBox;

public class ComboBoxFactory {
	public static JComboBox getComboBox(List<Object> objectList, Class<?> klass){
		List<Object> subList = UtilityClass.findSubList(objectList, klass);;
    	JComboBox comboBox = new JComboBox();
		int listSize = subList.size();
		for(int i = 0; i < listSize; i++){
			comboBox.addItem(subList.get(i));
		}
		return comboBox;
	}

}
