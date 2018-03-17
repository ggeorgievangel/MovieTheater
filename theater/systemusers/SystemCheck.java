package theater.systemusers;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class SystemCheck {
	
	private SystemCheck() {
	}
	
	public static final int getRandomNum(int max) {
		Random r = new Random();
		return r.nextInt(max);
	}

	public static final int getRandomNum(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}

	public static boolean inputValidation(String username, String password) throws InvalidUserExeption {
		if(validation(username) && validation(password)) {
			return true;
		}
		else {
			throw new InvalidUserExeption("Invalid User name or password");
		}
	}

	public static boolean validation(String text)  {
		if( text != null && !text.trim().isEmpty()){
			return true;
		}
		return false;
	}
	
	public static boolean verifyEmail(String email) throws InvalidUserExeption {
	    if(!validation(email)) {
	    	 throw new InvalidUserExeption("Invalid e-mail");
	    }
	      
	    if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
	    	 throw new InvalidUserExeption("Invalid e-mail");
	    }   
	    return true;
	}
	
	public static boolean verifyName(String name) throws InvalidUserExeption {
		if(!validation(name)) {
			throw new InvalidUserExeption("Invalid Name");
	    }

	    if(!name.matches("[a-zA-Z]*")) {
			throw new InvalidUserExeption("Invalid Name");
	    }
	        
	    return true;
	}
	
	public static boolean verifyPhoneNumber(String number) throws InvalidUserExeption {
		if(!validation(number)) {
			throw new InvalidUserExeption("Invalid Phone number");
	    }

	    if(number.length() != 10 || !number.matches("[0-9]+")) {
			throw new InvalidUserExeption("Invalid Phone number");
	    }
	        
	    return true;
	}
	
	public static boolean verifyUsername(String username) throws InvalidUserExeption {

	    if(!username.matches("[A-Za-z0-9_]+")) {
			throw new InvalidUserExeption("Invalid User name");
	    }
	        
	    return true;
	}
	
	public static boolean verifyPassword(String password) throws InvalidUserExeption {
		if(!validation(password)) {
			throw new InvalidUserExeption("Invalid password");
	    }

	    if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$)")) {
	    	System.out.println("Pleas enter valid password: atleast one digit, one lowercase, one uppercase and at least one symbol!");
	    	throw new InvalidUserExeption("Invalid password");
	    }
	        
	    return true;
	}
	
}
