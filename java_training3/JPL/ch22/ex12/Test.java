package ch22.ex12;

import java.io.FileReader;
import java.util.Iterator;

public class Test {
	public static void main(final String[] args) {

		try {
			final FileReader reader = new FileReader(
					"JPL/ch22/ex22_12/test.txt");
			final Attributed attributed = TokenizerVersion.readAttrs(reader);
			System.out.println("StreamTokenizer version");
			final Iterator<Attr> iterator = attributed.attrs();
			while (iterator.hasNext()) {
				final Attr attr = iterator.next();
				System.out.println(attr);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

		try {
			final FileReader reader = new FileReader(
					"JPL/ch22/ex22_12/test.txt");
			final Attributed attributed = ScannerVersion.readAttrs(reader);
			System.out.println("\nScanner version");
			final Iterator<Attr> iterator = attributed.attrs();
			while (iterator.hasNext()) {
				final Attr attr = iterator.next();
				System.out.println(attr);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
