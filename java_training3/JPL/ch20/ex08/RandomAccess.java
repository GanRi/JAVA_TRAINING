package ch20.ex08;
import static  java.lang.Math.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
	public static void main(String[] args) throws IOException{

		RandomAccessFile randomSourceFile = new RandomAccessFile("JPL/ch20/ex20_08/source.txt", "r");
		RandomAccessFile randomTableFile = new RandomAccessFile("JPL/ch20/ex20_08/table.hex", "r");
		
		final int ITEM_NUM = 10;
		int index = (int)floor(ITEM_NUM * random());
		System.out.println("Random index = " + index);
		randomTableFile.seek(index * Long.SIZE / 8);
		long pos = randomTableFile.readLong();
		
		
		char lastChar = 0;
		char currentChar = 0;
		int c;
		boolean firstTime = true;
		randomSourceFile.seek(pos);
		while(true){
			
			c = randomSourceFile.read();
			lastChar = currentChar;
			currentChar = (char)c;
			if(lastChar == '%' && currentChar == '%'){
				if(firstTime == true){
					firstTime = false;
					System.out.print(lastChar);
					System.out.print(currentChar);
				}else{
					break;
				}
				
			}
			
			if(currentChar != '%'){
				System.out.print(currentChar);
			}
			
		}
		
	}
	
	
}
