package persistence;

import java.util.LinkedList;
import java.util.List;

import business.model.location.AbstractLocation;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import dao.LocationPersistence;

public class MockPersistence implements LocationPersistence {

	@Override
	public List<AbstractLocation> getAbstractLocationByPrice(int minPrice, int maxPrice) {		
		return null;
	}

	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		LinkedList<Hotel> hotels = new LinkedList<Hotel>();
		
		return null;
	}

	@Override
	public List<Site> getSiteByType(int type) {
		return null;
	}

	@Override
	public List<Site> getSiteByPrice(int minPrice, int maxPrice) {
		return null;
	}

	@Override
	public List<Site> getSiteByDifficulty(int minDifficulty, int maxDifficulty) {
		return null;
	}

	@Override
	public List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice) {
		return null;
	}

}
