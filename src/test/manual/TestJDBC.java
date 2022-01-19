package test.manual;

import persistence.LocationImplementation;
import persistence.edb.ExecutionPlan1;

public class TestJDBC {
	

	public static void main(String[] args) {
		ExecutionPlan1 ep1 = new ExecutionPlan1();
		LocationImplementation li = new LocationImplementation(ep1);
		System.out.println("========= HOTELS =========");
		li.getHotelByPrice(0, 100);
		System.out.println("========= SITES ==========");
		li.getSiteByPrice(0, 10);
	}
}
