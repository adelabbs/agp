package beans;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import business.engine.Engine;
import business.engine.SearchEntry;

@ManagedBean
@RequestScoped
public class ResultBean {
	@ManagedProperty(value = "#{entryBean}")
	private EntryBean entryBean;
	
	public ResultBean() {

	}

	@PostConstruct
	private void printResults() {
		setBudgetMin(entryBean.getBudgetMin());
		setBudgetMax(entryBean.getBudgetMax());
		setDaysOfStay(entryBean.getDaysOfStay());
		setDifficultyPreference(entryBean.getDifficultyPreference());
		setLocationPreference(entryBean.getLocationPreference());
	}

	public EntryBean getEntryBean() {
		return entryBean;
	}

	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}	
	
	public int getBudgetMin() {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		return entry.getBudgetMin();
	}

	public void setBudgetMin(int budgetMin) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		entry.setBudgetMin(budgetMin);
	}

	public int getBudgetMax() {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		return entry.getBudgetMax();
	}

	public void setBudgetMax(int budgetMax) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		entry.setBudgetMax(budgetMax);
	}

	public int getDaysOfStay() {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		return entry.getDaysOfStay();
	}

	public void setDaysOfStay(int daysOfStay) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		entry.setDaysOfStay(daysOfStay);
	}

	public int getDifficultyPreference() {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		return entry.getDifficultyPreference() ;
	}

	public void setDifficultyPreference(int difficultyPreference) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		entry.setDifficultyPreference(difficultyPreference);
	}

	public String getLocationPreference() {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		return entry.getLocationPreference();
	}

	public void setLocationPreference(String locationPreference) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		entry.setLocationPreference(locationPreference);
	}

	public List<String> getSearchKeywords() {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		return entry.getSearchKeywords();
	}

	public void setSearchKeywords(List<String> searchKeywords) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		entry.setSearchKeywords(searchKeywords);
	}

	public void addSearchKeyword(String keyword) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		if (!entry.getSearchKeywords().contains(keyword)) {
			entry.addSearchKeyword(keyword);
		}
	}

	public void removeSearchKeyword(String keyword) {
		Engine form = entryBean.getForm();
		SearchEntry entry = form.getSearchEntry();
		entry.removeSearchKeyword(keyword);
	}
}