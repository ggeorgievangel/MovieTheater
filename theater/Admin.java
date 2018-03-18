package theater;

import java.util.Map;

import theater.systemusers.Client;
import theater.systemusers.User;

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
	
	public void removeUser(Client c) {
		if(this.getAccountStatus()) {
			this.cinema.removeUser(c);
		}
		return;
	}
	
	public void addMovie(Movie movie) {
		if(this.getAccountStatus() && movie != null){
			this.cinema.addMovie(movie);
		}
	}
	
	public void removeMovie(Movie movie) {
		if(this.getAccountStatus() && movie != null){
			this.cinema.removeMovie(movie);
		}
	}
	
	public void addBroadcasts() {
		if(this.getAccountStatus()) {
			this.cinema.setTheBroadcasts();
		}
	}
	
	public void removeBroadcast() {
		// TODO
	}
	
	public void cancelUserReservation() {
		// TODO
	}
	
	public void cancelAllReservations() {
		// TODO
	}
}