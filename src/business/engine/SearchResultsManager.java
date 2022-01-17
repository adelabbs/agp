package business.engine;

import java.util.LinkedList;
import java.util.List;

import business.model.Offer;

public class SearchResultsManager {

	List<Offer> offers = new LinkedList<Offer>();

	public List<Offer> getOffers() {
		return offers;
	}

	public void addOffer(Offer offer) {
		if (!offers.contains(offer)) {
			offers.add(offer);
		}
	}

	public void removeOffer(Offer offer) {
		offers.remove(offer);
	}

}
