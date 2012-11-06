package ch23.ex03;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Exec {
	public static void test(final String specifiedString) throws Exception {
		try {
			// start up the command
			final String[] cmdArray = { "java" };
			final Process child = Runtime.getRuntime().exec(cmdArray);
			final InputStream lsOut = child.getInputStream();
			final InputStreamReader r = new InputStreamReader(lsOut);
			final LineNumberReader in = new LineNumberReader(r);
			// read the command's output
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(in.getLineNumber() + ": " + line);
				if (line.contains(specifiedString)) {
					child.destroy();
					break;
				}
			}
		} catch (final Exception e) {
			throw e;
		}
	}

	public static void main(final String[] args) throws Exception {
		Exec.test("-version");
	}
}
