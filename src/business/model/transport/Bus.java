package business.model.transport;

import persistence.edb.operator.Result;

public class Bus extends AbstractTransport {
	public Bus(String type, int speed, int price, int confort) {
		super(type, speed, price, confort);
	}
	
	public Bus(Result result) {
		super(result);
	}
	
	public Bus() {
		
	}
	
}
