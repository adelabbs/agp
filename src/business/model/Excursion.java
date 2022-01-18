package business.model;

import java.util.LinkedList;

public class Excursion {

	private LinkedList<Route> routes = new LinkedList<Route>();

	private int day;

	public Excursion(int day) {
		this.day = day;

	}

	public LinkedList<Route> getRoutes() {
		return routes;
	}

	public void addRoute(Route route) {
		if (!routes.contains(route)) {
			routes.add(route);
		}
	}

	public void removeRoute(Route route) {
		routes.remove(route);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
