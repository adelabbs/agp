package business.model.transport;

import persistence.edb.operator.Result;

public class OnFoot extends AbstractTransport {
	public OnFoot(String type, int speed, int price, int confort) {
		super(type, speed, price, confort);
	}
	
	public OnFoot(Result result) {
		super(result);
	}
	
	public OnFoot() {
		
	}
}
