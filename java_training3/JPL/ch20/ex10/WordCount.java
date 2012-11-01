package ch20.ex10;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class WordCount {

	
	public static void main(String[] args) throws IOException{
		FileReader fileReader = new FileReader("JPL/ch20/ex10/testfile.txt");
		StreamTokenizer token = new StreamTokenizer(fileReader);
		Map<String, Integer> map  = new HashMap<String, Integer>();
		
		while(token.nextToken() != StreamTokenizer.TT_EOF){
			if(token.ttype == StreamTokenizer.TT_WORD){
				String word = token.sval;
				Integer frequency = map.get(word);
				if(frequency == null){
					map.put(word, 1);
				}else{
					map.put(word, frequency + 1);
				}
			}
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> entry : entrySet){
			System.out.println(entry.getKey() + " : " + entry.getValue() + " time(s)");
		}
		
	}
}

