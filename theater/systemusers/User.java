package theater.systemusers;

import java.util.Scanner;

import theater.Cinema;

public abstract class User {

	protected String name; //First name and last name
	protected String username;
	protected String password;
	protected String email;
	protected String phone;
	protected boolean activeAccount;
	protected static Cinema cinema = Cinema.getInstance();
	
	public User(String name, String email, String phone) {
		// creating user with personal information:
		try {
			this.setName(name);
			this.setEmail(email);
			this.setPhone(phone);
		}
		catch (InvalidUserExeption e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void registration() {
		// register user
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter username: ");
		String username = sc.nextLine();
		System.out.println("Please enter password: ");
		String password = sc.nextLine();
		
		try {
			if(SystemCheck.inputValidation(username, password)) {
				this.username = username;
				this.password = password;
				Cinema.registrateUser(this.name, this);
				this.activeAccount = true;
			}
			else {
				System.out.println("Invalid user name or password! Enter again: ");
				registration();
			}
		} 
		catch (InvalidUserExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void signIn(String username, String password) {
		// first check for registration
		if(Cinema.registrationCheck(username, password)) {
			System.out.println(this.name + " you are logged in!");
			this.activeAccount = true;
		}
	}

	public  void logOut(String password) {
		System.out.println(this.name + " loging out!");
		this.activeAccount = false;
	}
	
	// getters:
	public static Cinema getCinema() {
		return User.cinema;
	}
	
	public String getPassword() {
		return password;
	}

	// setters:
	public void setName(String name) throws InvalidUserExeption {
		if(SystemCheck.validation(name)){
			this.name = name;
		}
		else {
			throw new InvalidUserExeption("Invalid Name");
		}
	}

	public void setEmail(String email) {
		try {
			if(SystemCheck.verifyEmail(email)){
				this.email = email;
			}
		}
		catch(InvalidUserExeption e){
			System.out.println(e.getMessage());
		}
		
	}

	public void setPhone(String phone) {
		try {
			if(SystemCheck.verifyPhoneNumber(phone)){
				this.phone = phone;
			}
		} catch (InvalidUserExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
}
