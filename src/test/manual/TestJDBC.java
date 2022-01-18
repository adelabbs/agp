package test.manual;

import persistence.LocationImplementation;
import persistence.edb.ExecutionPlan1;

public class TestJDBC {
	

	public static void main(String[] args) {
		ExecutionPlan1 ep1 = new ExecutionPlan1();
		LocationImplementation li = new LocationImplementation(ep1);
		li.getHotelByPrice(0, 1000);
		li.getSiteByPrice(0, 100);
	}
}
