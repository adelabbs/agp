package persistence;


import java.util.ArrayList;
import java.util.List;

import business.model.location.Coordinates;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import business.spring.SpringIoC;
import dao.LocationPersistence;
import persistence.edb.EDB_API;
import persistence.edb.operator.Operator;
import persistence.edb.operator.Result;

public class LocationImplementation implements LocationPersistence {
	
	private EDB_API edb;
	private Operator op;
	
	public LocationImplementation(EDB_API edb) {
		this.edb = edb;
	}
	
	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		String query = "SELECT name, price, latitude, longitude, island, beach, transportType FROM HOTELS WHERE HOTELS.price >= " + Integer.toString(minPrice) +  "AND HOTELS.price <=" + Integer.toString(maxPrice);
		Operator operator = edb.executeSQLQuery(query);
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		Result result;

		while(operator.hasNext()) {
			result  = operator.next();
		
			Hotel hotel = (Hotel) SpringIoC.getBean("hotel");

			hotel.setName((String) result.getObject("name"));
			hotel.setCoordinates(new Coordinates((float) result.getObject("latitude"), (float) result.getObject("longitude")));
			hotel.setPricePerNight((float) result.getObject("price"));
			hotels.add(hotel);
		}
		return hotels;
	}

	@Override
	public List<Site> getSiteByPrice(int minPrice, int maxPrice) {
		edb.executeSQLQuery("SELECT * FROM Sites WHERE price >= " + minPrice + " AND " + "price <= " + maxPrice);
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
		String query = "SELECT name, price, confort, type, latitude, longitude, island, transportType FROM Sites "
				+ "INNER JOIN Hotels ON Sites.name = Hotels.beach";
		
		Operator operator = edb.executeSQLQuery(query);
		
		List<Site> sites = new ArrayList<Site>();
		Result result;

		while(operator.hasNext()) {
			result  = operator.next();
		
			Site site = (Site) SpringIoC.getBean("site");

			site.setName((String) result.getObject("name"));
			site.setCoordinates(new Coordinates((float) result.getObject("latitude"), (float) result.getObject("longitude")));
			site.setIsland((String) result.getObject("island"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
			sites.add(site);
		}
		return sites;
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
