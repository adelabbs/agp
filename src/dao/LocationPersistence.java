package dao;

import java.util.List;

import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;

public interface LocationPersistence {
	
	// SQL Methods
	List<Hotel> getHotelByPrice(int minPrice, int maxPrice);

	List<Site> getSiteByPrice(int minPrice, int maxPrice);

	List<Site> getSiteByConfort(int confort);

	List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice);
	
	List<AbstractTransport> getAllTransports();
	
	List<Site> getHotelsBeaches();
	
	// Lucene Methods
	List<Site> getSiteByKeywords(List<String> keywords);
	
}
