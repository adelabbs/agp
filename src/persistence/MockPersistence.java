package persistence;

import java.util.LinkedList;
import java.util.List;

import business.model.location.AbstractLocation;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import business.spring.SpringIoC;
import dao.LocationPersistence;

public class MockPersistence implements LocationPersistence {

	@Override
	public List<AbstractLocation> getAbstractLocationByPrice(int minPrice, int maxPrice) {
		return null;
	}

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
	public List<Site> getSiteByType(int type) {
		return new LinkedList<Site>();
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
	public List<Site> getSiteByDifficulty(int minDifficulty, int maxDifficulty) {
		return new LinkedList<Site>();
	}

	@Override
	public List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice) {
		return new LinkedList<AbstractTransport>();
	}

}
