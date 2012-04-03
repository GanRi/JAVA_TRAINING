package ch02.ex18;

public class Vehicle {
	private final static String TURN_LEFT = "turn_left";
	private final static String TURN_RIGHT = "turn_right";
	
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
	
	public void turn(int direction){
		this.direction = direction;
	}
	
	public void turn(String direction){
		if(TURN_LEFT.equals(direction))
			this.direction = 90;
		else if(TURN_RIGHT.equals(direction))
			this.direction = 270;
	}
	
	public static int getSeriID(){
		return Vehicle.SeriID -1;
	}

	public String toString(){
		String desc = "ID:" + this.ID + "  Speed:" + this.speed + "  Direction:" + this.direction + "  Owner:" + this.owner;
		return desc;
	}
		
	public static void main(String args[]){
		
		for(int i= 0; i< args.length; i++){
			Vehicle car = new Vehicle(args[i]);
			car.setSpeed(2);
			car.setDirection(100);
			System.out.println(car);	
		}
		
		System.out.println("Max SeriID: " + getSeriID());
	}
}
