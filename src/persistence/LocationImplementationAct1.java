package persistence;


import java.util.ArrayList;
import java.util.List;
import business.model.location.Coordinates;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import business.spring.SpringIoC;
import dao.LocationPersistence;
import persistence.edb.PlanAct1;
import persistence.edb.operator.Operator;
import persistence.edb.operator.Result;
import persistence.edb.operator.SQLOperator;

public class LocationImplementationAct1 implements LocationPersistence {
	
	PlanAct1 bde;
	Operator op;
	

	public LocationImplementationAct1() {
		bde = new PlanAct1(null, null, null);
	}
	
	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		String query = "SELECT * FROM HOTELS WHERE HOTELS.price >= " + Integer.toString(minPrice) +  "AND HOTELS.price <=" + Integer.toString(maxPrice);
		SQLOperator operator = (SQLOperator) bde.executeSQLQuery(query);
		List<Hotel> hotels = new ArrayList<Hotel>();
		Result result = new Result();
		Hotel hotel = (Hotel) SpringIoC.getBean("hotel");
		String keyname, keyPrice, keyLat, keyLong;
		
		operator.init();
		
		while(operator.hasNext()) {
			result  = operator.next();
			
			keyname = operator.getColumnNames().get(1);
			keyPrice = operator.getColumnNames().get(2);
			keyLat = operator.getColumnNames().get(3);
			keyLong = operator.getColumnNames().get(4);
			
			hotel.setName((String) result.getObject(keyname));
			hotel.setCoordinates(new Coordinates((float) result.getObject(keyLat), (float) result.getObject(keyLong)));
			hotel.setPricePerNight((float) result.getObject(keyPrice));
			hotels.add(hotel);
		}
		return hotels;
	}

	@Override
	public List<Site> getSiteByPrice(int minPrice, int maxPrice) {
		bde.executeSQLQuery("SELECT * FROM Sites WHERE price >= " + minPrice + " AND " + "price <= " + maxPrice);
		return null;
	}

	@Override
	public List<AbstractTransport> getTransportByPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Site> getSiteByConfort(int confort) {
		bde.executeSQLQuery("SELECT * FROM Sites WHERE confort <= " + confort);
		return null;
	}


	@Override
	public List<AbstractTransport> getAllTransports() {
		bde.executeSQLQuery("SELECT * FROM Transports");
		return null;
	}


	@Override
	public List<Site> getHotelsBeaches() {
		bde.executeSQLQuery("SELECT Hotels.name, Sites.* FROM Sites INNER JOIN Hotels ON Sites.name = Hotels.beach");
		return null;
	}


	@Override
	public List<Site> getSiteByKeywords(List<String> keywords) {
		String keySentence = "";
		for(String keyword : keywords) {
			keySentence += " " + keyword;
		}
		bde.executeMixedQuery("SELECT * FROM Sites with" + keySentence);
		return null;
	}

}
