package business.model.transport;

public class OnFoot extends AbstractTransport {

	/**
	 * On foot transportation is free.
	 */
	@Override
	public float calculatePrice() {
		return 0;
	}
}
