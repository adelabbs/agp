package test.manual;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.EDBLocationPersistence;

public class TestJDBC {
	

	public static void main(String[] args) {
		EDBLocationPersistence li = new EDBLocationPersistence("sites", "name", System.getProperty("user.dir")+"/tmp/sites");
		System.out.println("========= HOTELS =========");
		li.getHotelByPrice(0, 100);
		System.out.println("========= SITES ==========");
		li.getSiteByPrice(0, 10);
		System.out.println("========= TRANSPORT ==========");
		li.getTransportByPrice(0, 10);
		
		
		System.out.println("========= TEST HOTEL PAR PARAMETRES =========");
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		String transportType = "bus";
		parameters.put("transportType", transportType);
		//li.getHotelByParameters(parameters);
		
		System.out.println("========= TEST Site PAR PARAMETRES =========");
		
		ArrayList<String> keywords = new ArrayList<String>();
		keywords.add("plage");
		parameters.put("keywords", keywords);
		li.getSiteByParameters(parameters);
		
	}
}
