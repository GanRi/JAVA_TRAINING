package ch22.ex02;

import java.util.Arrays;
import java.util.HashSet;

public class WhichChars {
	private final HashSet<Character> hashSet = new HashSet<Character>();

	public WhichChars(final String str) {
		for (int i = 0; i < str.length(); i++) {
			this.hashSet.add(str.charAt(i));
		}
	}

	@Override
	public String toString() {
		final Character[] chars = this.hashSet.toArray(new Character[0]);
		Arrays.sort(chars);

		final StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < chars.length; i++) {
			sb.append(chars[i]);
		}
		sb.append("]");

		return sb.toString();
	}
}
