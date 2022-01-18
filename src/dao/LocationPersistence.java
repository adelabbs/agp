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
	
	/*
	 * 
	 */
	
	/* Mixed Query */
	List<Site> getSiteByParameters(HashMap<String,Object> param);
	
	List<Site> getHotelByParameters(HashMap<String,Object> param);
	
	List<Site> getTransportByParameters(HashMap<String,Object> param); // {"confort" : 3 } { "type" : activity } {....}
	
	/* if confort ==> Rajouter '>=' entre la clé et la valeur
	 *  si on trouve minPrice et maxPrice : {minPrice : 2} {maxPrice : 3}
	 *  	if minPrice, on met "price" >= valueMinPrice
	 *  	else if maxPrice on met "price" <= valueMaxPrice
	 */
	
}
