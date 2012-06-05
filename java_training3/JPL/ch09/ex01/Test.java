package ch09.ex01;

public class Test {
	public static void main(String args[]){
		System.out.println(Float.NEGATIVE_INFINITY + Float.NEGATIVE_INFINITY);
		System.out.println(Float.NEGATIVE_INFINITY - Float.NEGATIVE_INFINITY);
		System.out.println(Float.NEGATIVE_INFINITY * Float.NEGATIVE_INFINITY);
		System.out.println(Float.NEGATIVE_INFINITY / Float.NEGATIVE_INFINITY);
		
		System.out.println(Float.NEGATIVE_INFINITY + Float.POSITIVE_INFINITY);
		System.out.println(Float.NEGATIVE_INFINITY - Float.POSITIVE_INFINITY);
		System.out.println(Float.NEGATIVE_INFINITY * Float.POSITIVE_INFINITY);
		System.out.println(Float.NEGATIVE_INFINITY / Float.POSITIVE_INFINITY);
		
	}
}
