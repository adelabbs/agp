package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.model.location.Site;

@ManagedBean
@SessionScoped
public class DatabaseFilerBean implements Serializable {

	private static final long serialVersionUID = -678715989999679548L;

	private Site site;
	
	public DatabaseFilerBean() {}
	
	public String fillIn() {
		//TODO appeler une méthode de business pour remplir la bdd
		return "filled";
	}

	public String getDescription() {
		return site.getDescription();
	}

	public void setDescription(String description) {
		site.setDescription(description);
	}
	
	public String getName() {
		return site.getName();
	}
}
