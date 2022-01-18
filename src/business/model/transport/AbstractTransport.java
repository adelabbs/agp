package business.model.transport;

public abstract class AbstractTransport {

	private String type;
	private int speed;
	private int price;
	private int comfort;

	public AbstractTransport(String type, int speed, int price, int comfort) {
		this.type = type;
		this.speed = speed;
		this.price = price;
		this.comfort = comfort;
	}

	public AbstractTransport() {

	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getComfort() {
		return comfort;
	}

	public void setComfort(int comfort) {
		this.comfort = comfort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
