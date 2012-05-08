package ch03.ex06;

public class Vehicle {
	private final static String TURN_LEFT = "turn_left";
	private final static String TURN_RIGHT = "turn_right";
	
	private int speed;
	private int direction;
	private String owner;
	
	private int ID;
	public static int SeriID = 0;
	
	EnergySource source;
	
	public Vehicle(){
		ID = Vehicle.SeriID++;
	}
	
	public Vehicle(String owner){
		this();
		this.owner = owner;
	} 
	
	public Vehicle(EnergySource source)
	{
		this.source = source;
	}

	public final void setSpeed(int speed){
		this.speed = speed;
	}
	
	public final int getSpeed(){
		return this.speed;
	}
	
	public final void setDirection(int direction){
		this.direction = direction;
	}
	
	public final int getDirection(){
		return this.direction;
	}
	
	public final void setOwner(String owner){
		this.owner = owner;
	}
	
	public final String getOwner(){
		return this.owner; 
	}
	
	public final void changSpeed(int speed){
		this.speed = speed;
	}
	
	public final void stop(){
		this.speed = 0;
	}
	
	public final void turn(int direction){
		this.direction = direction;
	}
	
	public final void turn(String direction){
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
		
	public void start()
	{
		if(source != null)
		{
			if(source.empty() == false)
			{
				System.out.println("start!");
			}
			else
			{
				System.out.println("could not start!");
			}
		}
	}

}
