
public class Bike implements Vehicle {

	private String fuelType;
	private int maxSpeed;
	
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void move() {
		System.out.print("\n Bike started :: "+getFuelType()+" :: "+getMaxSpeed());
	}

}
