package test.manual;

import java.util.List;

import business.engine.Engine;
import business.engine.SearchEntry;
import business.model.Offer;
import business.spring.SpringIoC;

public class TestEngine {

	public static void main(String[] args) {
		SearchEntry searchEntry = (SearchEntry) SpringIoC.getBean("entry");
		List<Offer> offers;

		Engine engine = new Engine();
		engine.setSearchEntry(searchEntry);
		engine.buildRecommendations();
		offers = engine.getOffers();

		for (Offer offer : offers) {
			System.out.println(("==================="));
			System.out.println(offer);
		}

	}
}