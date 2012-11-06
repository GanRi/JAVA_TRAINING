package ch22.ex10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IgnoreComment {
	public static void scan(final Readable source) {

		final Scanner in = new Scanner(source);
		final Pattern COMMENT = Pattern.compile("#.*");
		String comment;
		while (in.hasNext()) {
			if (in.hasNext(COMMENT)) {
				comment = in.findWithinHorizon(COMMENT, 0);
				in.nextLine();
				System.out.println();
			} else {
				System.out.print(in.next());
			}
		}
	}

	public static void main(final String[] args) throws IOException {
		final FileReader reader = new FileReader("JPL/ch22/ex22_10/test.txt");
		IgnoreComment.scan(reader);
	}
}
