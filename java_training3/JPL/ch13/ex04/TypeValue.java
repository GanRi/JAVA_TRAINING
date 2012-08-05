package ch13.ex04;

import java.util.ArrayList;
import java.util.List;

public class TypeValue {
	private static List<Object> list = new ArrayList<Object>();

	public List<Object> readTypeValue(String str) {
		String strs[] = str.split("\n");
		for (String string : strs) {
			String[] s = string.split(" ");
			String type = s[0];
			String value = s[1];
			list.add(toObject(type, value));
		}
		return list;
	}

	public Object toObject(String type, String value) {
		if (type.equals("Boolean")) {
			return new Boolean(Boolean.parseBoolean(value));
		} else if (type.equals("Character")) {
			return new Character(value.charAt(0));
		} else if (type.equals("Integer")) {
			return new Integer(Integer.parseInt(value));
		} else if (type.equals("Float")) {
			return new Float(Float.parseFloat(value));
		} else if (type.equals("Double")) {
			return new Double(Double.parseDouble(value));
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		String str = "Boolean true\nCharacter a\nInteger 23\nFloat 11.2\nDouble 8.3333\n";
		TypeValue typeValue = new TypeValue();
		List<Object> list = typeValue.readTypeValue(str);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
