package business.engine;

import business.model.location.AbstractLocation;

public class EngineUtility {

	public static double calculateDistance(AbstractLocation source, AbstractLocation destination) {
		double lat1 = source.getCoordinates().getLatitude();
		double lat2 = destination.getCoordinates().getLongitude();
		double lon1 = source.getCoordinates().getLatitude();
		double lon2 = destination.getCoordinates().getLongitude();

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		distance = Math.pow(distance, 2);
		distance = Math.sqrt(distance);

		return distance;
	}

}
