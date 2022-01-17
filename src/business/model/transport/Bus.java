package business.model.transport;

public class Bus extends AbstractTransport {

	/**
	 * Mock calculation : 1 bus ticket costs 2 units of currency.
	 */
	@Override
	public float calculatePrice() {
		return 2;
	}

}
