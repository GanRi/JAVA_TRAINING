package ch13.ex02;

public class StringCounte {

	public int count(String str, String strCounte) {
		int countNum = 0;
		for (int s = 0, e = strCounte.length(); e <= str.length(); ++s, ++e) {
			if (str.subSequence(s, e).equals(strCounte))
				countNum++;
		}

		return countNum;
	}

	public static void main(String[] args) {
		StringCounte stringCounte = new StringCounte();
		final String str = "djdjiipaaanpopaauuukdoaugbuaofkdk";
		String strCounte = "pa";
		System.out.println(strCounte + " in \"" + str + "\": "
				+ stringCounte.count(str, strCounte));
		strCounte = "aa";
		System.out.println(strCounte + " in \"" + str + "\": "
				+ stringCounte.count(str, strCounte));
	}
}
