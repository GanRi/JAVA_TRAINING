package ch01.ex07;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		int hi = 34;
		int lo = 21;
		String mark;
		for(int i = MAX_INDEX; i>=2; i--){
			if(hi%2 == 0)
				mark = " *";
			else
				mark = "";
			System.out.println(i +": " + hi + mark);
			lo = hi - lo;
			hi = hi- lo;
		}
		System.out.println("1: " + hi);
		

	}

}
