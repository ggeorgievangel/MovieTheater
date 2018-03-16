package systemusers;

import theater.Cinema;

public abstract class User {
	
	private String name; //First name and last name
	private String username;
	private String password;
	private String email;
	private String phone;
	protected static Cinema cinema;
	
	public User(String name, String username, String password, String email, String phone) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.cinema = Cinema.getInstance();
	}

	public abstract void signIn();
	public abstract void logOut();
	
	public static Cinema getCinema() {
		return User.cinema;
	}
	
}
