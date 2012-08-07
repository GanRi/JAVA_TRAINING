package ch14.ex04;

public class Accumulator {	
	private static long sum = 0;

	public static synchronized long add(int value){
		long temp = sum + value;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sum = temp;
		return sum;
	}
}
