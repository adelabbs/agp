package business.model.transport;

public abstract class AbstractTransport {
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public abstract float calculatePrice();

}
