package theater;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
	
	private Broadcast broadcast;
	private int places;
	
	public Reservation(int places) {
		this.places = places;
	}
}
