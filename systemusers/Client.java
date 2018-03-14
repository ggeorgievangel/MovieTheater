package systemusers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import theater.Movie;
import theater.reservationTicket;
import java.time.LocalDate;
public class Client extends User {

	private Set<Movie> watchList;
	private List<reservationTicket> reservations = new ArrayList<>();

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

	public void rateMovie() {
		// TODO
	}
	
	public void makeReservation() {
		//Choose movie from Cinema movie list
		//Choose time and date
	}
	
	
}
