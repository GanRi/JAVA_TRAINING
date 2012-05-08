package ch06.ex02;

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
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getID() {
		return ID;
	}

	public double changeSpeed(double newSpeed)
	{
		double oldSpeed = speed;
		speed = newSpeed;
	
		return oldSpeed;
	}
	
	public double stop()
	{
		return changeSpeed(0);
	}
	
	public String toString()
	{
		return "ID: "  + ID +", Ower: " + ownerName +", speed: " + speed + ", angle: " + angle;
	}

	void turn(double turnAngle)
	{
		angle += turnAngle;
	}
	
	void turn(Direction direction)
	{
		if(direction == Direction.TURN_LEFT)
			turn((double)90);
		else if (direction == Direction.TURN_RIGHT)
			turn((double)-90);
	}
}
