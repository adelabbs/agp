package business.engine;

import java.util.List;

import business.model.Offer;

/**
 * 
 * An implementation of an offer builder must provide a way to set search entry
 * parameters, build the offers and finally get the results.
 *
 */
public interface OfferBuilder {

	void setSearchEntry(SearchEntry searchEntry);

	List<Offer> getOffers();

	void build();
}
