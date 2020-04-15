
public class Car implements Vehicle {
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
		System.out.print("car started :: "+getFuelType()+" :: "+getMaxSpeed());
	}
	
}
