package business.model;

import java.util.LinkedList;

public class Offer {

	private int id;

	private LinkedList<Excursion> excursions = new LinkedList<Excursion>();

	private LinkedList<HotelReservation> hotelReservations = new LinkedList<HotelReservation>();

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

	public LinkedList<HotelReservation> getHotelReservations() {
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

	@Override
	public String toString() {
		return "Offer [id=" + id + ", \n excursions=" + excursions + ", \n hotelReservations=" + hotelReservations
				+ ", totalPrice=" + totalPrice + "]";
	}

}