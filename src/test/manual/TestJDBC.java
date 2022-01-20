package test.manual;

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
	}
}
