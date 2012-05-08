package ch03.ex08;

public class PassengerVehicle extends Vehicle{
	private int seatNum;
	private int passengerNum;
	
	public PassengerVehicle(int seatNum){
		this.seatNum = seatNum;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}
	
	public String toString(){
		return super.toString() + " seatNum : " + getSeatNum()+"    passengerNum : " + getPassengerNum();
	}
	
	public static void main(String[] args){
		PassengerVehicle pv1 = new PassengerVehicle(100);
		PassengerVehicle pv2 = null;
		try
		{
			pv2 = (PassengerVehicle)pv1.clone();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(pv2 instanceof Cloneable);
	}
	


}
