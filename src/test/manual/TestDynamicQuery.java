package test.manual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import persistence.EDBLocationPersistence;
import persistence.edb.ExecutionPlan1;

public class TestDynamicQuery {
	public static void main(String args[]) {
		ExecutionPlan1 edb = new ExecutionPlan1(null, null, System.getProperty("user.dir")+"/tmp/sites");
		edb.createTextualIndex();
		
		EDBLocationPersistence li = new EDBLocationPersistence(edb);
		
		// Error when giving unknown parameters in SQL, ResultSet don't exist
		
		System.out.println("====== TRANSPORT =====");
		HashMap<String, Object> paramTransport = new HashMap<String, Object>();
		paramTransport.put("minPrice", 0);
		paramTransport.put("confort", 2);
		li.getTransportByParameters(paramTransport);
		
		System.out.println("====== SITES ======");
		List<String> keywords = new ArrayList<String>();
		keywords.add("plongée");
		keywords.add("musée");
		keywords.add("montagne");
		
		HashMap<String, Object> paramSites = new HashMap<String, Object>();
		paramSites.put("minPrice", 0);
		paramSites.put("maxPrice", 50);
		paramSites.put("confort", 0);
		paramSites.put("keywords", keywords);
		li.getSiteByParameters(paramSites);
		
		System.out.println("====== HOTELS =====");
		HashMap<String, Object> paramHotels = new HashMap<String, Object>();
		paramHotels.put("minPrice", 0);
		paramHotels.put("maxPrice", 100);
		paramHotels.put("transportType", "bus");
		li.getHotelByParameters(paramHotels);
		
	}
}
