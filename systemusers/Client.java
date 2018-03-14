package systemusers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import theater.Broadcast;
import theater.Movie;
import theater.Reservation;
import java.time.LocalDate;
public class Client extends User {

	private Set<Movie> watchList;
	private List<Reservation> reservations = new ArrayList<>();

	public Client(String name, String username, String password, String email, String phone) {
		super(name, username, password, email, phone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void signIn() {
		// TODO Auto-generated method stub
		
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
		// Choose broadcast from Cinema broadcast list by typing:
			// movie
			// Date and Time
		Broadcast b = null;
		Client.getCinema().checkReservation(b, places);
	}
	
	public void reciveTicket(Reservation t) {
		if(t != null) {
			this.reservations.add(t);
		}
	}
}
