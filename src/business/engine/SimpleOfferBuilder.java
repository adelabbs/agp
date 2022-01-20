package business.engine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import business.model.Offer;
import business.model.location.Hotel;
import business.model.location.Site;
import dao.LocationPersistence;
import persistence.MockPersistence;

public class SimpleOfferBuilder implements OfferBuilder {

	private SearchEntry searchEntry;

	private List<Offer> offers = new LinkedList<Offer>();

	private List<Hotel> hotels;

	private List<Site> sites;

	private LocationPersistence locationPersistence = new MockPersistence();

	private int DEFAULT_STAY_DURATION = 7;

	private int excursionFrequency = 1;
	
	private int MAX_VISIT_PER_EXCURSION = 3;

	public SimpleOfferBuilder(SearchEntry searchEntry) {
		this.searchEntry = searchEntry;
	}

	@Override
	public void setSearchEntry(SearchEntry searchEntry) {
		this.searchEntry = searchEntry;
	}

	@Override
	public List<Offer> getOffers() {
		return offers;
	}

	@Override
	public void build() {

		int stayDuration = DEFAULT_STAY_DURATION;
		int dailyBudget = (searchEntry.getBudgetMin() + searchEntry.getBudgetMax()) / (2 * stayDuration);

		getMockCandidateHotels();
		getMockCandidateSites();

		getCandidateHotels();
		getCandidateSites();
		
		
		
		// H, S, C
		
		// => (H, S), (S, S), (H, H)
		
		// Filter H, S with C
		
		// Excursion + hotels
		// Top-n
		// 1) generate all items
		//		// => only visit each site at most once
		//		// => excursion order does not matter
		//		d1 : v1, v2 d2: o d3 : v1, v2
		//
		// 2) rank => score
		// 
		// => Max number of visits per excursion
		// 
		// 2 excursions max / day day 1 : a day 2: b change hotel
		
		// ...
		
		/***
		 * Generate 1 offer
		 * find best hotel
		 * 
		 * 1 2 3
		 * 1 0.5 0.25
		 * => 0, 1 
		 *
		 * find sublist of sites
		 * 
		 */
		
		/**
		 * Find all cycles of length up to n for each hotel
		 * aka find all the potential excursions from each hotel
		 * and compute their cost (each excursion costs the price of transport and the price of each visit)
		 * also find the comfort score of each excursion
		 * also find the preference score of each excursion (if available, if not it's 0 by default and therefore even  for each excursion)
		 * 
		 * then sort the excursions by their score
		 * and construct offers aka limited by the number of excursions
		 * calculate offer prices
		 * 
		 * 
		 */

	}
	

	private void buildOffer() {
		Hotel bestHotel = selectBestHotel();
		Offer offer = new Offer();
	
	}
	
	

	private void getCandidateHotels() {
		if (isSetPriceRange()) {
			hotels = locationPersistence.getHotelByPrice(searchEntry.getBudgetMin(), searchEntry.getBudgetMax());
		} else {
			hotels = locationPersistence.getAllHotels();
		}
	}

	private void getCandidateSites() {
		HashMap<String, Object> queryParameters = new HashMap<String, Object>();
		if (isSetComfortPreference()) {
			queryParameters.put("confort", searchEntry.getComfortPreference());
		}
		if (isSetPriceRange()) {
			queryParameters.put("minPrice", searchEntry.getBudgetMin());
			queryParameters.put("maxPrice", searchEntry.getBudgetMax());
		}
		if (isSetKeywords()) {
			queryParameters.put("keywords", searchEntry.getSearchKeywords());
		}
		sites = locationPersistence.getSiteByParameters(queryParameters);
	}
	
	private Hotel selectBestHotel() {
		// TODO
		return hotels.get(0);
	}
	
	private void getMockCandidateHotels() {
		int minPrice = 0;
		int maxPrice = 1000;
		hotels = locationPersistence.getHotelByPrice(minPrice, maxPrice);
	}

	private void getMockCandidateSites() {
		int minPrice = 0;
		int maxPrice = 1000;
		sites = locationPersistence.getSiteByPrice(minPrice, maxPrice);
	}

	private boolean isSetKeywords() {
		return searchEntry.getSearchKeywords().size() > 0;
	}

	private boolean isSetPriceRange() {
		return searchEntry.getBudgetMin() != null && searchEntry.getBudgetMax() != null;
	}

	private boolean isSetStayDuration() {
		return searchEntry.getDaysOfStay() != null;
	}

	private boolean isSetComfortPreference() {
		return searchEntry.getComfortPreference() != null;
	}

}
