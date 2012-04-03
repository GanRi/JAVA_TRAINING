package ch01.ex10;

public class FibonacciValue {
	
		private int value;
		private boolean isOven;
		
		FibonacciValue(int value, boolean isOven){
			this.value = value;
			this.isOven = isOven;
		}
		
		int getValue(){
			return value;
		}
		
		boolean getIsOven(){
			return isOven;
		}
}
