package ch01.ex16;

import java.io.IOException;

public class BadDataSetException extends Exception{
	public String file;
	public IOException e;
}
