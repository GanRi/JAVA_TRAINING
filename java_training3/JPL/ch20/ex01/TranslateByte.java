package ch20.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {
	public static void translateByte(InputStream in, OutputStream out, byte from, byte to)
		      throws IOException {
		    int b;
		    while ((b = in.read()) != -1)
		      out.write(b == from ? to : b);
		  }
	
	public static void main(String[] args)
		      throws IOException {
		    byte from = (byte) args[0].charAt(0);
		    byte to = (byte) args[1].charAt(0);
		    translateByte(System.in, System.out, from, to);
		  }
}
