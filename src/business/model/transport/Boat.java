package business.model.transport;

public class Boat extends AbstractTransport {

	/**
	 * Mock calculation : 1 boat ticket costs 5 units of currency.
	 */
	@Override
	public float calculatePrice() {
		return 5;
	}

}
