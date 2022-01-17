package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.engine.MockOfferBuilder;
import business.model.Offer;

@ManagedBean
@SessionScoped
public class ResultBean  {

	private List<Offer> offers;
	
    private MockOfferBuilder builder = new MockOfferBuilder();
    
    private Offer offer;
    
    @PostConstruct
    public void init() {
    	builder.init();
        offers = builder.getOffers();
    }

	public List<Offer> getOffers() {
		return offers;
	}

	public void setBuilder(MockOfferBuilder builder) {
		this.builder = builder;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
