package business.model.location;

public class Site extends AbstractLocation {

	public Site() {
		super();
	}

	public Site(String name, Coordinates coordinates, String category, String description, int difficulty,
			float pricePerVisit) {
		super(name, coordinates);
		this.category = category;
		this.description = description;
		this.difficulty = difficulty;
		this.pricePerVisit = pricePerVisit;
	}

	private String category;

	private String description;

	private int difficulty;

	private float pricePerVisit;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public float getPricePerVisit() {
		return pricePerVisit;
	}

	public void setPricePerVisit(float pricePerVisit) {
		this.pricePerVisit = pricePerVisit;
	}

}
