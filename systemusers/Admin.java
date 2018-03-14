package systemusers;

import theater.Movie;

public class Admin extends User {
	
	
	public Admin(String name, String username, String password, String email, String phone) {
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
