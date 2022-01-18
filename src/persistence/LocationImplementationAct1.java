package persistence;

import java.util.List;

import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import dao.LocationPersistence;
import persistence.edb.PlanAct1;
import persistence.edb.operator.Operator;

public class LocationImplementationAct1 implements LocationPersistence {
	
	PlanAct1 bde;
	Operator op;
	
	public LocationImplementationAct1() {
		bde = new PlanAct1(null, null, null);
	}

	@Override
	public List<Hotel> getHotelByPrice(int minPrice, int maxPrice) {
		//op = bde.execQuerySQL("SELECT * FROM HOTELS WHERE HOTELS.price >= " + minPrice + " AND HOTELS.price <= " + maxPrice);
		return null;
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
