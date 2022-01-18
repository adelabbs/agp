package persistence;

import java.util.List;

import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import dao.LocationPersistence;

public class LocationImplementationAct2 implements LocationPersistence {



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
	public List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSiteByConfort(int confort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<AbstractTransport> getAllTransports() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Site> getHotelsBeaches() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Site> getSiteByKeywords(List<String> keywords) {
		// TODO Auto-generated method stub
		return null;
	}

}
