package theater;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {
	
	private Movie movie;
	private LocalDateTime projectionTime;
	private Hall projectionHall;
	private int places;
	
	public Ticket(Movie movie, LocalDateTime projectionTime, Hall projectionHall, int places) {
		this.movie = movie;
		this.projectionTime = projectionTime;
		this.projectionHall = projectionHall;
		this.places = places;
	}
}
