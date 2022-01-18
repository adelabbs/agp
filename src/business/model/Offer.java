package business.model;

import java.util.HashMap;
import java.util.LinkedList;

import business.model.location.Hotel;

public class Offer {

	private LinkedList<Excursion> excursions = new LinkedList<Excursion>();

	private HashMap<Hotel, Stay> hotels = new HashMap<Hotel, Stay>();

	private float totalPrice;

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

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}