package ch14.ex03;

public class Accumulator {
	private long sum = 0;
	public  synchronized long add(int value){
		

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
