package test.manual;

import persistence.LocationImplementation;

public class TestJDBC {
	public static void main(String[] args) {
		LocationImplementation locAPI = new LocationImplementation();
		locAPI.getHotelByPrice(0, 100);
	}
}
