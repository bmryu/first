package Assignment3;

public class Taxi extends Vehicles{
	@Override
	public double charge(int numberOfPassengers, int distanceInKilometer) {
		passengers = numberOfPassengers;
		kilo = distanceInKilometer;
		
		price =  2500 + (kilo*750) + ((passengers-1)*1500);
		
		return price;
	}
}
