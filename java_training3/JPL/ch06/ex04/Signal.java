package ch06.ex04;

public enum Signal {
	Red(new Color("red")), 
	Green(new Color("green")), 
	Blue(new Color("blue"));
	
	
	Color color;
	Signal(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
}


class Color{
	private String color;
	
	public Color(String color){
		this.color = color;
	}
	
	public String toString(){
		return color;
	}
}