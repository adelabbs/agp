package persistence;

import java.util.LinkedList;
import java.util.List;

import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import business.spring.SpringIoC;
import dao.LocationPersistence;

public class MockPersistence implements LocationPersistence {

	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		LinkedList<Hotel> hotels = new LinkedList<Hotel>();
		Hotel cheapHotel = (Hotel) SpringIoC.getBean("cheapHotel");
		if (cheapHotel.getPricePerNight() >= minPrice && cheapHotel.getPricePerNight() <= maxPrice) {
			hotels.add(cheapHotel);
		}

		Hotel expensiveHotel = (Hotel) SpringIoC.getBean("expensiveHotel");
		if (expensiveHotel.getPricePerNight() >= minPrice && expensiveHotel.getPricePerNight() <= maxPrice) {
			hotels.add(expensiveHotel);
		}
		return hotels;
	}

	@Override
	public List<Site> getSiteByPrice(int minPrice, int maxPrice) {
		LinkedList<Site> sites = new LinkedList<Site>();
		Site easyLeasureSite = (Site) SpringIoC.getBean("easyLeasureSite");
		Site difficultLeasureSite = (Site) SpringIoC.getBean("difficultLeasureSite");

		if (easyLeasureSite.getPricePerVisit() >= minPrice && easyLeasureSite.getPricePerVisit() <= maxPrice) {
			sites.add(easyLeasureSite);
		}

		if (difficultLeasureSite.getPricePerVisit() >= minPrice
				&& difficultLeasureSite.getPricePerVisit() <= maxPrice) {
			sites.add(difficultLeasureSite);
		}
		return sites;
	}

	@Override
	public List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice) {
		return new LinkedList<AbstractTransport>();
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

	@Override
	public AbstractTransport getLocationsTransport(String keyTransport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site getHotelsBeach(String keyBeach) {
		// TODO Auto-generated method stub
		return null;
	}

}
