package theater;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class reservationTicket {

	
	private Movie movie;
	private LocalDateTime projectionTime;
	private Hall projectionHall;

	public reservationTicket(Movie movie, LocalDateTime projectionTime, Hall projectionHall) {
		this.movie = movie;
		this.projectionTime = projectionTime;
		this.projectionHall = projectionHall;
	}
	
}
