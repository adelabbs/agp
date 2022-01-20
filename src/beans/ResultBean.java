package beans;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Lazy;

import business.engine.Engine;
import business.model.Offer;

@ManagedBean
//@SessionScoped
@RequestScoped
public class ResultBean implements Serializable {

	private static final long serialVersionUID = -1168123493777752654L;

	private List<Offer> offers;
	    
    private Engine engine;
    
    @ManagedProperty(value = "#{entryBean}")
	private EntryBean entryBean;
    
    @PostConstruct
    public void init() {
    	engine = new Engine();
    	engine.setSearchEntry(entryBean.getEntry());
    	engine.buildRecommendations();	
        offers = engine.getOffers();
    }
    
    public String printInfos() {
    	return "entry";
    }

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public EntryBean getEntryBean() {
		return entryBean;
	}

	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}
	
	
}
