package ch20.ex08;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateTable {
//	public static void main(String[] args) throws IOException{
//		String oldSeparator = System.setProperty("line.separator", "%%%%");
//		System.out.println(oldSeparator);
//		System.out.println(System.getProperty("line.separator"));
//		
//		RandomAccessFile randomFile = new RandomAccessFile("JPL/ch20/ex20_08/source.txt", "r");
//		
//		FileOutputStream fileOutputStream = new FileOutputStream("JPL/ch20/ex20_08/table.hex");
//		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
//		
//		String line;
//		while((line = randomFile.readLine() )!= null){
//			long pos = randomFile.getFilePointer();
//			dataOutputStream.writeLong(pos);
//			System.out.println(pos + "  : " + line);
//		}
//		
//		randomFile.close();
//		fileOutputStream.close();
//		dataOutputStream.close();
//	}
	
	
	
	public static void main(String[] args) throws IOException{
		char lastChar = 0;
		char currentChar = 0;
		
		RandomAccessFile randomFile = new RandomAccessFile("JPL/ch20/ex20_08/source.txt", "r");
		
		FileOutputStream fileOutputStream = new FileOutputStream("JPL/ch20/ex20_08/table.hex");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		
		int c;
		long fileLength = randomFile.length();
		for(int i = 0; i < fileLength; i++){
			
			c = randomFile.read();
			lastChar = currentChar;
			currentChar = (char)c;
			if(lastChar == '%' && currentChar == '%'){
				long pos = randomFile.getFilePointer();
				dataOutputStream.writeLong(pos - 2);
				System.out.println(pos -2);
			}
		}
		
		
		randomFile.close();
		fileOutputStream.close();
		dataOutputStream.close();
	}
}
