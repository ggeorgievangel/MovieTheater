package theater;

import java.util.Map;

import theater.systemusers.Client;
import theater.systemusers.User;

public class Admin extends User {
	
	
	private static Admin adminInstance = null;
	private static Cinema movieTheater = Cinema.getInstance();
	
	private Admin() {
		// Admin (Name, username, password, email, phone)
		super("Administartor", "admin", "admin", "admincho@abv.bg", "0888111222");
	}
	
	public static Admin getInstance() {
		if (adminInstance == null) {
			adminInstance = new Admin();
			return adminInstance;
		}
		return adminInstance;
	}
	
	public void removeUser(Client c) {
		if(this.getAccountStatus()) {
			Cinema.getInstance().removeUser(c);
		}
		return;
	}
	
	public void addMovieToCinema(Movie movie) {
		if(this.getAccountStatus() && movie != null){
			Cinema.getInstance().addMovie(movie);
		}
	}
	
	public void removeMovie(Movie movie) {
		if(this.getAccountStatus() && movie != null){
			Cinema.getInstance().removeMovie(movie);
		}
	}
	
	public void addBroadcasts() {
		if(this.getAccountStatus()) {
			Cinema.getInstance().setTheBroadcasts();
		}
	}
	
	public void printBroadcasts() {
		if(this.getAccountStatus()) {
			Cinema.getInstance().printBroadcasts();
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