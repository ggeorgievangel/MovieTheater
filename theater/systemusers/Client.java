package theater.systemusers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.text.AbstractDocument.BranchElement;

import theater.Broadcast;
import theater.Movie;
import theater.Reservation;
import theater.Watchable;

import java.time.LocalDate;
public class Client extends User {

	private Set<Watchable> favoriteList = new HashSet<Watchable>();
	private List<Reservation> reservations = new ArrayList<>();
	
	
	public Client(String name, String username, String password, String email, String phone) {
		super(name, email, phone);
		// TODO Auto-generated constructor stub
	}

	public void addMovieToFavoriteList(Movie movie) {
		if(movie != null){
			this.favoriteList.add(movie);
		}
	}

	public void rateMovie(Movie m, int rate) {
		m.setRating(rate);
	}
	
	public void makeReservation(int places) {
		if(this.activeAccount) {
			ArrayList<Broadcast> broad = new ArrayList<Broadcast>(cinema.getBroadcasts());
			Broadcast b = broad.get(SystemCheck.getRandomNum(broad.size()-1));
			System.out.println(this.name + ": I'm making reservation for " + b.getMovie().getName() + " for " +b.getProjectionTime() + " in hall " + b.getProjectionHall().getNumber() + " and " + places + " sits");
			Reservation reserve = User.cinema.checkReservation(b,places);
			if(reserve != null) {
				System.out.println("Reservation is complete!");
				//Rate the movie
				this.rateMovie(b.getMovie(), SystemCheck.getRandomNum(2, 6));
				//Set the movie to favorite
				if(new Random().nextBoolean()) {
					this.addMovieToFavoriteList(b.getMovie());
				}
				this.reservations.add(reserve);
			}
		}
		else {
			System.out.println("You have to SignIn to make reservation!");
		}
	}
	
	public void cancelLastReservation() {
		if(this.activeAccount) {
			if(this.reservations.size() != 0) {
				this.reservations.get(this.reservations.size()-1).cancel();
				this.reservations.remove(this.reservations.size()-1);	
				System.out.println(this.name + " canvel my last reservation.");
			}else {
				System.out.println("No reservation to cancel!");
			}
		}else {
			System.out.println("You have to SignIn to cancel reservation!");
		}
	}
	
	
	public void reciveTicket(Reservation t) {
		if(t != null) {
			this.reservations.add(t);
		}
	}

	public Set<Watchable> getFavoriteList() {
		return Collections.unmodifiableSet(favoriteList);
	}

	
}
