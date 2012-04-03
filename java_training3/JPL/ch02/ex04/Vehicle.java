package ch02.ex04;

public class Vehicle {
	
	//IDは変更されないと思われるので、finalとすべきです。
	public int speed;
	public int direction;
	public String owner;
	
	public int ID;
	public static int SeriID = 0;
}
