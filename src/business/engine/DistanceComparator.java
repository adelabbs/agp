package business.engine;

import java.util.Comparator;

import business.model.location.Hotel;

/**
 * 
 * This utility class is used to compare 2 sites, given their id and the
 * distance matrix. The comparison determines the closest {@link Site} from the
 * {@link Hotel} corresponding to the provided idHotel.
 *
 */
public class DistanceComparator implements Comparator<Integer> {

	private double[][] distanceMatrix;
	private int idHotel = -1;

	public DistanceComparator(double[][] distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}
	
	@Override
	public int compare(Integer idSite1, Integer idSite2) {
		if (idHotel < 0 || distanceMatrix == null) {
			throw new IllegalArgumentException("Parameters are not set.");
		}
		return (int) (distanceMatrix[idHotel][idSite2] - distanceMatrix[idHotel][idSite1]); // decreasing order
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		if (idHotel >= 0) {
			this.idHotel = idHotel;
		}
	}

}
