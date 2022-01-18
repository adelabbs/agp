package business.model.location;

import persistence.edb.operator.Result;

public class Hotel extends AbstractLocation {

	private float pricePerNight;
	private Site beach;

	public Hotel() {
		super();
	}
	
	public Hotel(Result result) {
		super(result);
	}


	public Hotel(String name, Coordinates coordinates, float pricePerNight) {
		super(name, coordinates);
		this.pricePerNight = pricePerNight;
	}

	public float getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(float pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

}
