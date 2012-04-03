package ch01.ex15;

public class LookupExpInstance implements LookupExp{
	
	private String[] names;
	private Object[] values;

	public Object find(String name){
		for(int i = 0; i < names.length; i ++){
			if(names[i].equals(name))
				return values[i];
		}
		return null;
	}
	
	public void add(Object value, String name){
		for(int i = 0; i < names.length; i ++){
			if(names[i].equals(name))
				values[i] = value;
		}
	}
	
	public void remove(String name){
		for(int i = 0; i < names.length; i ++){
			if(names[i].equals(name))
				values[i] = null;
		}
	}
}
