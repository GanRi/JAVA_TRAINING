package ch06.ex04;

public class SignalTest {
	public static void main(String[] args){
		Signal red = Signal.Red;
		System.out.println(red);
		System.out.println(red.getColor());
		
		Signal green = Signal.Green;
		System.out.println(green);	
		System.out.println(green.getColor());
	}
}
