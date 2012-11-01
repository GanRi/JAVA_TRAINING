package ch21.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineSorter {
	public static void main(String[] args) throws IOException{
		FileReader fileReader = new FileReader("JPL/ch21/ex01/testfile.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> list = new ArrayList<String>();
		
		String line;
		while((line = bufferedReader.readLine()) != null){
			list.add(line);
		}
		
		Object[] objectArray = list.toArray();
		String[] stringArray = new String[objectArray.length];
		for(int i = 0; i < stringArray.length; i++){
			stringArray[i] = (String)objectArray[i];
		}
		
		Arrays.sort(stringArray);
		for(String string : stringArray){
			System.out.println(string);
		}
		
	}
}

