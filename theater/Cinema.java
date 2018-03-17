package theater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import theater.systemusers.Client;
import theater.systemusers.SystemCheck;
import theater.systemusers.User;

public class Cinema {

	// Singleton class
	private static final int MAX_MOVIE_FOR_THE_WEEK = 4;
	private static final int ALL_HALLS = 4;
	private static final String PATH_FOR_MOVIES = "Movies.txt";
	private static Cinema instance = null;
	private String name;
	private String address;
	private static TreeMap<String, User> users = new TreeMap<>(); // Collection <username, user>
	private Set<Watchable> movies = new HashSet<>();
	private LinkedHashSet<Hall> halls = new LinkedHashSet<>();
	private TreeSet<Broadcast> broadcasts = new TreeSet<>();

	private Cinema() {
		this.name = "Botevgrad Movie Theater";
		this.address = "Cinema Str 7";
		for (int i = 1; i <= ALL_HALLS; i++) {
			this.halls.add(new Hall(i, this));
		}
		//Read from the file all the movies
		try {
			File movieFile = new File(Cinema.PATH_FOR_MOVIES);
			if(!movieFile.exists()) {
				movieFile.createNewFile();
			}else {
				FileInputStream fis = new FileInputStream(movieFile);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object tempobj;
				if((tempobj = ois.readObject()) != null) {
					this.movies = (HashSet)tempobj;
				}
				ois.close();
			}
		}catch (IOException e) {
			System.out.println("Somethin is wrong with the movie arhive file on intput!!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("cnfe");
			e.printStackTrace();
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
		//Get all the movies and shuffle them so we can get a random movie every week
		ArrayList<Watchable> movies = new ArrayList<>(this.movies);
		Collections.shuffle(movies);
		for (Watchable w : movies) {
			this.broadcasts.add(new Broadcast(w, LocalTime.of(10, 00), halls.get(i)));
			this.broadcasts.add(new Broadcast(w, LocalTime.of(14, 00), halls.get(i)));
			this.broadcasts.add(new Broadcast(w, LocalTime.of(19, 00), halls.get(i)));
			this.broadcasts.add(new Broadcast(w, LocalTime.of(22, 30), halls.get(i)));
			if(Cinema.MAX_MOVIE_FOR_THE_WEEK == i) {
				break;
			}
			i++;
		}
	}

	public void printBroadcasts() {
		System.out.println("#########Broadcast for the week in cinema " + this.name + "########");
		System.out.println();
		for (Broadcast b : this.broadcasts) {
			System.out.println(b.getMovie().getName() + " from " + b.getProjectionTime());
		}
		System.out.println();
		System.out.println();
	}

	public Reservation checkReservation(Broadcast b, int places) {
		// check is there enough places for this broadcast
		if (b.getPlaces() < places) {
			// else if free places are not enough --> message
			System.out.println("Sorry, not eneug free sits for this broadcast.");
		}
		// if there are enough places --> return reservation for this broadcast with places
		return new Reservation(b, places);
	}

	public void addMovie(Movie movie) {
		boolean containsMovie = this.movies.contains(movie);
		if (movie != null) {
			this.movies.add(movie);
			if(!containsMovie) {
				addMovieToArchive(movie);	
			}
		}
	}

	private void addMovieToArchive(Movie m) {
		try {
			//Add movies to file
		File movieFile = new File(Cinema.PATH_FOR_MOVIES);
		if(!movieFile.exists()) {
			movieFile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(movieFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this.movies);
		oos.flush();
		oos.close();
		
		}catch (IOException e) {
			System.out.println("Somethin is wrong with the movie arhive file on output!!");
		}
	}
	
	public void removeMovie(Movie movie) {
		if (movie != null) {
			this.movies.remove(movie);
		}
	}

	public Set<Broadcast> getBroadcasts() {
		return Collections.unmodifiableSet(broadcasts);
	}

	public static boolean registrationCheck(String inputUsername, String inputPassword) {
		if(users.containsKey(inputUsername)) {
			if(users.get(inputUsername).getPassword().equals(inputPassword)) {
				return true;
			}
		}
		return false;
	}

	public static void registrateUser(String username, User user) {
		users.put(username, user);
	}

	public String getName() {
		return name;
	}

	public static void removeUser(String oldUsername) {
		// TODO Auto-generated method stub
		
	}
	
}
