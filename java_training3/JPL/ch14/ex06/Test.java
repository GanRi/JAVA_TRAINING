package ch14.ex06;

import java.util.Date;

public class Test {
	public static void main(String[] args){
		long startTime = new Date().getTime();
		Printer printer = new Printer(startTime);
		
		TimeThread timeThread = new TimeThread(printer);
		MessageThread1 msgThread1 = new MessageThread1(printer);
		MessageThread2 msgThread2 = new MessageThread2(printer);
		
		timeThread.start();
		msgThread1.start();
		msgThread2.start();
		
	}

}
