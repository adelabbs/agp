package business.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store the search entry parameters.
 *
 */
public class SearchEntry {

	private Integer budgetMin;

	private Integer budgetMax;

	private Integer daysOfStay;

	/**
	 * The user comfortPreference score.
	 */
	private Integer comfortPreference;

	private List<String> searchKeywords = new ArrayList<String>();

	public SearchEntry() {

	}

	public SearchEntry(Integer budgetMin, Integer budgetMax, Integer daysOfStay, Integer comfortPreference) {
		this.budgetMin = budgetMin;
		this.budgetMax = budgetMax;
		this.daysOfStay = daysOfStay;
		this.comfortPreference = comfortPreference;
	}

	public Integer getBudgetMin() {
		return budgetMin;
	}

	public void setBudgetMin(Integer budgetMin) {
		this.budgetMin = budgetMin;
	}

	public Integer getBudgetMax() {
		return budgetMax;
	}

	public void setBudgetMax(Integer budgetMax) {
		this.budgetMax = budgetMax;
	}

	public Integer getDaysOfStay() {
		return daysOfStay;
	}

	public void setDaysOfStay(Integer daysOfStay) {
		this.daysOfStay = daysOfStay;
	}

	public Integer getComfortPreference() {
		return comfortPreference;
	}

	public void setComfortPreference(Integer comfortPreference) {
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
