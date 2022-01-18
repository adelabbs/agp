package business.model;

import business.model.location.AbstractLocation;
import business.model.transport.AbstractTransport;

public class Route {
	private AbstractLocation source;
	private AbstractLocation destination;
	private AbstractTransport transport;

	public Route() {

	}

	public Route(AbstractLocation source, AbstractLocation destination, AbstractTransport transport) {
		this.source = source;
		this.destination = destination;
		this.transport = transport;
	}

	public AbstractLocation getSource() {
		return source;
	}

	public void setSource(AbstractLocation source) {
		this.source = source;
	}

	public AbstractLocation getDestination() {
		return destination;
	}

	public void setDestination(AbstractLocation destination) {
		this.destination = destination;
	}

	public AbstractTransport getTransport() {
		return transport;
	}

	public void setTransport(AbstractTransport transport) {
		this.transport = transport;
	}

}
