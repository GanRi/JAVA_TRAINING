package ch11.ex02;

public class Attr<E> {
	private final String name;
	private E value = null;
	
	public Attr(String name){
		this.name = name;
	}
	
	public Attr(String name, E value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public E getValue(){
		return value;
	}
	
	public E setValue(E newValue){
		E oldValue = value;
		value = newValue;
		return oldValue;
	}
	
	public String toString(){
		return name + "=\'" + value + "\'";
	}
	
	public static void main(String[] args){
		Attr<String> attrCountry = new Attr<String>("Country");
		attrCountry.setValue("Japan");
		System.out.println(attrCountry);
		
		Attr<String> attrCity = new Attr<String>("City");
		attrCity.setValue("Toyko");
		System.out.println(attrCity);		
		
		Attr<Integer> attrPopulation = new Attr<Integer>("Population");
		attrPopulation.setValue(13227914);
		System.out.println(attrPopulation);	
	}
	
}
