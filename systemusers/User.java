package systemusers;

import java.util.Scanner;

import theater.Cinema;

public abstract class User {
	

	protected String name; //First name and last name
	protected String username;
	protected String password;
	protected String email;
	protected String phone;
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
			Cinema.registrateUser(this.name, this);
			this.activeAccount = true;
		}
		else {
			System.out.println("Invalid user name or password!");
		}
	}
	
	public boolean signIn(String username, String password) {
		// first check for registration
		if(Cinema.registrationCheck(username, password)) {
			System.out.println(this.name + " you are logged in!");
			this.activeAccount = true;
			return true;
		}
		return false;
	}

	public  void logOut(String password) {
		System.out.println(this.name + " loging out!");
		this.activeAccount = false;
	}
	
	public static Cinema getCinema() {
		return User.cinema;
	}
	
	public String getPassword() {
		return password;
	}
}
