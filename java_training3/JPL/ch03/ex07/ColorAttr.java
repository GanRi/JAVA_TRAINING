package ch03.ex07;

public class ColorAttr extends Attr{
	private ScreenColor myColor;
	
	public ColorAttr(String name, Object value){
		super(name, value);
		decodeColor();
	}
	
	public ColorAttr(String name){
		this(name,"transparent");
	}
	
	public ColorAttr(String name, ScreenColor value){
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue){
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	public ScreenColor setVlue(ScreenColor newValue){
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	public ScreenColor getColor(){
		return myColor;
	}
	
	protected void decodeColor(){
		if(getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}
	
	public boolean equals(ColorAttr ca){
		return this.getValue().equals(ca.getValue());
	}
	
	public int hashCode(){
		return getValue().hashCode();
	}
	
	
	public static void main(String[] args){
		ColorAttr ca = new ColorAttr("test",new String("red"));
		ColorAttr ca2 = new ColorAttr("test",new String("red"));
		System.out.println(ca.hashCode());
		System.out.println(ca2.hashCode());
		System.out.println(ca.equals(ca2));
	}
}
