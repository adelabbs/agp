package business.model;

import java.util.List;

import business.model.location.AbstractLocation;
import business.model.transport.Transport;

public class Route {
	private AbstractLocation source;
	private AbstractLocation destination;
	private List<Transport> transports;
	private double distance;

	public Route() {

	}

	public Route(AbstractLocation source, AbstractLocation destination, List<Transport> transports, double distance) {
		this.source = source;
		this.destination = destination;
		this.transports = transports;
		this.distance = distance;
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

	public List<Transport> getTransport() {
		return transports;
	}

	public void setTransport(List<Transport> transports) {
		this.transports = transports;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
