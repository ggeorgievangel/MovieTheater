package theater;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import systemusers.Client;

public class Cinema {
	// Singleton class
	private static final int ALL_HALLS = 5;
	private static Cinema instance = null;
	private String name;
	private String address;
	private Set<Client> clients;
	private Set<Watchable> movies;
	private LinkedHashSet<Hall> halls;
	private Set<Broadcast> broadcasts;
	
	private Cinema() {
		this.name = "Botevgrad Movie Theater";
		this.address = "Cinema Str 7";
		for (int i = 1; i <= ALL_HALLS; i++) {
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
	
	public void checkReservation(Broadcast b, int places) {
		// check is there enough places for this broadcast
			// if there are enough places --> return reservation for this broadcast with places
			// else if free places are not enough --> message
	}

	
	
	public void addMovie(Movie movie) {
		if(movie != null){
			this.movies.add(movie);
		}
	}
	
	public void removeMovie(Movie movie) {
		if(movie != null){
			this.movies.remove(movie);
		}
	}
	
	
}
