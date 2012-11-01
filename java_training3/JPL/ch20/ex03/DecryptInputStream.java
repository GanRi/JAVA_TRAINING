package ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream{
	private byte mask;
	
	protected DecryptInputStream(InputStream in, byte mask) {
		super(in);
		this.mask = mask;
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		return c == -1 ? c : c ^ mask;
	}

	@Override
	public int read(byte[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		
		for(int i = offset; i < last; i++){
			buf[i] = (byte)(buf[i] ^ mask);
		}
		return nread;
		
	}
}

