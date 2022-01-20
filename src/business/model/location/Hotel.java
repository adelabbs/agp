package business.model.location;


public class Hotel extends AbstractLocation {

	private Site beach;

	public Hotel() {
		super();
	}

	public Hotel(String name, Coordinates coordinates, int pricePerNight) {
		super(name, coordinates);
		super.setPrice(pricePerNight); 
	}

	public int getPricePerNight() {
		return getPrice();
	}

	public void setPricePerNight(int pricePerNight) {
		setPrice(pricePerNight);
	}

	public Site getBeach() {
		return beach;
	}

	public void setBeach(Site beach) {
		this.beach = beach;
	}
	
	public String toString() {
		return "HOTEL = Name : " + name + 
				", Price : " + getPrice() + 
				", Latitude : " + coordinates.getLatitude() + 
				", Longitude : " + coordinates.getLongitude() + 
				", Island : " + island + 
				", Beach : " + beach.getName() + 
				", TransportType : " + transport.getType();
	}

}
