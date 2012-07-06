package ch10.ex02;

public class ConvertWord {
	public static String convertWord(String str) {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '\n':
				string.append('\\');
				string.append('n');
				break;
			case '\t':
				string.append('\\');
				string.append('t');
				break;
			case '\b':
				string.append('\\');
				string.append('b');
				break;
			case '\r':
				string.append('\\');
				string.append('r');
				break;
			case '\f':
				string.append('\\');
				string.append('f');
				break;
			case '\\':
				string.append('\\');
				string.append('\\');
				break;
			case '\'':
				string.append('\\');
				string.append('\'');
				break;
			case '\"':
				string.append('\\');
				string.append('\"');
				break;
			default:
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
