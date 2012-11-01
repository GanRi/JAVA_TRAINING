package ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream{
	private byte mask;
	
	public EncryptOutputStream(OutputStream out, byte mask) {
		super(out);
		this.mask = mask;
	}
	
	
	@Override
	public void write(int b) throws IOException {
		super.write(b ^ mask);
	}
	
}

