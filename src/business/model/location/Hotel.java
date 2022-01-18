package business.model.location;


public class Hotel extends AbstractLocation {

	private float pricePerNight;
	private Site beach;

	public Hotel() {
		super();
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

	public Site getBeach() {
		return beach;
	}

	public void setBeach(Site beach) {
		this.beach = beach;
	}

}
