package ch02.ex15;

public class Vehicle {
	private int speed;
	private int direction;
	private String owner;
	
	private int ID;
	public static int SeriID = 0;
	
	public Vehicle(){
		ID = Vehicle.SeriID++;
	}
	
	public Vehicle(String owner){
		this();
		this.owner = owner;
	} 
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public int getDirection(){
		return this.direction;
	}
	
	public void setOwner(String owner){
		this.owner = owner;
	}
	
	public String getOwner(){
		return this.owner; 
	}
	
	public void changSpeed(int speed){
		this.speed = speed;
	}
	
	public void stop(){
		this.speed = 0;
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
		car.setSpeed(2);
		car.setDirection(100);
		car.changSpeed(112);
		System.out.println(car);		
		
		Vehicle bus = new Vehicle("Mike");
		bus.setSpeed(3);
		bus.setDirection(150);
		bus.changSpeed(155);
		System.out.println(bus);
		
		bus.stop();
		System.out.println(bus);
		
		System.out.println("Max SeriID: " + getSeriID());
		
			
	}
}
