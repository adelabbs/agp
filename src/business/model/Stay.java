package business.model;

public class Stay {

	private int checkIn;
	private int checkOut;

	public Stay(int checkIn, int checkOut) {
		if (checkIn <= checkOut) {
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		} else {
			throw new IllegalArgumentException("Check-in must be before check-out");
		}
	}

	public int getCheckIn() {
		return checkIn;
	}

	public int getCheckOut() {
		return checkOut;
	}

	public int getStayDuration() {
		return checkOut - checkIn + 1;
	}

}
