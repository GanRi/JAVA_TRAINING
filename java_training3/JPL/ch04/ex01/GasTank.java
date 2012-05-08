package ch04.ex01;

public class GasTank implements EnergySource {

	private int remainingGas;
	
	public GasTank(int gas){
		remainingGas = gas;
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return remainingGas == 0;
	}

}
