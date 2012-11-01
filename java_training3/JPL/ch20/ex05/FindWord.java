package ch20.ex05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindWord{
	public static void find(String word, String fileName)throws IOException{
		FileReader fileReader = new FileReader(fileName);
		LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
		
		String line;
		while((line = lineNumberReader.readLine()) != null){

			if(line.indexOf(word) != -1){
				int lineNumber = lineNumberReader.getLineNumber();
				line = lineNumber + " : " + line;
				System.out.println(line);
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException{
		find("hello", "JPL/ch20/ex05/testfile.txt");
	}
}