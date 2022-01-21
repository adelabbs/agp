package business.model;

import java.util.LinkedList;

import business.model.transport.Transport;

/**
 * 
 * An offer contains a list of excursions in chronological order as well as a
 * list of hotel reservations.
 *
 */
public class Offer {

	private int id;

	private LinkedList<Excursion> excursions = new LinkedList<Excursion>();

	private LinkedList<HotelReservation> hotelReservations = new LinkedList<HotelReservation>();

	private LinkedList<Transport> transportsBetweenHotels = new LinkedList<Transport>();

	private LinkedList<Double> distancesBetweenHotels = new LinkedList<Double>();

	private int totalPrice;

	public LinkedList<Excursion> getExcursions() {
		return excursions;
	}

	public void addExcursion(Excursion excursion) {
		if (!excursions.contains(excursion)) {
			excursions.add(excursion);
		}
	}

	public void removeExcursion(Excursion excursion) {
		excursions.remove(excursion);
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<HotelReservation> getHotels() {
		return hotelReservations;
	}

	public void addHotelReservation(HotelReservation reservation) {
		if (!hotelReservations.contains(reservation)) {
			hotelReservations.add(reservation);
		}
	}

	public void removeHotelReservation(HotelReservation reservation) {
		hotelReservations.remove(reservation);
	}

	public LinkedList<Transport> getTransportsBetweenHotels() {
		return transportsBetweenHotels;
	}

	public void addTransportBetweenHotels(Transport transport) {
		if (transport != null) {
			transportsBetweenHotels.add(transport);
		}
	}

	public void removeTransportBetweenHotels(Transport transport) {
		transportsBetweenHotels.remove(transport);
	}

	public LinkedList<Double> getDistancesBetweenHotels() {
		return distancesBetweenHotels;
	}

	public void addDistanceBetweenHotels(Double distance) {
		if (distance != null) {
			distancesBetweenHotels.add(distance);
		}
	}

	public void removeDistanceBetweenHotels(Double distance) {
		distancesBetweenHotels.remove(distance);
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", \n excursions=" + excursions + ", \n hotelReservations=" + hotelReservations
				+ ", totalPrice=" + totalPrice + "]";
	}

}