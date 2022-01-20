package business.model.location;

public class Site extends AbstractLocation {

	private int confort;
	
	private float score;

	private String type;

	private String island;

	private String description;

	private int pricePerVisit;

	public Site() {
		super();
	}

	public Site(String name, Coordinates coordinates, String island, String description, int confort,
			int pricePerVisit) {
		super(name, coordinates);
		this.island = island;
		this.description = description;
		this.confort = confort;
		this.pricePerVisit = pricePerVisit;
	}

	public String getIsland() {
		return island;
	}

	public void setIsland(String island) {
		this.island = island;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPricePerVisit() {
		return pricePerVisit;
	}

	public void setPricePerVisit(int pricePerVisit) {
		this.pricePerVisit = pricePerVisit;
	}

	public int getConfort() {
		return confort;
	}

	public void setConfort(int confort) {
		this.confort = confort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String toString() {
		return "SITE = Name : " + name + 
				", Score : " + score + 
				", Price : " + pricePerVisit + 
				", Confort : " + confort + 
				", Latitude : " + coordinates.getLatitude() + 
				", Longitude : " + coordinates.getLongitude()+ 
				", Island : " + island + 
				", TransportType : " + transport.getType();
	}

}
