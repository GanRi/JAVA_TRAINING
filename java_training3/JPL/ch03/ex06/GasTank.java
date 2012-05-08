package ch03.ex06;

public class GasTank extends EnergySource {

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
