package business.engine;

import java.util.List;

public interface OfferBuilder {
	
	void setKeywords(List<String> keywords);
	
	void setPriceRange(int minPrice, int maxPrice);
	
	void setDaysOfStay(int nbDays);
	
	void setComfortPreference(int comfortPreference);
	
	void setNbOffers(int nbOffers);

}
