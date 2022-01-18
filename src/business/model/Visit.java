package business.model;

import business.model.location.AbstractLocation;
import business.model.transport.Transport;

public class Visit {

	private AbstractLocation visitedLocation;

	/**
	 * The mean of transport used to get to the visited location.
	 */
	private Transport meanOfTransport;

	public Visit(AbstractLocation visitedLocation, Transport meanOfTransport) {
		this.visitedLocation = visitedLocation;
		this.meanOfTransport = meanOfTransport;
	}

	public AbstractLocation getVisitedLocation() {
		return visitedLocation;
	}

	public void setVisitedLocation(AbstractLocation visitedLocation) {
		this.visitedLocation = visitedLocation;
	}

	public Transport getMeanOfTransport() {
		return meanOfTransport;
	}

	public void setMeanOfTransport(Transport meanOfTransport) {
		this.meanOfTransport = meanOfTransport;
	}

}
