package Assignment3;

public abstract class Vehicles { //8 //11
	
	public String destination;
	public String registrationNum;
	public int kilo;
	public int passengers;
	public double price;
	
	public abstract double charge (int numberOfPassengers, int distanceInKilometer);
	
}