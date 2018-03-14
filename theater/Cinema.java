package theater;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import systemusers.Client;

public class Cinema {
	
	// Singleton class
	private static Cinema instance = null;
	private String name;
	private String address;
	private TreeSet<Hall> halls;
	private HashSet<Movie> movieCatalog;
	private HashSet<Client> clients;
	
	private Cinema() {
		this.name = "Botevgrad Movie Theater";
		this.address = "Cinema Str 7";
		for (int i = 1; i <= 5; i++) {
			this.halls.add(new Hall(i));
		}
	}
	
	public static Cinema getInstance() {
		if (instance == null) {
			instance = new Cinema();
			return instance;
		}
		return instance;
	}
	
	public void acceptReservation(Movie m, int places) {
		// check in which hall is this movie projected
			// if there are enough places --> reserve 
			// if free places < places --> message
		
		
	}

	public void addMovie(Movie movie) {
		if(movie != null){
			this.movieCatalog.add(movie);
		}
	}
	
	public void removeMovie(Movie movie) {
		if(movie != null){
			this.movieCatalog.remove(movie);
		}
	}
	
	
}
