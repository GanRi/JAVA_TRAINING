package ch14.ex06;

import java.util.Date;

public class Printer {
	private long startTime;
	private long msgCounter1 = 0;
	private long msgCounter2 = 0;
	
	private long COUNTER1_LIMIT = 15;
	private long COUNTER2_LIMIT = 7;	
	
	public Printer(long startTime){
		this.startTime = startTime;
	}
	
	public synchronized void printTime(){
		while(true){
			try {
				//Thread.sleep(1000);
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			long second = (new Date().getTime() - this.startTime) / 1000;
			System.out.println(second + " second(s) after start");
			notifyAll();
		}
	}
	
	public synchronized void printMsg1(){
		while(true){
			while(msgCounter1 < COUNTER1_LIMIT){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				msgCounter1++;
			}
			
			msgCounter1 = 0;
			System.out.println("Message1 : " + COUNTER1_LIMIT + " seconds have ticked.");
		}
		
	}
	
	public synchronized void printMsg2(){
		while(true){
			while(msgCounter2 < COUNTER2_LIMIT){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				msgCounter2++;
			}
			
			msgCounter2 = 0;
			System.out.println("Message2 : " + COUNTER2_LIMIT + " seconds have ticked.");
		}
	}
}
