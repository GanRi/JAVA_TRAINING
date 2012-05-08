package ch03.ex07;

public class Attr 
{
	private final String name;
	private Object value = null;
	
	public Attr(String name)
	{
		this.name = name;
	}
	
	public Attr(String name, Object value)
	{
		this.name = name;
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	
	public Object setValue(Object newValue) {
		Object oldValue = value;
		this.value = newValue;
		return oldValue;
	}
	
	public String toString()
	{
		return name + "='" + value +"'"; 
	}
	
}
