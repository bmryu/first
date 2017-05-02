package Assignment3;

public class Jcsv {
	private String regNum;
	private String destination;
	private String kilo;
	private String passengers;

	
	public Jcsv(String regNum, String destination, String kilo, String passengers) {
		this.regNum = regNum;
		this.destination = destination;
		this.kilo = kilo;
		this.passengers = passengers;
//	System.out.println(regNum+" "+destination+" "+kilo+" "+passengers);
	}
	
	public int getKilo(){
		int kiloInt = Integer.parseInt(kilo);	
		return kiloInt;
	}
	
	public int getPassengers(){
		int passengerInt = Integer.parseInt(passengers);	
		return passengerInt;
	}
	public String getDestination(){
		return destination;
	}

	public String getRegNum(){
		return regNum;
	}
}