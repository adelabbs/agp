package test.manual;

import java.util.ArrayList;
import java.util.List;

import business.model.location.Coordinates;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import business.spring.SpringIoC;
import persistence.LocationImplementation;
import persistence.edb.ExecutionPlan1;
import persistence.edb.operator.Operator;
import persistence.edb.operator.Result;

public class TestJDBC {
	

	public static void main(String[] args) {
		ExecutionPlan1 ep1 = new ExecutionPlan1();
		LocationImplementation li = new LocationImplementation(ep1);
		li.getHotelByPrice(0, 100);
	}
}
