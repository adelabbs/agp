package business.model.location;


public class Hotel extends AbstractLocation {

	private int pricePerNight;
	private Site beach;

	public Hotel() {
		super();
	}

	public Hotel(String name, Coordinates coordinates, int pricePerNight) {
		super(name, coordinates);
		this.pricePerNight = pricePerNight;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public Site getBeach() {
		return beach;
	}

	public void setBeach(Site beach) {
		this.beach = beach;
	}
	
	public String toString() {
		return "HOTEL = Name : " + name + 
				", Price : " + pricePerNight + 
				", Latitude : " + coordinates.getLatitude() + 
				", Longitude : " + coordinates.getLongitude() + 
				", Island : " + island + 
				", Beach : " + beach.getName() + 
				", TransportType : " + transport.getType();
	}

}
