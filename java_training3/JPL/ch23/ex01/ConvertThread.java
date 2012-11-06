package ch23.ex01;

import java.io.InputStream;
import java.io.OutputStream;

public class ConvertThread extends Thread {
	final InputStream in;
	final OutputStream out;

	public ConvertThread(final InputStream in, final OutputStream out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void run() {
		try {
			int a;
			while ((a = this.in.read()) != -1) {
				this.out.write(a);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
