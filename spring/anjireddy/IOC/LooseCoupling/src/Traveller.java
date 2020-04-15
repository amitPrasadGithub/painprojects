
public class Traveller implements Journey {
	private Vehicle vehicle;
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void startJourney() {
		getVehicle().move();
	}

}
