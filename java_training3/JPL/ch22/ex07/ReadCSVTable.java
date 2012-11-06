package ch22.ex07;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadCSVTable {
	// static final int CELLS = 4;

	public static List<String[]> readCSVTable(final Readable source,
			final int num) throws IOException {
		final Scanner in = new Scanner(source);
		final List<String[]> vals = new ArrayList<String[]>();
		// final String exp = "^(.*),(.*),(.*),(.*)";

		String exp = "^";
		for (int i = 0; i < num; i++) {
			if (i == num - 1) {
				exp += "([^,]*)";
			} else {
				exp += "([^,]*),";
			}
		}
		exp += "$";

		final Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			final String line = in.findInLine(pat);
			if (line != null) {
				final String[] cells = new String[num];
				final MatchResult match = in.match();
				for (int i = 0; i < num; i++) {
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
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
		final IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return vals;
	}

	public static void main(final String[] args) throws IOException {
		final FileReader reader = new FileReader("JPL/ch22/ex22_07/test.txt");
		final List<String[]> vals = ReadCSVTable.readCSVTable(reader, 5);

		for (final String[] strings : vals) {
			System.out.println(Arrays.toString(strings));
		}
	}
}
