package business.engine;

public class LucasEntry {
	private int stay_duration;
	private int budget_inf;
	private int budget_supp;
	private int difficulty_score;
	private char excursion_types;

	public LucasEntry() {}
	
	public LucasEntry(int stayDuration, int budgetInf, int budgetSupp, int difficultyScore, char excursionTypes) {
		this.stay_duration = stayDuration;
		this.budget_inf = budgetInf;
		this.budget_supp = budgetSupp;
		this.difficulty_score = difficultyScore;
		this.excursion_types = excursionTypes;
	}
	
	public int getStay_duration() {
		return stay_duration;
	}

	public void setStay_duration(int stayDuration) {
		this.stay_duration = stayDuration;
	}

	public int getBudget_inf() {
		return budget_inf;
	}

	public void setBudget_inf(int budget_inf) {
		this.budget_inf = budget_inf;
	}

	public int getBudget_supp() {
		return budget_supp;
	}

	public void setBudget_supp(int budget_supp) {
		this.budget_supp = budget_supp;
	}

	public int getDifficulty_score() {
		return difficulty_score;
	}

	public void setDifficulty_score(int difficulty_score) {
		this.difficulty_score = difficulty_score;
	}

	public char getExcursion_types() {
		return excursion_types;
	}

	public void setExcursion_types(char excursion_types) {
		this.excursion_types = excursion_types;
	}
}
