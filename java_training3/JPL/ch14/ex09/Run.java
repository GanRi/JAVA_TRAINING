package ch14.ex09;

public class Run implements Runnable{

	private int sleepSeconds;
	
	public Run(int sleepSeconds){
		this.sleepSeconds = sleepSeconds;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(sleepSeconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
