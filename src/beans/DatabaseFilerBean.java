package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.engine.Engine;

@ManagedBean
@SessionScoped
public class DatabaseFilerBean implements Serializable {

	private static final long serialVersionUID = -678715989999679548L;

	private String name;

	private String description;

	public DatabaseFilerBean() {
	}

	public String fillIn() {
		Engine engine = new Engine();
		engine.createDescription(name, description);
		return "filled";
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
