package ch03.ex02;

public abstract class X {
	{
		trace();
	}
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	{
		trace();
	}	
	
	protected static int stepIndex = 0;
	
	public X(){
		fullMask = xMask;
		trace();
	}
	
	public int mask(int orig){
		return (orig & fullMask);
	}
	
	public abstract void trace();
	
	public static void main(String[] args){
		System.out.printf("stepIndex\txMask\tyMask\tfullMask%n");
		Y y = new Y();
	}
}

class Y extends X {
	
	protected int yMask = 0xff00;
	
	{
		trace();
	}	
	
	public Y(){
		fullMask |= yMask;
		trace();
	}
	
	public void trace(){
		System.out.printf("%d\t\t%04x\t%04x\t%04x%n",stepIndex++, xMask, yMask, fullMask);
	}
}

