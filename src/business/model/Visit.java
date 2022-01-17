package business.model;

import business.model.location.AbstractLocation;
import business.model.transport.AbstractTransport;

public class Visit {

	private AbstractLocation visitedLocation;

	/**
	 * The mean of transport used to get to the visited location.
	 */
	private AbstractTransport meanOfTransport;

	public Visit(AbstractLocation visitedLocation, AbstractTransport meanOfTransport) {
		this.visitedLocation = visitedLocation;
		this.meanOfTransport = meanOfTransport;
	}

	public AbstractLocation getVisitedLocation() {
		return visitedLocation;
	}

	public void setVisitedLocation(AbstractLocation visitedLocation) {
		this.visitedLocation = visitedLocation;
	}

	public AbstractTransport getMeanOfTransport() {
		return meanOfTransport;
	}

	public void setMeanOfTransport(AbstractTransport meanOfTransport) {
		this.meanOfTransport = meanOfTransport;
	}

}
