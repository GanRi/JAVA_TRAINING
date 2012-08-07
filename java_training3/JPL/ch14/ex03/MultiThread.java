package ch14.ex03;

public class MultiThread implements Runnable{

	private Accumulator accumulator = new Accumulator();

	@Override
	public void run() {
		for(int i = 1; i <= 100; i++){
			System.out.println("In " + Thread.currentThread().getName() + ": + " + i + ", result = " + accumulator.add(i));
		}
		
	}
	
	public static void main(String[] args){
		MultiThread worker = new MultiThread();
		Thread thread1 = new Thread(worker, "thread1");
		Thread thread2 = new Thread(worker, "thread2");		
		Thread thread3 = new Thread(worker, "thread3");
		Thread thread4 = new Thread(worker, "thread4");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
