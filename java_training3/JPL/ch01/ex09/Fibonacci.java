package ch01.ex09;

public class Fibonacci {
	public static final int SIZE = 9;
	private static int[] fibonacci = new int[SIZE];

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		fibonacci[0] = lo;
		int i = 1;
		while(hi < 50){
			fibonacci[i] = hi;
			hi = lo + hi;
			lo = hi - lo;
			i++;
		}
		
		for(int j = 0; j < SIZE; j++)
			System.out.println(fibonacci[j]);
	}

}
