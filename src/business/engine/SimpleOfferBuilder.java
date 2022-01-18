package business.engine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import business.model.Offer;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.AbstractTransport;
import business.model.transport.OnFoot;
import business.spring.SpringIoC;
import persistence.MockPersistence;

public class SimpleOfferBuilder implements OfferBuilder {

	private int budgetMin;

	private int budgetMax;

	private int daysOfStay;

	/**
	 * The user difficultyPreference score.
	 */
	private int comfortPreference = 2;

	private String locationPreference;

	private List<String> searchKeywords = new ArrayList<String>();

	private int nbOffers = 3;

	private List<Offer> offers = new LinkedList<Offer>();

	@Override
	public void setKeywords(List<String> keywords) {
		this.searchKeywords = keywords;
	}

	@Override
	public void setPriceRange(int budgetMin, int budgetMax) {
		this.budgetMin = budgetMin;
		this.budgetMax = budgetMax;
	}

	@Override
	public void setDaysOfStay(int daysOfStay) {
		this.daysOfStay = daysOfStay;
	}

	@Override
	public void setComfortPreference(int comfortPreference) {
		this.comfortPreference = comfortPreference;
	}

	public void setNbOffers(int nbOffers) {
		this.nbOffers = nbOffers;
	}

	public int getBudgetMin() {
		return budgetMin;
	}

	public int getBudgetMax() {
		return budgetMax;
	}

	public int getDaysOfStay() {
		return daysOfStay;
	}

	public int getComfortPreference() {
		return comfortPreference;
	}

	public String getLocationPreference() {
		return locationPreference;
	}

	public List<String> getSearchKeywords() {
		return searchKeywords;
	}

	public int getNbOffers() {
		return nbOffers;
	}

	public void build() {

		// The offer building process tries to generate offers combinations

		if (daysOfStay > 0) {
			int avgBudgetMin = budgetMin / daysOfStay;
			int avgBudgetMax = budgetMax / daysOfStay;

			MockPersistence lp = new MockPersistence();

			List<Hotel> hotels = lp.getHotelByPrice(avgBudgetMin, avgBudgetMax);
			List<Site> sites = lp.getSiteByPrice(avgBudgetMin, avgBudgetMax);

			AbstractTransport transport = (OnFoot) SpringIoC.getBean("onFoot");

		}

	}

	public List<Offer> getOffers() {
		return offers;
	}

}
