package business.model;

import java.util.LinkedList;

public class Offer {

	private LinkedList<DailyProgram> dailyPrograms = new LinkedList<DailyProgram>();

	private float totalPrice;

	public LinkedList<DailyProgram> getDailyPrograms() {
		return dailyPrograms;
	}

	public void addDailyProgram(DailyProgram dailyProgram) {
		dailyPrograms.add(dailyProgram);
	}

	public void removeDailyProgram(DailyProgram dailyProgram) {
		dailyPrograms.remove(dailyProgram);
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}