package theater;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


import systemusers.Client;
import systemusers.SystemCheck;
import systemusers.User;

public class Cinema {
	
	// Singleton class
	private static final int ALL_HALLS = 4;
	private static Cinema instance = null;
	private String name;
	private String address;
	private static TreeSet<User> users = new TreeSet<>();
	private Set<Watchable> movies = new HashSet<>();
	private LinkedHashSet<Hall> halls = new LinkedHashSet<>();
	private TreeSet<Broadcast> broadcasts = new TreeSet<>();
	
	private Cinema() {
		this.name = "Botevgrad Movie Theater";
		this.address = "Cinema Str 7";
		for (int i = 1; i <= ALL_HALLS; i++) {
			this.halls.add(new Hall(i,this));
		}
	}
	
	public static Cinema getInstance() {
		if (instance == null) {
			instance = new Cinema();
			return instance;
		}
		return instance;
	}
	
	public void setTheBroadcasts() {
		int i = 0;
		ArrayList<Hall> halls = new ArrayList<>(this.halls);
		for(Watchable w : this.movies) {
			this.broadcasts.add(new Broadcast(w,LocalTime.of(10, 00),halls.get(i)));
			this.broadcasts.add(new Broadcast(w,LocalTime.of(14, 00),halls.get(i)));
			this.broadcasts.add(new Broadcast(w,LocalTime.of(19, 00),halls.get(i)));
			this.broadcasts.add(new Broadcast(w,LocalTime.of(22, 30),halls.get(i)));
			i++;
		}
	}
	
	public void printBroadcasts() {
		System.out.println("#########Broadcast for the day in cinema " + this.name + "########");
		System.out.println();
		for(Broadcast b : this.broadcasts) {
			System.out.println(b.getMovie().getName() + " from " + b.getProjectionTime() + " in hall " + b.getProjectionHall().getNumber());
		}
		System.out.println();
		System.out.println();
	}
	

	public Reservation checkReservation(Broadcast b, int places) {
		// check is there enough places for this broadcast
			// if there are enough places --> return reservation for this broadcast with places
			// else if free places are not enough --> message
		if(b.getPlaces() < places) {
			 System.out.println("Sorry, not eneug free sits for this broadcast.");
		}
		return new Reservation(b,places);
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
	
	public void registurClient() {
		
	}
	
	
	public Set<Broadcast> getBroadcasts() {
		return Collections.unmodifiableSet(broadcasts);
	}

	public static boolean registrationCheck() {
		for(User u : users) {
			
		}
		return false;
	}

	public static void registrateUser(User user) {
		users.add(user);
		
	}
	
}
