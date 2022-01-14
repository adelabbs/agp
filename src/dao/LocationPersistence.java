package dao;

import java.util.List;

import business.model.location.AbstractLocation;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;

public interface LocationPersistence {
	List<AbstractLocation> getAbstractLocationByPrice(int minPrice, int maxPrice);

	List<Hotel> getHotelByPrice(int minPrice, int maxPrice);

	List<Site> getSiteByType(int type);

	List<Site> getSiteByPrice(int minPrice, int maxPrice);

	List<Site> getSiteByDifficulty(int minDifficulty, int maxDifficulty);

	List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice);
}
