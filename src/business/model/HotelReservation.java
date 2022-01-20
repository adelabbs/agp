package business.model;

import business.model.location.Hotel;

public class HotelReservation {

	private Hotel hotel;
	private int stayDuration;

	public HotelReservation(Hotel hotel, int stayDuration) {
		this.hotel = hotel;
		this.stayDuration = stayDuration;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getStayDuration() {
		return stayDuration;
	}

	public void setStayDuration(int stayDuration) {
		this.stayDuration = stayDuration;
	}

	public int getPrice() {
		return stayDuration * hotel.getPricePerNight();
	}

}
