package persistence;


import java.util.ArrayList;
import java.util.List;

import business.model.location.Coordinates;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.Transport;
import business.spring.SpringIoC;
import dao.LocationPersistence;
import persistence.edb.EDB_API;
import persistence.edb.operator.Operator;
import persistence.edb.operator.Result;
import persistence.edb.operator.SQLOperator;

public class LocationImplementation implements LocationPersistence {
	
	private EDB_API edb;
	private Operator op;
	
	public LocationImplementation(EDB_API edb) {
		this.edb = edb;
	}
	
	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		String query = "SELECT name, price, latitude, longitude, island, beach, transportType FROM hotels WHERE hotels.price >= " + Integer.toString(minPrice) +  " AND hotels.price <=" + Integer.toString(maxPrice);
		SQLOperator operator = (SQLOperator) edb.executeSQLQuery(query);
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		Result result;

		while(operator.hasNext()) {
			result = operator.next();
		
			Hotel hotel = (Hotel) SpringIoC.getBean("hotel");

			hotel.setName((String) result.getObject("name"));
			hotel.setCoordinates(new Coordinates((float) result.getObject("latitude"), (float) result.getObject("longitude")));
			hotel.setPricePerNight((int) result.getObject("price"));
			hotel.setBeach(getHotelsBeach((String) result.getObject("beach")));
			hotel.setIsland((String) result.getObject("island"));
			hotel.setTransport(getLocationsTransport((String) result.getObject("transportType")));
			hotels.add(hotel);
		}
		operator.closeStatement();
		return hotels;
	}

	@Override
	public List<Site> getSiteByPrice(int minPrice, int maxPrice) {
		Operator operator = edb.executeSQLQuery("SELECT name, price, confort, type, latitude, longitude, island, transportType"
				+ " FROM Sites WHERE price >= " + minPrice + " AND " + "price <= " + maxPrice);
		List<Site> sites = new ArrayList<Site>();
		Result result;
		
		while(operator.hasNext()) {
			result = operator.next();
			Site site = (Site) SpringIoC.getBean("site");
			
			site.setName((String) result.getObject("name"));
			site.setPricePerVisit((int) result.getObject("price"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
			site.setCoordinates((new Coordinates((float) result.getObject("latitude"), (float) result.getObject("longitude"))));
			site.setIsland((String) result.getObject("island"));
			site.setTransport(getLocationsTransport((String) result.getObject("transportType")));
			sites.add(site);
		}
		return sites;
	}

	@Override
	public List<Transport> getTransportByPrice(int minPrice, int maxPrice) {

		return null;
	}


	@Override
	public List<Site> getSiteByConfort(int confort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Transport> getAllTransports() {
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
	public Transport getLocationsTransport(String keyTransport) {
		String query = "SELECT type, price, speed, confort FROM transports WHERE transports.type = '" + keyTransport+"'";
		SQLOperator operator = (SQLOperator) edb.executeSQLQuery(query);
		Transport transport = new Transport();
		Result result;

		if(operator.hasNext()) {
			result  = operator.next();
		
			transport.setType((String) result.getObject("type"));
			transport.setSpeed((int) result.getObject("speed"));
			transport.setPrice((int) result.getObject("price"));
			transport.setConfort((int) result.getObject("confort"));
		}
		operator.closeStatement();
		return transport;
	}

	@Override
	public Site getHotelsBeach(String keyBeach) {
		String query = "SELECT name, price, confort, type, latitude, longitude, island, transportType FROM Sites "
				+ "WHERE Sites.name = '" + keyBeach + "'";
		
		SQLOperator operator = (SQLOperator) edb.executeSQLQuery(query);
		
		
		Site site = (Site) SpringIoC.getBean("site");
		Result result;
		
		if(operator.hasNext()) {
			result  = operator.next();

			site.setName((String) result.getObject("name"));
			site.setCoordinates(new Coordinates((float) result.getObject("latitude"), (float) result.getObject("longitude")));
			site.setIsland((String) result.getObject("island"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
		}
		operator.closeStatement();
		return site;
	}

}
