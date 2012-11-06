package ch22.ex14;

import java.util.StringTokenizer;

public class Sum {
	public static double sum(final String source) {
		final StringTokenizer tokens = new StringTokenizer(source, " ");
		double total = 0;
		while (tokens.hasMoreTokens()) {
			final String value = tokens.nextToken();
			final Double d = Double.valueOf(value);
			total += d;
		}
		return total;
	}

	public static void main(final String[] args) {
		final String str = "1.111 3 8.888";
		System.out.println(Sum.sum(str));
	}
}
