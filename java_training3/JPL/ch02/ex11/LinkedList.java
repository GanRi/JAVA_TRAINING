package ch02.ex11;

import ch02.ex10.Vehicle;

public class LinkedList {
	public Object obj;
	public LinkedList nextLinkedList;
	
	public LinkedList(Object obj, LinkedList nextLinkedList){
		this.obj = obj;
		this.nextLinkedList = nextLinkedList;
	}
	
	public String toString(){
		String desc = this.obj.toString(); 
		if(this.nextLinkedList != null)
			desc += "  " + this.nextLinkedList.toString();
		return desc;
	}
	
	public static void main(String args[]){
		
		Vehicle car = new Vehicle("Kate");
		car.speed = 2;
		car.direction = 100;
			
		Vehicle bus = new Vehicle("Mike");
		bus.speed = 3;
		bus.direction = 150;
		
		LinkedList linkList2 = new LinkedList(bus, null);
		LinkedList linkList1 = new LinkedList(car, linkList2);
		
		System.out.println(linkList1);
	}
}
