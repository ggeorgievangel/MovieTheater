package theater.systemusers;

import theater.Movie;

public class Admin extends User {
	
	
	public Admin(String name, String email, String phone) {
		super(name, email, phone);
	}

	public void addMovie(Movie movie) {
		if(movie != null){
			User.getCinema().addMovie(movie);
		}
	}
	
	public void removeMovie(Movie movie) {
		if(movie != null){
			User.getCinema().removeMovie(movie);
		}
	}
	
	public void addBroadcast() {
		// TODO
	}
	
	public void removeBroadcast() {
		// TODO
	}
}
