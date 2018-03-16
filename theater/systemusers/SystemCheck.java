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

	public static boolean inputValidation(String username, String password) {
		if(validation(username) && validation(password)) {
			return true;
		}
		return false;
	}

	private static boolean validation(String text) {
		if( text != null && !text.trim().isEmpty()){
			return true;
		}
		return false;
	}
	
	public static boolean verifyEmail(String email){
	    if(!validation(email)) {
	    	 return false;
	    }
	      
	    if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
	    	return false;
	    }
	        
	    return true;
	}
	
	public static boolean verifyName(String name){
		if(!validation(name)) {
	    	 return false;
	    }

	    if(!name.matches("[a-zA-Z]*")) {
	    	return false;
	    }
	        
	    return true;
	}
	
	public static boolean verifyPhoneNumber(String number){
		if(!validation(number)) {
	    	 return false;
	    }

	    if(number.length() != 10 || !number.matches("[0-9]+")) {
	    	return false;
	    }
	        
	    return true;
	}
	
	public static boolean verifyUsername(String username){

	    if(!username.matches("[A-Za-z0-9_]+")) {
	    	return false;
	    }
	        
	    return true;
	}
	
	public static boolean verifyPassword(String password){
		if(!validation(password)) {
	    	 return false;
	    }

	    if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$)")) {
	    	System.out.println("Pleas enter valid password: atleast one digit, one lowercase, one uppercase and at least one symbol!");
	    	return false;
	    }
	        
	    return true;
	}
	
}
