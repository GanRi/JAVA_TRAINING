package ch03.ex06;

public class Battery extends EnergySource {
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
