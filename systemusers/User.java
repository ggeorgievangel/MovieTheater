package systemusers;

import java.util.Scanner;

import theater.Cinema;

public abstract class User {
	
	private String name; //First name and last name
	private String username;
	private String password;
	private String email;
	private String phone;
	private boolean activeAccount;
	protected static Cinema cinema;
	
	public User(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cinema = Cinema.getInstance();
	}

	public void registration() {
		Scanner sc = new Scanner(System.in);
		
		String username = sc.nextLine();
		String password = sc.nextLine();
		
		if(SystemCheck.inputValidation(username, password)) {
			this.username = username;
			this.password = password;
			Cinema.registrateUser(this);
		}
		else {
			System.out.println("Invalid user name or password!");
		}	
	}
	
	public boolean signIn(String username, String password) {
		// first check for registration
		if(Cinema.registrationCheck()) {
			this.activeAccount = true;
			return true;
		}
		return false;
	}

	

	public  void logOut(String password) {
		
	}
	
	public static Cinema getCinema() {
		return User.cinema;
	}
	
	public String getPassword() {
		return password;
	}
	
}
