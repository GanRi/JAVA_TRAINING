package ch03.ex04;

public class PassengerVehicle extends Vehicle{
	private int seatNum;
	private int passengerNum;
	
	public PassengerVehicle(int seatNum){
		this.seatNum = seatNum;
	}

	public final int getSeatNum() {
		return seatNum;
	}

	public final void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public final int getPassengerNum() {
		return passengerNum;
	}

	public final void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}
	
	public String toString(){
		return super.toString() + " seatNum : " + getSeatNum()+"    passengerNum : " + getPassengerNum();
	}
	
	public static void main(String[] args){
		PassengerVehicle pv1 = new PassengerVehicle(100);
		pv1.setPassengerNum(20);
		pv1.setOwner("Kate");
		System.out.println(pv1);
	
		PassengerVehicle pv2 = new PassengerVehicle(50);
		pv2.setPassengerNum(15);
		pv2.setOwner("Jim");
		System.out.println(pv2);
	
		PassengerVehicle pv3 = new PassengerVehicle(150);
		pv3.setPassengerNum(150);
		pv3.setDirection(250);
		pv3.setOwner("Cathy");
		pv3.setSpeed(1000);
		System.out.println(pv3);	
	
	}

}
