package theater;

import java.time.LocalDateTime;

public class Broadcast {

	private Movie movie;
	private LocalDateTime projectionTime;
	private Hall projectionHall;
	
	public Broadcast(Movie movie, LocalDateTime projectionTime, Hall projectionHall, int places) {
		this.movie = movie;
		this.projectionTime = projectionTime;
		this.projectionHall = projectionHall;
	}
	
}
