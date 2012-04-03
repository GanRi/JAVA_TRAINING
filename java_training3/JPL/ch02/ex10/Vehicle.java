package ch02.ex10;

public class Vehicle {
	public int speed;
	public int direction;
	public String owner;
	
	public int ID;
	public static int SeriID = 0;
	
	public Vehicle(){
		ID = Vehicle.SeriID++;
	}
	
	public Vehicle(String owner){
		this();
		this.owner = owner;
	}
	
	public static int getSeriID(){
		return Vehicle.SeriID - 1;
	}

	public String toString(){
		String desc = "ID:" + this.ID + "  Speed:" + this.speed + "  Direction:" + this.direction + "  Owner:" + this.owner;
		return desc;
	}
		
	public static void main(String args[]){
		Vehicle car = new Vehicle("Kate");
		car.speed = 2;
		car.direction = 100;
		System.out.println(car);		
		
		Vehicle bus = new Vehicle("Mike");
		bus.speed = 3;
		bus.direction = 150;
		System.out.println(bus);
		
		System.out.println("Max SeriID: " + getSeriID());
		
			
	}
}
