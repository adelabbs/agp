package business.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import business.model.Excursion;
import business.model.Offer;

@ApplicationScoped
public class MockOfferBuilder {
	
	private List<Offer> offers;
	
	@PostConstruct
    public void init() {	
		
		
		Excursion excursion1 = new Excursion(1);
		Excursion excursion2 = new Excursion(1);
		Excursion excursion3 = new Excursion(3);
		Excursion excursion4 = new Excursion(1);
		
		
		Offer offer1 = new Offer();
		Offer offer2 = new Offer();
		
		offer1.setId(1);
		offer2.setId(2);
		
		offer1.setTotalPrice(699);
		offer2.setTotalPrice(1200);
		
		offer1.getExcursions().add(excursion1);
		offer1.getExcursions().add(excursion2);
		offer1.getExcursions().add(excursion3);
		offer2.getExcursions().add(excursion4);
		

		offers = new ArrayList<>();
		offers.add(offer1);
		offers.add(offer2);
	}
	
	public List<Offer> getOffers() {
        return new ArrayList<>(offers);
    }

    public List<Offer> getOffers(int size) {
        if (size > offers.size()) {
            Random rand = new Random();

            List<Offer> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(offers.size());
                randomList.add(offers.get(randomIndex));
            }
            return randomList;
        }
        else {
            return new ArrayList<>(offers.subList(0, size));
        }
    }
}
