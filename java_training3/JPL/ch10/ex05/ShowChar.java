package ch10.ex05;

public class ShowChar {
	public void getSequence(char a, char b){
		char begin;
		char end;
		
		if(a < b){
			begin = a;
			end = b;
		}else{
			begin = b;
			end = a;
		}
		
		while(begin <= end){
			System.out.print(begin++);
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		ShowChar showChar = new ShowChar();
		showChar.getSequence('a', 'z');
		showChar.getSequence('9', '1');
		showChar.getSequence('a', '1');
		showChar.getSequence('1', 'a');
		
	}

}
