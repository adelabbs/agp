package business.model;

import java.util.LinkedList;

import business.model.transport.AbstractTransport;

public class Excursion {

	private LinkedList<Visit> visits = new LinkedList<Visit>();

	private AbstractTransport returnMeanOfTransport;

	public Excursion(AbstractTransport returnMeanOfTransport) {
		this.returnMeanOfTransport = returnMeanOfTransport;
	}

	public LinkedList<Visit> getVisits() {
		return visits;
	}

	public void addVisit(Visit visit) {
		visits.add(visit);
	}

	public void removeVisit(Visit visit) {
		visits.remove(visit);
	}

	public AbstractTransport getReturnMeanOfTransport() {
		return returnMeanOfTransport;
	}

	public void setReturnMeanOfTransport(AbstractTransport returnMeanOfTransport) {
		this.returnMeanOfTransport = returnMeanOfTransport;
	}

}
