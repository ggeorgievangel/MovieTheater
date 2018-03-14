package theater;
import java.util.Set;
import java.util.TreeSet;

public class Cinema {
	// Singleton class
	private static Cinema instance = null;
	private String name;
	private String address;
	private TreeSet<Hall> halls;
	private Set<Movie> movies;
	
	private Cinema() {
		this.name = "Botevgrad Movie Theater";
		this.address = "ul. Filmova 7";
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
	
}
