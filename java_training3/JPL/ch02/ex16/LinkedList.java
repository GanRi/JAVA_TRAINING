package ch02.ex16;

import ch02.ex10.Vehicle;

public class LinkedList {
	private Object obj;
	private LinkedList nextLinkedList;
	
	public LinkedList(Object obj, LinkedList nextLinkedList){
		this.obj = obj;
		this.nextLinkedList = nextLinkedList;
	}
	
	public void setObject(Object obj){
		this.obj = obj;
	}
	
	public Object getObject(){
		return this.obj;
	}
	
	public int getObjectNum(){
		if(nextLinkedList == null)
			return 1;
		else
			return 1 + nextLinkedList.getObjectNum();
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
		
		linkList1.setObject(bus);
		linkList2.setObject(car);
		
		System.out.println(linkList1);
		System.out.println("linkList1: " + linkList1.getObjectNum());
		System.out.println("linkList2: " + linkList2.getObjectNum());
	}
}
