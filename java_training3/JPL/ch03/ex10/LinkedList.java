package ch03.ex10;

public class LinkedList implements Cloneable
{
	private Object data;
	private LinkedList next;
	
	public LinkedList(Object data)
	{
		this(data, null);
	}
	
	public LinkedList(Object data, LinkedList next)
	{
		this.data = data;
		this.next = next;
	}
	
	
	
	public void append(LinkedList... nodes)
	{
		if(nodes == null || nodes.length == 0 || nodes[0] == null)
		{
			return;
		}
		LinkedList current = this;
		for(LinkedList node : nodes)
		{
			node.next = current.next;
			current.next = node;
			current = node;
		}
		
		
	}
	
	public String toString()
	{
		if(next != null)
		{
			return data.toString() + "-->\n" + next.toString();
		}
		else
		{
			return data.toString();
		}
	}
	
	Object getData()
	{
		return this.data;
	}
	
	public LinkedList clone()throws CloneNotSupportedException
	{
		LinkedList list = (LinkedList) super.clone();
		if(list.next != null)
		{
			list.next = list.next.clone();
		}
		return list;
	}
	
	
	public static void main(String[] args)throws CloneNotSupportedException
	{

		Vehicle vehicle1 = new Vehicle(100.1, 188.0, "bluewind");
		Vehicle vehicle2 = new Vehicle(1001.13, 180.0, "leo");		
		Vehicle vehicle3 = new Vehicle(200.1, 18.0, "tom");	
		Vehicle vehicle4 = new Vehicle(1001.13, 180.0, "kate");		
		Vehicle vehicle5 = new Vehicle(200.1, 18.0, "jackson");	
		
		LinkedList nodea = new LinkedList(vehicle1);
		LinkedList nodeb = new LinkedList(vehicle2);
		LinkedList nodec = new LinkedList(vehicle3);
		LinkedList noded = new LinkedList(vehicle4);
		LinkedList nodee = new LinkedList(vehicle5);	
		
		nodea.append(nodeb);
		nodeb.append(nodec, noded, nodee);
		System.out.println(nodea);
		
		LinkedList cloneList = nodea.clone();
		System.out.println(cloneList);		
		
		
		((Vehicle)nodea.getData()).setSpeed(9999999);
		System.out.println(nodea);
		System.out.println(cloneList);	
		
		
	}
}
