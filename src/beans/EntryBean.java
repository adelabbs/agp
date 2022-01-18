package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import business.engine.Engine;
import business.engine.SearchEntry;
import business.spring.SpringIoC;

@ManagedBean
@SessionScoped

public class EntryBean {
	
	private SearchEntry entry = new SearchEntry();
	
	private Engine form = (Engine) SpringIoC.getBean("form");
	
	public EntryBean() {}
	
	public String startEngine() {
		return "result";
	}
	
	public SearchEntry getEntry() {
		return entry;
	}
	public void setEntry(SearchEntry entry) {
		this.entry = entry;
	}
	public int getBudgetMin() {
		return entry.getBudgetMin();
	}

	public void setBudgetMin(int budgetMin) {
		entry.setBudgetMin(budgetMin);
	}

	public int getBudgetMax() {
		return entry.getBudgetMax();
	}

	public void setBudgetMax(int budgetMax) {
		entry.setBudgetMax(budgetMax);
	}

	public int getDaysOfStay() {
		return entry.getDaysOfStay();
	}

	public void setDaysOfStay(int daysOfStay) {
		entry.setDaysOfStay(daysOfStay);
	}

	public int getComfortPreference() {
		return entry.getComfortPreference() ;
	}

	public void setComfortPreference(int comfortPreference) {
		entry.setComfortPreference(comfortPreference);
	}

	public List<String> getSearchKeywords() {
		return entry.getSearchKeywords();
	}

	public void setSearchKeywords(List<String> searchKeywords) {
		entry.setSearchKeywords(searchKeywords);
	}

	public void addSearchKeyword(String keyword) {
		if (!entry.getSearchKeywords().contains(keyword)) {
			entry.addSearchKeyword(keyword);
		}
	}

	public void removeSearchKeyword(String keyword) {
		entry.removeSearchKeyword(keyword);
	}
	public Engine getForm() {
		return form;
	}
	public void setForm(Engine form) {
		this.form = form;
	}
	
	
}