package ch01.ex03;

public class Fibonacci {
	public static void main(String args[]){
		int lo = 1;
		int hi = 1;
		System.out.println("Print out Fibonacci");
		System.out.println(lo);
		while(hi < 50){
			System.out.println( hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
