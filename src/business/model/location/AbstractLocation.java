package business.model.location;

public abstract class AbstractLocation {

	private String name;

	private Coordinates coordinates;
	
	public AbstractLocation() {
		
	}

	public AbstractLocation(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}
