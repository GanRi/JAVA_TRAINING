package ch03.ex09;

public class Garage implements Cloneable
{
	Vehicle[] vector;
	
	public Garage(Vehicle ...vehicles)
	{
		vector = vehicles;
	}
	
	public Garage clone()throws CloneNotSupportedException
	{
		Garage garage = (Garage)super.clone();
		garage.vector = vector.clone();
		for(int i = 0; i < garage.vector.length; i++)
		{
			garage.vector[i] = garage.vector[i].clone();
		}
		return garage;
	}
	
	public static void main(String[] args)throws CloneNotSupportedException
	{
		Garage g = new Garage(new Vehicle(), new Vehicle(), new Vehicle());
		Garage g2 = g.clone();
		
	}
}
