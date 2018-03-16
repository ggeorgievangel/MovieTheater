package systemusers;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SystemCheck {
	
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
	
}
