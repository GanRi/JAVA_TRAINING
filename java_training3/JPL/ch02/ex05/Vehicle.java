package ch02.ex05;

public class Vehicle {
	public int speed;
	public int direction;
	public String owner;
	
	public int ID;
	public static int SeriID = 0;

	public void show(String name){
		System.out.println(name);
		System.out.println("ID= " + this.ID);
		System.out.println("Speed=" + this.speed);
		System.out.println("Direction=" + this.direction);
		System.out.println("Owner=" + this.owner);
	}
	
	public static void main(String args[]){
		Vehicle car = new Vehicle();
		car.ID = Vehicle.SeriID++;
		car.speed = 2;
		car.direction = 100;
		car.owner = "Kate";
		car.show("car");
		
		Vehicle bus = new Vehicle();
		bus.ID = Vehicle.SeriID++;
		bus.speed = 3;
		bus.direction = 150;
		bus.owner = "Mike";
		bus.show("bus");
			
	}
}
