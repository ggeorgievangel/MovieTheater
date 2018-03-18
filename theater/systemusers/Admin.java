package theater.systemusers;

import theater.Cinema;
import theater.Movie;

public class Admin extends User {
	
	protected static Cinema cinema = Cinema.getInstance();
	private static Admin instance = null;
	
	private Admin() {
		// Admin (Name, username, password, email, phone)
		super("Administartor", "admin", "admin", "admincho@abv.bg", "0888111222");
	}
	
	public static Admin getInstance() {
		if (instance == null) {
			instance = new Admin();
			return instance;
		}
		return instance;
	}
	
	public void addMovie(Movie movie) {
		if(movie != null){
			this.cinema.addMovie(movie);
		}
	}
	
	public void removeMovie(Movie movie) {
		if(movie != null){
			this.cinema.removeMovie(movie);
		}
	}
	
	public void addBroadcast() {
		// TODO
	}
	
	public void removeBroadcast() {
		// TODO
	}
	
	public void removeUser() {
		// TODO
	}
	
	public void cancelUserReservation() {
		
	}
	
	public void cancelAllReservations() {
		
	}
}
