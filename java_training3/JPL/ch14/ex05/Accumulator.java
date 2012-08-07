package ch14.ex05;

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
	
	
	public static long minus(int value){
		synchronized(Accumulator.class){
			long temp = sum - value;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum = temp;
			return sum;
		}
	}
}
