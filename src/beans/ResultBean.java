package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Lazy;

import business.engine.MockOfferBuilder;
import business.model.Offer;

@ManagedBean
@SessionScoped
@Lazy
public class ResultBean implements Serializable {

	private static final long serialVersionUID = -1168123493777752654L;

	private List<Offer> offers;
	
    private MockOfferBuilder builder = new MockOfferBuilder();
    
    @PostConstruct
    public void init() {
    	builder.init();
        offers = builder.getOffers();
    }
    
    public String printInfos() {
    	return "entry";
    }

	public List<Offer> getOffers() {
		return offers;
	}

	public MockOfferBuilder getBuilder() {
		return builder;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public void setBuilder(MockOfferBuilder builder) {
		this.builder = builder;
	}
}
