package ch14.ex04;

public class MultiThread implements Runnable{


	@Override
	public void run() {
		for(int i = 1; i <= 100; i++){
			System.out.println("static: In " + Thread.currentThread().getName() + ": + " + i + ", result = " + Accumulator.add(i));
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
