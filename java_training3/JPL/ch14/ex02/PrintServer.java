package ch14.ex02;

public class PrintServer implements Runnable{
	private final PrintQueue requests = new PrintQueue();
	private final long workerId;
	
	public PrintServer(){
		Thread worker = new Thread(this);
		workerId = worker.getId();
		worker.start();
	}
	
	@Override
	public void run(){
		if(Thread.currentThread().getId() != workerId){
			System.out.println("not the expected thread");
			return;
		}
		
		for(;;){
			realPrint(requests.remove());
		}
		
	}
	
	private void realPrint(PrintJob job){
		System.out.println("real print");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		PrintServer server = new PrintServer();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		server.run();
	}
	
}
