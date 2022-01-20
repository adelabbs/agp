package persistence;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import business.model.location.Coordinates;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.Transport;
import business.spring.SpringIoC;
import dao.LocationPersistence;
import persistence.edb.EdbAPI;
import persistence.edb.ExecutionPlan1;
import persistence.edb.operator.MixedOperatorPA1;
import persistence.edb.operator.Operator;
import persistence.edb.operator.Result;
import persistence.edb.operator.SQLOperator;

public class EDBLocationPersistence implements LocationPersistence {
	
	private EdbAPI edb;
	
	public EDBLocationPersistence(String tableName, String key, String userDirPath) {
		this.edb = new ExecutionPlan1(tableName, key, userDirPath);
	}
	
	@Override
	public List<Site> getSiteByParameters(HashMap<String, Object> param) {
		/* Create dynamic query */
		String query = "SELECT * FROM " + edb.getTableName();
		if(param.size() > 1) {
			query += " WHERE";
			
	        Iterator<Entry<String, Object>> iter = param.entrySet().iterator();
			
	        boolean foundKeywords = false;
			while (iter.hasNext()) {
	            Entry<String, Object> entry = iter.next();
	            String key = entry.getKey();
	            switch(key) {
	            case "confort":
	            	query += " confort >= " + entry.getValue();
	            	break;
	            case "minPrice":
	            	query += " price >= " + entry.getValue();
	            	break;
	            case "maxPrice":
	            	query += " price <= " + entry.getValue();
	            	break;
	            case "speed": 
	            	query += " speed >= " + entry.getValue();
	            	break;
	            case "keywords":
	            	foundKeywords = true;
	            	break;
	            default:
	            	query += " " + key + " = '" + entry.getValue() + "'";
	            	break;
	            }
	            
	            if(iter.hasNext() && !foundKeywords) {
	            	query += " AND";
	            }
	            foundKeywords = false;
			}
			
			@SuppressWarnings("unchecked")
			List<String> keywords = (List<String>) param.get("keywords");
			
			if(keywords != null) {
				query += " with";
				for(String keyword : keywords) {
					query += " " + keyword;
				}
			}
		}
		System.out.println("FULL QUERY : " + query);

		MixedOperatorPA1 operator = (MixedOperatorPA1) edb.executeMixedQuery(query);
		List<Site> sites = new ArrayList<Site>();
		Result result;
		
		while(operator.isExistMixedResults() && operator.hasNext()) {
			result = operator.next();
			Site site = (Site) SpringIoC.getBean("site");
			
			site.setName((String) result.getObject("name"));
			site.setScore((float) result.getObject("score"));
			site.setPricePerVisit((int) result.getObject("price"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
			site.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			site.setIsland((String) result.getObject("island"));
			site.setTransport(getLocationsTransport((String) result.getObject("transportType")));

			sites.add(site);
			System.out.println(site.toString());
		}
		return sites;
		
	}

	@Override
	public List<Hotel> getHotelByParameters(HashMap<String, Object> param) {
		if(param.size() == 0) {
			throw new IllegalArgumentException("No parameters found");
		}
		
		/* Create dynamic query */
		String query = "SELECT name, price, latitude, longitude, island, beach, transportType FROM hotels";

		query += " WHERE";
		
        Iterator<Entry<String, Object>> iter = param.entrySet().iterator();
		
		while (iter.hasNext()) {
            Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            switch(key) {
            case "minPrice":
            	query += " price >= " + entry.getValue();
            	break;
            case "maxPrice":
            	query += " price <= " + entry.getValue();
            	break;
            case "speed": 
            	query += " speed >= " + entry.getValue();
            	break;
            default:
            	query += " " + key + " = '" + entry.getValue() + "'";
            	break;
            }
            if(iter.hasNext()) {
            	query += " AND";
            }
		}
		
		System.out.println("FULL QUERY : " + query);
		SQLOperator operator = edb.executeSQLQuery(query);
		List<Hotel> hotels = new ArrayList<Hotel>();
		Result result;
	
		while(operator.existResultSet() && operator.hasNext()) {
			result  = operator.next();
		
			Hotel hotel = (Hotel) SpringIoC.getBean("hotel");

			hotel.setName((String) result.getObject("name"));
			hotel.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			hotel.setPricePerNight((int) result.getObject("price"));
			hotel.setBeach(getHotelsBeach((String) result.getObject("beach")));
			hotel.setIsland((String) result.getObject("island"));
			hotel.setTransport(getLocationsTransport((String) result.getObject("transportType")));
			hotels.add(hotel);
			System.out.println(hotel.toString());
		}
		return hotels;
	}

	@Override
	public List<Transport> getTransportByParameters(HashMap<String, Object> param) {
		if(param.size() == 0) {
			throw new IllegalArgumentException("No parameters found");
		}
		
		/* Create dynamic query */
		String query = "SELECT type, price, speed, confort FROM transports";

		query += " WHERE";
		
        Iterator<Entry<String, Object>> iter = param.entrySet().iterator();
		
		while (iter.hasNext()) {
            Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            switch(key) {
            case "confort":
            	query += " confort >= " + entry.getValue();
            	break;
            case "minPrice":
            	query += " price >= " + entry.getValue();
            	break;
            case "maxPrice":
            	query += " price <= " + entry.getValue();
            	break;
            case "speed": 
            	query += " speed >= " + entry.getValue();
            	break;
            default:
            	query += " " + key + " = '" + entry.getValue() + "'";
            	break;
            }
            if(iter.hasNext()) {
            	query += " AND";
            }
		}
		
		System.out.println("FULL QUERY : " + query);
		SQLOperator operator = edb.executeSQLQuery(query);
		List<Transport> transports = new ArrayList<Transport>();
		Result result;
	
		while(operator.existResultSet() && operator.hasNext()) {
			result  = operator.next();
		
			Transport transport = new Transport();
			
			transport.setType((String) result.getObject("type"));
			transport.setSpeed((int) result.getObject("speed"));
			transport.setPrice((int) result.getObject("price"));
			transport.setConfort((int) result.getObject("confort"));
			transports.add(transport);
			System.out.println(transport.toString());
		}
		return transports;
	}
	
	@Override
	public List<Site> getSiteByKeywords(List<String> keywords) {
		String query = "SELECT name, price, confort, type, latitude, longitude, island, transportType "
				+ "FROM " + edb.getTableName() + " with";
		for(String keyword : keywords) {
			query += " " + keyword;
		}
		
		MixedOperatorPA1 operator = (MixedOperatorPA1) edb.executeMixedQuery(query);
		List<Site> sites = new ArrayList<Site>();
		Result result;
		
		while(operator.hasNext()) {
			result = operator.next();
			Site site = (Site) SpringIoC.getBean("site");
			
			site.setName((String) result.getObject("name"));
			site.setScore((float) result.getObject("score"));
			site.setPricePerVisit((int) result.getObject("price"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
			site.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			site.setIsland((String) result.getObject("island"));
			site.setTransport(getLocationsTransport((String) result.getObject("transportType")));

			sites.add(site);
			System.out.println(site.toString());
		}
		return sites;
	}
	
	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		String query = "SELECT name, price, latitude, longitude, island, beach, transportType FROM hotels WHERE hotels.price >= " + Integer.toString(minPrice) +  " AND hotels.price <=" + Integer.toString(maxPrice);
		SQLOperator operator = edb.executeSQLQuery(query);
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		Result result;

		while(operator.hasNext()) {
			result = operator.next();
		
			Hotel hotel = (Hotel) SpringIoC.getBean("hotel");

			hotel.setName((String) result.getObject("name"));
			hotel.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			hotel.setPricePerNight((int) result.getObject("price"));
			hotel.setBeach(getHotelsBeach((String) result.getObject("beach")));
			hotel.setIsland((String) result.getObject("island"));
			hotel.setTransport(getLocationsTransport((String) result.getObject("transportType")));
			hotels.add(hotel);
			System.out.println(hotel.toString());
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
			site.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			site.setIsland((String) result.getObject("island"));
			site.setTransport(getLocationsTransport((String) result.getObject("transportType")));
			sites.add(site);
			System.out.println(site.toString());
		}
		return sites;
	}

	@Override
	public List<Transport> getTransportByPrice(int minPrice, int maxPrice) {
		String query = "SELECT type, price, speed, confort FROM transports WHERE price >= " + minPrice + 
				" AND " + "price <= " + maxPrice;
		
		SQLOperator operator = (SQLOperator) edb.executeSQLQuery(query);
		List<Transport> transports = new ArrayList<Transport>();
		Result result;

		while(operator.hasNext()) {
			result  = operator.next();
		
			Transport transport = new Transport();
			
			transport.setType((String) result.getObject("type"));
			transport.setSpeed((int) result.getObject("speed"));
			transport.setPrice((int) result.getObject("price"));
			transport.setConfort((int) result.getObject("confort"));
			transports.add(transport);
			System.out.println(transport.toString());
		}
		operator.closeStatement();
		return transports;
	}


	@Override
	public List<Site> getSiteByConfort(int confort) {
		Operator operator = edb.executeSQLQuery("SELECT name, price, confort, type, latitude, longitude, island, transportType"
				+ " FROM Sites WHERE confort >= " + confort);
		List<Site> sites = new ArrayList<Site>();
		Result result;
		
		while(operator.hasNext()) {
			result = operator.next();
			Site site = (Site) SpringIoC.getBean("site");
			
			site.setName((String) result.getObject("name"));
			site.setPricePerVisit((int) result.getObject("price"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
			site.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			site.setIsland((String) result.getObject("island"));
			site.setTransport(getLocationsTransport((String) result.getObject("transportType")));
			sites.add(site);
		}
		return sites;
	}


	@Override
	public List<Transport> getAllTransports() {
		String query = "SELECT type, price, speed, confort FROM transports";
		SQLOperator operator = (SQLOperator) edb.executeSQLQuery(query);
		List<Transport> transports = new ArrayList<Transport>();
		Result result;

		while(operator.hasNext()) {
			result  = operator.next();
		
			Transport transport = new Transport();
			
			transport.setType((String) result.getObject("type"));
			transport.setSpeed((int) result.getObject("speed"));
			transport.setPrice((int) result.getObject("price"));
			transport.setConfort((int) result.getObject("confort"));
			transports.add(transport);
		}
		operator.closeStatement();
		return transports;
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
			site.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			site.setIsland((String) result.getObject("island"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
			sites.add(site);
		}
		return sites;
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
			site.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			site.setIsland((String) result.getObject("island"));
			site.setConfort((int) result.getObject("confort"));
			site.setType((String) result.getObject("type"));
		}
		operator.closeStatement();
		return site;
	}

	@Override
	public List<Hotel> getAllHotels() {
		String query = "SELECT name, price, latitude, longitude, island, beach, transportType FROM hotels";
		SQLOperator operator = edb.executeSQLQuery(query);
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		Result result;

		while(operator.hasNext()) {
			result = operator.next();
		
			Hotel hotel = (Hotel) SpringIoC.getBean("hotel");

			hotel.setName((String) result.getObject("name"));
			hotel.setCoordinates(new Coordinates((float) result.getObject("longitude"), (float) result.getObject("latitude")));
			hotel.setPricePerNight((int) result.getObject("price"));
			hotel.setBeach(getHotelsBeach((String) result.getObject("beach")));
			hotel.setIsland((String) result.getObject("island"));
			hotel.setTransport(getLocationsTransport((String) result.getObject("transportType")));
			hotels.add(hotel);
			System.out.println(hotel.toString());
		}
		operator.closeStatement();
		return hotels;
	}



}
