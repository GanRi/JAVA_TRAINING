package ch14.ex06;

public class MessageThread1 extends Thread{
private Printer printer;
	
	public MessageThread1(Printer printer){
		this.printer = printer;
	}
	
	public void run(){
		printer.printMsg1();
	}
}
