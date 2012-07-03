package ch12.ex01;

public class ObjectNotFoundException extends Exception{
	Object ob;
	
	public ObjectNotFoundException(Object ob){
		this.ob = ob;
	}
}
