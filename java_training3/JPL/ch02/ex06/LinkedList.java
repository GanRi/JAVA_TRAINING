package ch02.ex06;

import ch02.ex05.Vehicle;

public class LinkedList {
	public Object obj;
	public LinkedList nextLinkedList;
	
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
		
		LinkedList linkList2 = new LinkedList();
		linkList2.obj = bus;
		linkList2.nextLinkedList = null;
		
		LinkedList linkList1 = new LinkedList();
		linkList1.obj = car;
		linkList1.nextLinkedList = linkList2;	
	}
}
