package ch22.ex11;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CSV {

	public static List<String> readCSV(final Reader source) throws IOException {
		final StreamTokenizer in = new StreamTokenizer(source);
		in.whitespaceChars(',', ',');
		in.ordinaryChar(' ');
		final List<String> vals = new ArrayList<String>();

		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_NUMBER) {
				vals.add(String.valueOf(in.nval));
			}
		}

		return vals;
	}

	public static void main(final String[] args) throws IOException {
		final FileReader reader = new FileReader("JPL/ch22/ex22_11/test.txt");
		final List<String> list = CSV.readCSV(reader);

		for (final String e : list) {
			System.out.print(e + ", ");
		}

	}
}
