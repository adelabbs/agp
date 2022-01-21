package business.engine;

import java.util.Comparator;
import java.util.LinkedList;

import business.model.Excursion;
import business.model.location.Site;

/**
 * 
 * This utility class is used to compare 2 excursions based on their respective
 * price and their comfort score relative to the user preference (if set).
 *
 */
public class ExcursionComparator implements Comparator<Excursion> {

	private static final double COMFORT_DISTANCE_THRESHOLD = 5;

	private int comfortPreference = 2;

	@Override
	public int compare(Excursion e1, Excursion e2) {
		int priceE1 = e1.getPrice();
		int priceE2 = e2.getPrice();
		int priceComparison = Integer.signum(priceE2 - priceE1); // lower is better

		int comfortE1 = calculateExcursionComfort(e1);
		int comfortE2 = calculateExcursionComfort(e2);

		// Calculate the distance in comfort between the actual comfort of the excursion
		// and the user preference
		int distE1 = Math.abs(comfortE1 - comfortPreference);
		int distE2 = Math.abs(comfortE2 - comfortPreference);
		int comfortComparison = Integer.signum(distE2 - distE1); // lower is better

		float preferenceE1 = calculateExcursionPreferenceScore(e1);
		float preferenceE2 = calculateExcursionPreferenceScore(e2);

		int preferenceComparison = (int) Math.signum(preferenceE1 - preferenceE2); // higher is better

		return -(priceComparison + comfortComparison + preferenceComparison); // decreasing order
	}

	public void setComfortPreference(int comfortPreference) {
		this.comfortPreference = comfortPreference;
	}

	private double calculateExcursionTotalDistance(Excursion excursion) {
		double totalDistance = 0;
		LinkedList<Site> sites = excursion.getSites();
		for (int i = 1; i < sites.size(); i++) {
			totalDistance += EngineUtility.calculateDistance(sites.get(i - 1), sites.get(i));

			if (i == 1 || i == sites.size() - 1) {
				totalDistance += EngineUtility.calculateDistance(excursion.getHotel(), sites.get(i));
			}
		}

		return totalDistance;
	}

	private int calculateExcursionComfort(Excursion excursion) {
		int scoreByType = 0;
		int scoreByDistance = 2;
		LinkedList<Site> sites = excursion.getSites();
		for (Site site : sites) {
			scoreByType += site.getTransport().getConfort();
			scoreByType += site.getConfort();
		}

		double totalDistance = calculateExcursionTotalDistance(excursion);

		if (totalDistance > COMFORT_DISTANCE_THRESHOLD) {
			scoreByDistance = 1;
		}

		int div = sites.size() - 2;
		scoreByType = (div != 0) ? scoreByType / (2 * div) : 0;
		return (scoreByType + scoreByDistance) / 2;
	}

	private float calculateExcursionPreferenceScore(Excursion excursion) {
		float score = 0;
		LinkedList<Site> sites = excursion.getSites();
		for (Site site : sites) {
			score += site.getScore();
		}

		return score / sites.size();
	}

}
