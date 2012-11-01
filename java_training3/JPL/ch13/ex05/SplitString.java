package ch13.ex05;

public class SplitString {

	public String split(String str,int splitNum, String spliter) {
		String ans = null;
		int index = str.length() % splitNum;
		if (index == 0)
			index = splitNum;
		ans = str.substring(0, index);
		for (int i = 0; index < str.length(); i++) {
			ans += spliter;
			ans += str.substring(index, index + splitNum);
			index += splitNum;
		}
		return ans;
	}

	public static void main(String[] args) {
		SplitString splitString = new SplitString();
		String str = "8387469847748748292";
		System.out.println(splitString.split(str,3,","));
		str = "998773";
		System.out.println(splitString.split(str,1,","));
		str = "99";
		System.out.println(splitString.split(str,3,","));
	}
}
