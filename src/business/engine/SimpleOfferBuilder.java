package business.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;

import business.model.Excursion;
import business.model.Offer;
import business.model.Route;
import business.model.location.AbstractLocation;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.Boat;
import business.model.transport.Bus;
import business.model.transport.Transport;
import dao.LocationPersistence;
import persistence.EDBLocationPersistence;
import persistence.MockPersistence;
import persistence.edb.ExecutionPlan1;

public class SimpleOfferBuilder implements OfferBuilder {

	private SearchEntry searchEntry;

	private List<Offer> offers = new LinkedList<Offer>();

	private List<Hotel> hotels;

	private List<Site> sites;
	
	private List<List<Integer>> siteSubsets; // { {0, 1}, {0, 2}, ... }
	
	private List<Excursion> excursions;
	
	private double[][] distanceMatrix;

	private LocationPersistence locationPersistence;

	private int DEFAULT_STAY_DURATION = 7;

	private int excursionFrequency = 1;
	private int MAX_EXCURSION = 2;
	
	private int MIN_VISIT_PER_EXCURSION = 1;
	private int MAX_VISIT_PER_EXCURSION = 2;
	
	private String tableName = "sites";
	private String key = "name";
	private String userDirPath = System.getProperty("user.dir")+"/tmp/sites";

	public SimpleOfferBuilder(SearchEntry searchEntry) {
		this.searchEntry = searchEntry;
		locationPersistence = new EDBLocationPersistence(tableName, key, userDirPath);
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

		//getMockCandidateHotels();
		//getMockCandidateSites();

		getCandidateHotels();
		getCandidateSites();
		findIndexSubsets(sites.size(), MIN_VISIT_PER_EXCURSION, MAX_EXCURSION);

		calculateDistances();
		
		buildExcursions();
		
		buildOffers();
		
		/*
		 * 1. Recup Hotel & Sites candidats aux critères
		 * 2. Créer des excursions possibles
		 * 		H1 -> S -> S -> H1 = 1 excursion
		 * 		H1 -> H2 = à la fin d'une journée
		 * 		Excursion = Ensembles de sites et hotels
		 * 3. 
		 */
		
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
	
	private void calculateDistances() {
		distanceMatrix = new double[hotels.size()][sites.size()];
		for(int i = 0; i < hotels.size(); i++) {
			for(int j = 0; i< sites.size(); j++) {
				distanceMatrix[i][j] = calculateDistance(hotels.get(i), sites.get(j)); 
			}
		}
	}

	public double calculateDistance(AbstractLocation source, AbstractLocation destination) {
		double lat1 = source.getCoordinates().getLatitude();
		double lat2 = destination.getCoordinates().getLongitude();
		double lon1 = source.getCoordinates().getLatitude();
		double lon2 = destination.getCoordinates().getLongitude();

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);
	    distance = Math.sqrt(distance);

	    return distance;
}
	
	private void findIndexSubsets(int n, int minSize, int maxSize) {
		for(int k = minSize; k <= maxSize; k++) {
	        recSubsetBuilder(n, k, 0, siteSubsets, new ArrayList<>());
		}
    }

    private void recSubsetBuilder(int n, int k, int startIndex, List<List<Integer>> subsets, List<Integer> subset) {
        if (k == subset.size()) {
        	subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
        	subset.add(i);
            recSubsetBuilder(n, k, i + 1, subsets, subset);
            subset.remove(subset.size() - 1);
        }
    }

	private void buildExcursions() {
		excursions = new ArrayList<Excursion>();
		DistanceComparator comparator = new DistanceComparator(distanceMatrix);
		for(Hotel hotel : hotels) {
			comparator.setIdHotel(hotels.indexOf(hotel));
			for(List<Integer> subset : siteSubsets) {
				for(int i = 0; i<subset.size(); i++) {
					
					subset.sort(comparator);
					
					Route route = new Route();
					AbstractLocation source = null;
					AbstractLocation dest = null;
					List<Transport> transports = new ArrayList<Transport>();
					if(i == 0) {
						source = hotel;
						dest = sites.get(i);
					}
					
					if(i == subset.size()-1) {
						source = sites.get(i);
						dest = hotel;
					}
					
					if(i != 0 && i != subset.size() -1){
						source = sites.get(i-1);
						dest = sites.get(i);
					}
					
					if(source.getIsland() != dest.getIsland()) {
						transports.add(dest.getTransport());
						transports.add(new Boat("boat",39,30,2));
						transports.add(dest.getTransport());
					}
					else {
						transports.add(dest.getTransport());
					}
					
					route.setSource(hotel);
					route.setDestination(sites.get(i));
				} 
			}
		}
	}

	private void buildOffers() {
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
