package ch14.ex06;

public class TimeThread extends Thread{
private Printer printer;
	
	public TimeThread(Printer printer){
		this.printer = printer;
	}
	
	public void run(){
		printer.printTime();
	}
}
