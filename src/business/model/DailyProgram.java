package business.model;

import business.model.location.Hotel;

public class DailyProgram {
	private Hotel hotel;

	private Excursion morningExcurion;

	private Excursion afternoonExcursion;

	public DailyProgram(Hotel hotel, Excursion morningExcurion, Excursion afternoonExcursion) {
		this.hotel = hotel;
		this.morningExcurion = morningExcurion;
		this.afternoonExcursion = afternoonExcursion;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Excursion getMorningExcurion() {
		return morningExcurion;
	}

	public void setMorningExcurion(Excursion morningExcurion) {
		this.morningExcurion = morningExcurion;
	}

	public Excursion getAfternoonExcursion() {
		return afternoonExcursion;
	}

	public void setAfternoonExcursion(Excursion afternoonExcursion) {
		this.afternoonExcursion = afternoonExcursion;
	}

}
