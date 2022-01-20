package business.engine;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import business.model.Excursion;
import business.model.HotelReservation;
import business.model.Offer;
import business.model.location.Hotel;
import business.model.location.Site;
import business.model.transport.Bus;
import business.model.transport.Transport;

@ApplicationScoped
public class MockOfferBuilder {
	
	private List<Offer> offers;
	
	@PostConstruct
    public void init() {	
		
		Site source = new Site();
		Site destination = new Site();
		
		Transport transport = new Bus();
		transport.setPrice(40);
		transport.setSpeed(30);
		transport.setConfort(1);
		transport.setType("Bus");
		
		source.setName("Name 1");
		destination.setName("Name 2");
		source.setTransport(transport);
		destination.setTransport(transport);
		source.setPricePerVisit(150);
		destination.setPricePerVisit(300);
		source.setDescription("C'est le feu fr�ro, fonce.");
		destination.setDescription("Zeus qui dab en sah, c'est la loi de la rue.");
		
		/*Route route = new Route();
		//route.setTransport(transport);
		route.setSource(source);
		route.setDestination(destination);
		
		Excursion excursion1 = new Excursion(1);
		excursion1.addRoute(route);
		
		Hotel hotel = new Hotel();
		hotel.setName(new String("Hotel 1"));
		hotel.setPricePerNight(66);
		
		HotelReservation reservation = new HotelReservation(hotel, 2);
		
		Offer offer1 = new Offer();
		offer1.setId(1);
		offer1.setTotalPrice(699);
		offer1.getExcursions().add(excursion1);
		offer1.getHotels().add(reservation);

		offers = new ArrayList<>();
		offers.add(offer1);
		*/
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
