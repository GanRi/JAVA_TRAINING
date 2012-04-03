package ch01.ex10;

public class Fibonacci {
	public static final int SIZE = 9;
	private static FibonacciValue[] fibonacci = new FibonacciValue[SIZE];

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		fibonacci[0] = new FibonacciValue(lo, (lo%2 == 0));
		int i = 1;
		while(hi < 50){
			fibonacci[i] =new FibonacciValue (hi, (hi%2 == 0));
			hi = lo + hi;
			lo = hi - lo;
			i++;
		}
		
		for(int j = 0; j < SIZE; j++){
			System.out.print((j+1) + ": " + fibonacci[j].getValue());
			if(fibonacci[j].getIsOven())
				System.out.println(" *");
			else
				System.out.println("");
		}
	}

}
