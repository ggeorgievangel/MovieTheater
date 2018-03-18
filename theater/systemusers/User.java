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
	
	protected User(String name, String username, String password, String email, String phone) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
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
				Cinema.registrateUser(this.username, this);
				this.activeAccount = true;
			}
			else {
				System.out.println("Invalid user name or password! Enter again: ");
				registration();
			}
		} 
		catch (InvalidDataExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void signIn(String username, String password) {
		// first check for registration
		if(Cinema.registrationCheck(username, password)) {
			this.activeAccount = true;
			System.out.println(this.name + " you are logged in!");
		}
	}

	public void logOut(String password) {
		System.out.println(this.name + " loging out!");
		this.activeAccount = false;
		System.out.println(this.name + " - logout from profile!");
	}
	
	// getters:
	
	// this is not cool, we are using it for a check when user with registration try to signIn
	public String getPassword() {
		return password;
	}

	// setters:
	protected void setName(String name) throws InvalidUserExeption {
		try {
			if(SystemCheck.validation(name)) {
				this.name = name;
			}
		}
		catch (InvalidDataExeption e) {
			throw new InvalidUserExeption(e.getMessage(), e);
		}
	}

	protected void setEmail(String email) throws InvalidUserExeption{
		try {
			if(SystemCheck.verifyEmail(email)){
				this.email = email;
			}
		}
		catch (InvalidDataExeption e) {
			throw new InvalidUserExeption(e.getMessage(), e);
		}
		
	}

	protected void setPhone(String phone) throws InvalidUserExeption{
		try {
			if(SystemCheck.verifyPhoneNumber(phone)){
				this.phone = phone;
			}
		} 
		catch (InvalidDataExeption e) {
			throw new InvalidUserExeption(e.getMessage(), e);
		}
	}
	
	// private method.. used only when user wants to change password
	private void setPassword(String newPassword) {
		Scanner sc = new Scanner(System.in);
		try {
			if(SystemCheck.inputValidation(this.username, newPassword)) { 
				this.password = newPassword;
				System.out.println(this.name + " set new password!");
				this.logOut(newPassword);
				System.out.println("Please signIn again with your new password!");
				String passCheck = sc.nextLine();
				this.signIn(this.username, passCheck);
			}
		} 
		catch (InvalidDataExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void profileChanges() {
		Scanner sc = new Scanner(System.in);
		System.out.println(this.name + " wants to make some profile changes: ");
		System.out.println("to change your password type: password" );
		System.out.println("to change your name type: name");
		System.out.println("to change your e-mail: mail" );
		System.out.println("to change your phorne type: phone" );
		
		try{
			String change = sc.nextLine();
			if(SystemCheck.checkChanges(change)) {
				switch (change) {	
					case "password":
					System.out.println("Please enter new password: ");
					String newPassword = sc.nextLine();
					this.setPassword(newPassword);
					break;
					case "name":
						System.out.println("Please enter new name: ");
						String newName = sc.nextLine();
						this.setName(newName);
						break;
					case "mail":
						System.out.println("Please enter new e-mail: ");
						String newMail = sc.nextLine();
						this.setEmail(newMail);
						break;
					case "phone":
						System.out.println("Please enter new phone number: ");
						String newPhone = sc.nextLine();
						this.setPhone(newPhone);
						break;
					default:
						break;
				}
			}
		}
		catch (InvalidUserExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void showUserInfo() {
		System.out.println("\n=====User information=====");
		System.out.println("name: " + this.name + 
						  "\nusername:" + this.username + 
						  "\ne-mail: "+ this.email + 
						  "\nphone: "+ this.phone);
		System.out.println("==========================");
	}
}
