package ch03.ex10;

public class Vehicle
{
	private double speed;
	private double angle;
	private String ownerName;
	
	private static int nextID = 0;
	private int ID;
	
	public Vehicle(double speed, double angle, String ownerName)
	{
		this.speed = speed;
		this.angle = angle;
		this.ownerName = ownerName;
		ID = nextID++;
	}
	
	public String toString()
	{
		return "ID: "  + ID +", Ower: " + ownerName +", speed: " + speed + ", angle: " + angle;
	}
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	
}
