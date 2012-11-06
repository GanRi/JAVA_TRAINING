package ch23.ex01;

import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public static void plugTogether(final InputStream in, final OutputStream out) {
		new ConvertThread(in, out).start();
	}

	public static void plugTogether(final OutputStream out, final InputStream in) {
		new ConvertThread(in, out).start();
	}

}
