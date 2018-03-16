package systemusers;

import theater.Cinema;

public abstract class User {
	
	protected String name; //First name and last name
	protected String username;
	protected String password;
	protected String email;
	protected String phone;
	protected static Cinema cinema;
	
	public User(String name, String username, String password, String email, String phone) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.cinema = Cinema.getInstance();
	}

	public abstract void signIn(String username,String password);
	public abstract void logOut();
	
	public static Cinema getCinema() {
		return User.cinema;
	}
	
}
