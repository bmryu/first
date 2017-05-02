package Assignment3;

public class Shuttle extends Vehicles {

	@Override
	public double charge(int numberOfPassengers, int distanceInKilometer) {
		passengers = numberOfPassengers;
		kilo = distanceInKilometer;
		
		price = (passengers*700) + (kilo*100);
		
		return price;
	}
}
