package business.engine;

import java.util.List;

import business.model.Offer;

/**
 * The Engine class is the entry point of the offer recommendation process. It
 * used an {@link OfferBuilder} to build the recommendations. A
 * {@link SearchEntry} with at least 1 criteria must be provided for the Engine
 * to be able to build recommendations.
 */
public class Engine {

	private SearchEntry searchEntry;

	private OfferBuilder builder;

	private List<Offer> offers;

	public Engine() {
		builder = new SimpleOfferBuilder();
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

}