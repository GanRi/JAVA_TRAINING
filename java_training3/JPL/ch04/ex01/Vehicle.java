package ch04.ex01;

public class Vehicle 
{
	
	private double speed;
	private double angle;
	private String ownerName;
	
	private static int nextID = 0;
	private int ID;
	
	public static final int TURN_LEFT = 90;
	public static final int TURN_RIGHT = -90;
	
	EnergySource source;
	
	public Vehicle(double speed, double angle, String ownerName)
	{
		this.speed = speed;
		this.angle = angle;
		this.ownerName = ownerName;
		ID = nextID++;
	}
	
	public Vehicle(EnergySource source)
	{
		this.source = source;
	}
	
	public Vehicle()
	{
		ID = nextID++;
	}
	
	public final double getSpeed() {
		return speed;
	}

	public final void setSpeed(double speed) {
		this.speed = speed;
	}

	public final double getAngle() {
		return angle;
	}

	public final void setAngle(double angle) {
		this.angle = angle;
	}

	public final String getOwnerName() {
		return ownerName;
	}

	public final void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public final int getID() {
		return ID;
	}

	public final double changeSpeed(double newSpeed)
	{
		double oldSpeed = speed;
		speed = newSpeed;
	
		return oldSpeed;
	}
	
	public final double stop()
	{
		return changeSpeed(0);
	}
	
	public String toString()
	{
		return "ID: "  + ID +", Ower: " + ownerName +", speed: " + speed + ", angle: " + angle;
	}
	
	
	final void turn(double turnAngle)
	{
		angle += turnAngle;
	}
	
	final void turn(int direction)
	{
		if(direction == Vehicle.TURN_LEFT || direction == Vehicle.TURN_RIGHT)
		turn((double)direction);
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
