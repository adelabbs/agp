package business.model.location;

import business.model.transport.AbstractTransport;

public abstract class AbstractLocation {

	private String name;
	private Coordinates coordinates;

	private String island;
	private AbstractTransport transport;
	
	public AbstractLocation() {
		
	}

	public AbstractLocation(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public AbstractTransport getTransport() {
		return transport;
	}

	public void setTransport(AbstractTransport transport) {
		this.transport = transport;
	}

	public String getIsland() {
		return island;
	}

	public void setIsland(String island) {
		this.island = island;
	}
}
