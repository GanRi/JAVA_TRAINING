package ch20.ex02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte extends FilterInputStream {
	private byte from;
	private byte to;

	protected TranslateByte(InputStream in, byte from, byte to) {
		super(in);

		this.from = from;
		this.to = to;
	}

	public int read() throws IOException {
		int b = super.read();

		return (b == from ? to : b);
	}

	public int read(byte[] buf, int offset, int count) throws IOException {
		int b = super.read(buf, offset, count);
		int last = offset + b;

		for (int i = offset; i < last; i++) {
			buf[i] = buf[i] == from ? to : buf[i];
		}
		return b;

	}

	public static void main(String[] args) throws IOException {
		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);
		TranslateByte trans = new TranslateByte(System.in, from, to);

		int b;
		while ((b = trans.read()) != -1) {
			System.out.write(b);
		}
	}

}
