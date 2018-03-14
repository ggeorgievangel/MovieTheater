package theater;

import java.time.LocalTime;
import java.util.HashMap;

public class Hall {

	private int number;
	private int sits;
	private HashMap<Movie,LocalTime> movies = new HashMap<>(); // can be replaced with list of Broadcast objects
	
	public Hall(int number) {
		this.number = number;
		this.sits = 50;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getSits() {
		return sits;
	}
	
	void addMovie(Movie movie,LocalTime time) {
		this.movies.put(movie, time);
	}
	
	
}
