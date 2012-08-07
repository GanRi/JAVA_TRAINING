package ch14.ex06;

public class MessageThread2 extends Thread{
private Printer printer;
	
	public MessageThread2(Printer printer){
		this.printer = printer;
	}
	
	public void run(){
		printer.printMsg2();
	}
}
