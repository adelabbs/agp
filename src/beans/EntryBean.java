package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import business.engine.Engine;
import business.engine.SearchEntry;
import business.spring.SpringIoC;

@ManagedBean
@SessionScoped

public class EntryBean implements Serializable {
	
	private static final long serialVersionUID = -7658310028694454686L;

	private SearchEntry entry = new SearchEntry();
	
	private Engine form = (Engine) SpringIoC.getBean("form");
	
	public EntryBean() {}
	
	@PostConstruct
	public void Init() {
		//setDaysOfStay(1);
	}
	
	public String startEngine() {
		if ((getDaysOfStay() > 0) && (getDaysOfStay() < 8)) {
			return "result";
		}
		else {
			return "invalid-entry";
		}
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

	@SuppressWarnings("null")
	public int getDaysOfStay() {
		/*if ((entry.getDaysOfStay() > 0) || (entry.getDaysOfStay() < 8)) {
			return entry.getDaysOfStay(); 
		}
		else {
			return (Integer) null;
		}*/
		return entry.getDaysOfStay(); 
	}

	@SuppressWarnings("null")
	public void setDaysOfStay(int daysOfStay) {
		/*if ((entry.getDaysOfStay() > 0) || (entry.getDaysOfStay() < 8)) {
			entry.setDaysOfStay(daysOfStay);
		}
		else {
			Integer invalid = null;
			entry.setDaysOfStay(invalid);
		}*/
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