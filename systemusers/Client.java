package systemusers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.AbstractDocument.BranchElement;

import theater.Broadcast;
import theater.Movie;
import theater.Reservation;
import java.time.LocalDate;
public class Client extends User {

	private Set<Movie> watchList = new HashSet();
	private List<Reservation> reservations = new ArrayList<>();

	public Client(String name, String username, String password, String email, String phone) {
		super(name, username, password, email, phone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void signIn(String username,String password) {
		
		
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
	}
	
	public void addMovieToWatchList(Movie movie) {
		if(movie != null){
			this.watchList.add(movie);
		}
	}

	public void rateMovie(int rate) {
		// select movie
		Movie m = null;
		m.setRating(rate);
	}
	
	public void makeReservation(int places) {
		ArrayList<Broadcast> broad = new ArrayList(cinema.getBroadcasts());
		Broadcast b = broad.get(Supp.getRandomNum(broad.size()-1));
		System.out.println(this.name + ": I'm making reservation for " + b.getMovie().getName() + " for " +b.getProjectionTime() + " in hall " + b.getProjectionHall().getNumber() + " and " + places + " sits");
		Reservation reserve = this.cinema.checkReservation(b,places);
		if(reserve != null) {
			System.out.println("Reservation is complete!");
			this.reservations.add(reserve);
		}
	}
	
	public void cancelLastReservation() {
		if(this.reservations.size() != 0) {
			this.reservations.get(this.reservations.size()-1).cancel();
			this.reservations.remove(this.reservations.size()-1);	
			System.out.println(this.name + " canvel my last reservation.");
		}else {
			System.out.println("No reservation to cancel!");
		}
		
	}
	
	
	public void reciveTicket(Reservation t) {
		if(t != null) {
			this.reservations.add(t);
		}
	}
}
