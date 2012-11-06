package ch23.ex02;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Exec {
	public static String[] test() throws Exception {
		try {
			// start up the command
			final String[] cmdArray = { "java" };
			final Process child = Runtime.getRuntime().exec(cmdArray);
			final InputStream lsOut = child.getInputStream();
			final InputStreamReader r = new InputStreamReader(lsOut);
			final LineNumberReader in = new LineNumberReader(r);
			// read the command's output
			final List<String> lines = new ArrayList<String>();
			String line;
			while ((line = in.readLine()) != null) {
				lines.add(in.getLineNumber() + ": " + line);
			}
			if (child.waitFor() != 0) {
				throw new Exception("dir failed");
			}
			return lines.toArray(new String[lines.size()]);
		} catch (final Exception e) {
			throw e;
		}
	}

	public static void main(final String[] args) throws Exception {
		final String[] strs = Exec.test();
		for (final String str : strs) {
			System.out.println(str);
		}

	}
}
