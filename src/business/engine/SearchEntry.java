package business.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store the search entry parameters.
 *
 */
public class SearchEntry {

	private int budgetMin;

	private int budgetMax;

	private String daysOfStay;

	/**
	 * The user comfortPreference score.
	 */
	private int comfortPreference;

	private List<String> searchKeywords = new ArrayList<String>();

	public SearchEntry() {

	}

	public SearchEntry(int budgetMin, int budgetMax, String daysOfStay, int comfortPreference) {
		this.budgetMin = budgetMin;
		this.budgetMax = budgetMax;
		this.daysOfStay = daysOfStay;
		this.comfortPreference = comfortPreference;
	}

	public int getBudgetMin() {
		return budgetMin;
	}

	public void setBudgetMin(int budgetMin) {
		this.budgetMin = budgetMin;
	}

	public int getBudgetMax() {
		return budgetMax;
	}

	public void setBudgetMax(int budgetMax) {
		this.budgetMax = budgetMax;
	}

	public String getDaysOfStay() {
		return daysOfStay;
	}

	public void setDaysOfStay(String daysOfStay) {
		this.daysOfStay = daysOfStay;
	}

	public int getComfortPreference() {
		return comfortPreference;
	}

	public void setComfortPreference(int comfortPreference) {
		this.comfortPreference = comfortPreference;
	}

	public List<String> getSearchKeywords() {
		return searchKeywords;
	}

	public void setSearchKeywords(List<String> searchKeywords) {
		this.searchKeywords = searchKeywords;
	}

	public void addSearchKeyword(String keyword) {
		if (!searchKeywords.contains(keyword)) {
			searchKeywords.add(keyword);
		}
	}

	public void removeSearchKeyword(String keyword) {
		searchKeywords.remove(keyword);
	}

}
