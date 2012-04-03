package ch02.ex08;

import ch02.ex05.Vehicle;

public class LinkedList {
	public Object obj;
	public LinkedList nextLinkedList;
	
	public LinkedList(Object obj, LinkedList nextLinkedList){
		this.obj = obj;
		this.nextLinkedList = nextLinkedList;
	}
	
	public static void main(String args[]){
		
		Vehicle car = new Vehicle();
		car.ID = Vehicle.SeriID++;
		car.speed = 2;
		car.direction = 100;
		car.owner = "Kate";
		
		Vehicle bus = new Vehicle();
		bus.ID = Vehicle.SeriID++;
		bus.speed = 3;
		bus.direction = 150;
		bus.owner = "Mike";
		
		LinkedList linkList2 = new LinkedList(bus, null);
		LinkedList linkList1 = new LinkedList(car, linkList2);
	}
}
