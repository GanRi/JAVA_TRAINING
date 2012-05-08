package ch04.ex01;

public class Battery implements EnergySource {
	private int remainingElectriciy;
	
	public Battery(int electricity){
		remainingElectriciy = electricity;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return remainingElectriciy == 0;
	}

}
