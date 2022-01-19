package dao;

import java.util.HashMap;
import java.util.List;

import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.Transport;

public interface LocationPersistence {
	
	/* SQL Methods */
	List<Hotel> getHotelByPrice(int minPrice, int maxPrice);

	List<Site> getSiteByPrice(int minPrice, int maxPrice);

	List<Site> getSiteByConfort(int confort);

	List<Transport> getTransportByPrice(int minPrice, int maxPrice);
	
	List<Transport> getAllTransports();
	
	Transport getLocationsTransport(String keyTransport);
	
	List<Site> getHotelsBeaches();
	
	Site getHotelsBeach(String keyBeach);
	
	/* Lucene Methods */
	List<Site> getSiteByKeywords(List<String> keywords);
	
	/* Mixed Query */
	List<Site> getSiteByParameters(HashMap<String,Object> param);
	
	List<Hotel> getHotelByParameters(HashMap<String,Object> param);
	
	List<Transport> getTransportByParameters(HashMap<String,Object> param);
	

	
}
