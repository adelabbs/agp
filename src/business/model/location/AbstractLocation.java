package business.model.location;

import business.model.transport.Transport;

/**
 * 
 * Represents a location on an Island.
 *
 */
public abstract class AbstractLocation {

	protected String name;
	protected Coordinates coordinates;

	protected String island;
	protected Transport transport;
	protected int price;

	public AbstractLocation() {

	}

	public AbstractLocation(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public String getIsland() {
		return island;
	}

	public void setIsland(String island) {
		this.island = island;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
