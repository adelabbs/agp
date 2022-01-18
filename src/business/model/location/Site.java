package business.model.location;

import persistence.edb.operator.Result;

public class Site extends AbstractLocation {

	private int confort;
	private String type;
	
	public Site() {
		super();
	}
	
	public Site(Result result) {
		super(result);
	}


	public Site(String name, Coordinates coordinates, String island, String description, int comfort,
			float pricePerVisit) {
		super(name, coordinates);
		this.island = island;
		this.description = description;
		this.comfort = comfort;
		this.pricePerVisit = pricePerVisit;
	}

	private String island;

	private String description;

	private int comfort;

	private float pricePerVisit;

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

	public int getComfort() {
		return comfort;
	}

	public void setComfort(int comfort) {
		this.comfort = comfort;
	}

	public float getPricePerVisit() {
		return pricePerVisit;
	}

	public void setPricePerVisit(float pricePerVisit) {
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

}
