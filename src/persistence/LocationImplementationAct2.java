package persistence;

import java.util.List;

import business.model.location.AbstractLocation;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import dao.LocationPersistence;

public class LocationImplementationAct2 implements LocationPersistence {

	@Override
	public List<AbstractLocation> getAbstractLocationByPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSiteByPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSiteByDifficulty(int minDifficulty, int maxDifficulty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

}
