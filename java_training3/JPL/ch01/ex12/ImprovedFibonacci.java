package ch01.ex12;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		String[] fibonacci = new String[MAX_INDEX];
		int hi = 34;
		int lo = 21;
		String mark;
		for(int i = MAX_INDEX; i>=2; i--){
			if(hi%2 == 0)
				mark = " *";
			else
				mark = "";
			fibonacci[MAX_INDEX - i] = i + ": " + hi + mark;
			lo = hi - lo;
			hi = hi- lo;
		}
		
		for(int i = 0; i< MAX_INDEX-1; i++)
			System.out.println(fibonacci[i]);
		System.out.println("1: " + hi);

	}

}
