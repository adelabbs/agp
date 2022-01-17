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

	private int daysOfStay;

	/**
	 * The user difficultyPreference score.
	 */
	private int difficultyPreference;

	private String locationPreference;

	private List<String> searchKeywords = new ArrayList<String>();

	public SearchEntry() {

	}

	public SearchEntry(int budgetMin, int budgetMax, int daysOfStay, int difficultyPreference,
			String locationPreference) {
		this.budgetMin = budgetMin;
		this.budgetMax = budgetMax;
		this.daysOfStay = daysOfStay;
		this.difficultyPreference = difficultyPreference;
		this.locationPreference = locationPreference;
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

	public int getDaysOfStay() {
		return daysOfStay;
	}

	public void setDaysOfStay(int daysOfStay) {
		this.daysOfStay = daysOfStay;
	}

	public int getDifficultyPreference() {
		return difficultyPreference;
	}

	public void setDifficultyPreference(int difficultyPreference) {
		this.difficultyPreference = difficultyPreference;
	}

	public String getLocationPreference() {
		return locationPreference;
	}

	public void setLocationPreference(String locationPreference) {
		this.locationPreference = locationPreference;
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
