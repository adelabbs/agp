package business.engine;

import java.util.List;

import business.model.Offer;
import dao.LocationPersistence;
import persistence.EDBLocationPersistence;

/**
 * The Engine class is the entry point of the offer recommendation process. It
 * used an {@link OfferBuilder} to build the recommendations. A
 * {@link SearchEntry} with at least 1 criteria must be provided for the Engine
 * to be able to build recommendations.
 */
public class Engine {
	
	private String tableName = "sites";
	private String key = "name";
	private String userDirPath = System.getProperty("user.home") + "/agp_crete/lucene/sites";
	
	private LocationPersistence locationPersistence;

	private SearchEntry searchEntry;

	private OfferBuilder builder;

	private List<Offer> offers;

	public Engine() {
		locationPersistence = new EDBLocationPersistence(tableName, key, userDirPath);
		builder = new SimpleOfferBuilder();
		builder.setLocationPersistence(locationPersistence);
	}

	public void buildRecommendations() {
		if (searchEntry != null) {
			builder.setSearchEntry(searchEntry);
			builder.build();
			offers = builder.getOffers();
		}
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public SearchEntry getSearchEntry() {
		return searchEntry;
	}

	public void setSearchEntry(SearchEntry searchEntry) {
		this.searchEntry = searchEntry;
	}

	public void createDescription(String key, String description) {
		locationPersistence.createDescription(key, description);
	}

}