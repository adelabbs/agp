package business.engine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import business.model.Offer;

public class SimpleOfferBuilder implements OfferBuilder {

	private int budgetMin;

	private int budgetMax;

	private int daysOfStay;

	/**
	 * The user difficultyPreference score.
	 */
	private int difficultyPreference;

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
	public void setDifficultyPreference(int difficultyPreference) {
		this.difficultyPreference = difficultyPreference;
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

	public int getDifficultyPreference() {
		return difficultyPreference;
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

	}

	public List<Offer> getOffers() {
		return offers;
	}

}
