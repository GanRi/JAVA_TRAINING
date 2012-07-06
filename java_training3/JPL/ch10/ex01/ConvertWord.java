package ch10.ex01;

public class ConvertWord {
	public static String convertWord(String str) {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '\n') {
				string.append('\\');
				string.append('n');
			} else if (c == '\t') {
				string.append('\\');
				string.append('t');
			} else if (c == '\b') {
				string.append('\\');
				string.append('b');
			} else if (c == '\r') {
				string.append('\\');
				string.append('r');
			} else if (c == '\f') {
				string.append('\\');
				string.append('f');
			} else if (c == '\\') {
				string.append('\\');
				string.append('\\');
			} else if (c == '\'') {
				string.append('\\');
				string.append('\'');
			} else if (c == '\"') {
				string.append('\\');
				string.append('\"');
			} else {
				string.append(c);
			}

		}

		return string.toString();
	}

	public static void main(String[] args) {
		String str = new String("1234\n5678\r90\\abc\'defg\\hijk\"lmn");
		System.out.println(str);

		String result = convertWord(str);
		System.out.println(result);
	}

}
