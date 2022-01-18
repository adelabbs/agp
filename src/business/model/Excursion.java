package business.model;

import java.util.LinkedList;

import business.model.transport.Transport;

public class Excursion {

	private LinkedList<Visit> visits = new LinkedList<Visit>();

	private Transport returnMeanOfTransport;

	public Excursion(Transport returnMeanOfTransport) {
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

	public Transport getReturnMeanOfTransport() {
		return returnMeanOfTransport;
	}

	public void setReturnMeanOfTransport(Transport returnMeanOfTransport) {
		this.returnMeanOfTransport = returnMeanOfTransport;
	}

}
