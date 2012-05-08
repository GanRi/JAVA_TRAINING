package ch06.ex02;

public class VehicleTest 
{
	public static void main(String[] args)
	{
		Vehicle vehicle = new Vehicle(9, 100, "bluewind");
		
		System.out.println(vehicle);
		vehicle.turn(45.0);
		System.out.println(vehicle);			
		vehicle.turn(Direction.TURN_LEFT);
		System.out.println(vehicle);			
		vehicle.turn(Direction.TURN_RIGHT);		
		System.out.println(vehicle);		
		
		test();
	}
	
	
	static void fun(double d){
		System.out.println("fun double");
	}
	
	static void fun(float f){
		System.out.println("fun float");
	}	
	
	static void test(){
		fun(1);
		int i = 1;
		fun(i);
	}
}
