package business.engine;

import java.util.List;

import business.model.Offer;

public interface OfferBuilder {

	void setSearchEntry(SearchEntry searchEntry);
	
	List<Offer> getOffers();
	
	void build();
}
