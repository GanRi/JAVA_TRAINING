package ch22.ex12;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ScannerVersion {

	public static Attributed readAttrs(final Reader source) throws IOException {

		final Scanner in = new Scanner(source);
		final AttributedImpl attrs = new AttributedImpl();
		// final String exp = "^([a-zA-Z0-9 ]+)=([a-zA-Z0-9 ]+)[#]*$";
		// final String exp = "^([a-zA-Z0-9 ]+)=([a-zA-Z0-9 ]+)";
		final String exp = "^([a-zA-Z0-9 ]+)=([a-zA-Z0-9 ]+)(.*)$|"
				+ "^([a-zA-Z0-9 ]+)=([a-zA-Z0-9 ]+)#(.*)$";

		final Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			final String line = in.findInLine(pat);
			if (line != null) {
				final String[] cells = new String[2];
				final MatchResult match = in.match();
				for (int i = 0; i < 2; i++) {
					cells[i] = match.group(i + 1);
				}
				final Attr attr = new Attr(cells[0], cells[1]);
				attrs.add(attr);

				if (in.hasNextLine()) {
					in.nextLine(); // skip newline
				}
			} else {
				final String unmatchLine = in.nextLine();
				if (!"".equals(unmatchLine)) {
					throw new IOException("input format error");
				}
			}
		}

		return attrs;
	}
}
