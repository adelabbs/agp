package business.model.transport;

import persistence.edb.operator.Result;

public class Boat extends AbstractTransport {

	public Boat(String type, int speed, int price, int confort) {
		super(type, speed, price, confort);
	}
	
	public Boat(Result result) {
		super(result);
	}
	
	public Boat() {
		
	}
}
