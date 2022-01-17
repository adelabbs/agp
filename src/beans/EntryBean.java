package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.engine.LucasEngine;
import business.engine.LucasEntry;
import business.spring.SpringIoC;

@ManagedBean
@SessionScoped

public class EntryBean {
	
	private LucasEntry entry = new LucasEntry();
	
	private LucasEngine form = (LucasEngine) SpringIoC.getBean("form");;
	
	public EntryBean() {}
	
	public String startEngine() {
		return "result";
	}
	
	
	public LucasEntry getEntry() {
		return entry;
	}
	public void setEntry(LucasEntry entry) {
		this.entry = entry;
	}
	public int getStay_duration() {
		return entry.getStay_duration();
	}

	public void setStay_duration(int stayDuration) {
		entry.setStay_duration(stayDuration);
	}

	public int getBudget_inf() {
		return entry.getBudget_inf();
	}

	public void setBudget_inf(int budget_inf) {
		entry.setBudget_inf(budget_inf);
	}

	public int getBudget_supp() {
		return entry.getBudget_supp();
	}

	public void setBudget_supp(int budget_supp) {
		entry.setBudget_supp(budget_supp);
	}

	public int getDifficulty_score() {
		return entry.getDifficulty_score();
	}

	public void setDifficulty_score(int difficulty_score) {
		entry.setDifficulty_score(difficulty_score);
	}

	public char getExcursion_types() {
		return entry.getExcursion_types();
	}

	public void setExcursion_types(char excursion_types) {
		entry.setExcursion_types(excursion_types);
	}
	public LucasEngine getForm() {
		return form;
	}
	public void setForm(LucasEngine form) {
		this.form = form;
	}
	
	
}