package business.engine;

import java.util.List;

public interface OfferBuilder {
	
	void setKeywords(List<String> keywords);
	
	void setPriceRange(int minPrice, int maxPrice);
	
	void setDaysOfStay(int nbDays);
	
	void setDifficultyPreference(int comfortLevel);
	
	void setNbOffers(int nbOffers);

}
