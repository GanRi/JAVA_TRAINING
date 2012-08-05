package ch13.ex01;

public class CharCounte {

	public int count(String str, char ch) {
		int countNum = 0;
		for (int i = 0; i < str.length(); i++) {
			Character c = new Character(str.charAt(i));
			if (c.charValue() == ch) {
				countNum++;
			}
		}
		return countNum;
	}

	public static void main(String[] args) {
		CharCounte charCounte = new CharCounte();
		final String str = "djdjiipaaanpouuukdoaugbuaofkdk";
		char c;
		c = 'u';
		System.out.println(c + " in \"" + str + "\": " + charCounte.count(str, c));
		c = 'i';
		System.out.println(c + " in \"" + str + "\": " + charCounte.count(str, c));
	}

}
