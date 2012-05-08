package ch04.ex01;

public class Test {
	public static void main(String[] args){
		Vehicle v1 = new Vehicle(new GasTank(100));
		v1.start();
		
		Vehicle v2 = new Vehicle(new Battery(1000));
		v2.start();	
		
		Vehicle v3 = new Vehicle(new GasTank(0));
		v3.start();
		
		Vehicle v4 = new Vehicle(new Battery(0));
		v4.start();	
		
	}
}
