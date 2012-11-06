package ch16.ex09;

import java.io.Serializable;
import java.util.Stack;

public strictfp class Test<K, V extends Number & Runnable>  extends Stack  implements Runnable, Serializable{
	public int publicInt;
	protected double protectedDouble;
	long packageLong;
	private short privateShort;
	public String stringName;
	
	K key;
	V value;
	
	
	public Test(){
		publicInt = 1;
		protectedDouble = 10;
		packageLong = 100;
		privateShort = 1000;
				
		stringName = "10000";
	}
	
	public Test(int pub, double pro, long pac, short pri, String name){
		publicInt = pub;
		protectedDouble = pro;
		packageLong = pac;
		privateShort = pri;
				
		stringName = name;
	}
	

	
	public short getPrivateShort(){
		return privateShort;
	}
	

	
	public void setKey(K key){
		this.key = key;
	}
	
	public K getKey(){
		return key;
	}
	
	public void setValue(V value){
		this.value = value;
	}
	
	public V getValue(){
		return value;
	}
	
	public <E extends Number> void genericMethod(E e){
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

