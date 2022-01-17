package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import business.engine.LucasEngine;
import business.engine.LucasEntry;

@ManagedBean
@RequestScoped
public class ResultBean {
	@ManagedProperty(value = "#{entryBean}")
	private EntryBean entryBean;
	
	public ResultBean() {

	}

	@PostConstruct
	private void printResults() {
		System.out.println(getStay_duration());
	}

	public EntryBean getEntryBean() {
		return entryBean;
	}

	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}	

	public int getStay_duration() {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		return entry.getStay_duration();
	}

	public void setStay_duration(int stayDuration) {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		entry.setStay_duration(stayDuration);
	}

	public int getBudget_inf() {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		return entry.getBudget_inf();
	}

	public void setBudget_inf(int budget_inf) {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		entry.setBudget_inf(budget_inf);
	}

	public int getBudget_supp() {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		return entry.getBudget_supp();
	}

	public void setBudget_supp(int budget_supp) {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		entry.setBudget_supp(budget_supp);
	}

	public int getDifficulty_score() {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		return entry.getDifficulty_score();
	}

	public void setDifficulty_score(int difficulty_score) {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		entry.setDifficulty_score(difficulty_score);
	}

	public char getExcursion_types() {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		return entry.getExcursion_types();
	}

	public void setExcursion_types(char excursion_types) {
		LucasEngine form = entryBean.getForm();
		LucasEntry entry = form.getLucasEntry();
		entry.setExcursion_types(excursion_types);
	}
}