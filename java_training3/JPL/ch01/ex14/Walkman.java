package ch01.ex14;

public class Walkman {
	private String plug = null;
	
	public void setPlug(String plug){
		this.plug = plug;
	}
	
	public String getPlug(){
		return plug;
	}
	
	public void play(){
		System.out.println("Play");
	}
	
	public void stop(){
		System.out.println("Stop");
	}
	
}
