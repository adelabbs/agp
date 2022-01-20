package business.model;

import java.util.LinkedList;

import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.Transport;

public class Excursion {

	private LinkedList<Site> sites = new LinkedList<Site>();
	private LinkedList<LinkedList<Transport>> transports = new LinkedList<LinkedList<Transport>>();

	private Hotel hotel;

	private int day;

	private int price;

	public Excursion() {

	}

	public LinkedList<Site> getSites() {
		return sites;
	}

	public LinkedList<LinkedList<Transport>> getTransports() {
		return transports;
	}

	public void addSite(Site site) {
		if (site != null) {
			sites.add(site);
		}
	}

	public void removeSite(Site site) {
		sites.remove(site);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void addTransports(LinkedList<Transport> locationToLocation) {
		if (locationToLocation != null) {
			transports.add(locationToLocation);
		}
	}

	public void removeTransports(LinkedList<Transport> locationToLocation) {
		transports.remove(locationToLocation);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
