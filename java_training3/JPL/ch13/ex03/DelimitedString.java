package ch13.ex03;

import java.util.ArrayList;
import java.util.List;

public class DelimitedString {
	public String[] delimitedString(String from, char start, char end) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			int startPos = from.indexOf(start, i);
			if (startPos == -1)
				break;
			int endPos = from.indexOf(end, startPos + 1);
			if (endPos == -1)
				break;
			list.add(from.substring(startPos, endPos + 1));
			i = endPos + 1;
		}
		return list.toArray(new String[0]);
	}

	public static void main(String[] args) {
		DelimitedString string = new DelimitedString();
		String[] strs = string.delimitedString("<Hello> <Tokyo><Hello><World> <!> ><", '<', '>');		
		for (String str : strs) {
			System.out.println(str);
		}
		
		strs = string.delimitedString("(2012) (London)(Olympic) (!!!) )(", '(', ')');
		for (String str : strs) {
			System.out.println(str);
		}
		
	}

}
