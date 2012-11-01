package ch20.ex04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineFilterReader extends FilterReader {
	protected LineFilterReader(Reader arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public String readLine() throws IOException {
		StringBuilder sb = new StringBuilder();

		int c;

		while ((c = super.read()) != -1) {

			if (c == '\r') // CR
				continue;

			if (c == '\n') // LF
				return sb.toString();

			sb.append((char) c);
		}

		if (sb.toString().length() == 0)
			return null;
		else
			return sb.toString();
	}

	public static void main(String[] args) {
		try {
			LineFilterReader reader = new LineFilterReader(new FileReader(new File(
					"JPL/ch20/ex04/testfile.txt")));
			System.out.println(reader.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
