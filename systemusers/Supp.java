package systemusers;

import java.util.Random;

public class Supp {
	
	public static final int getRandomNum(int max) {
		Random r = new Random();
		return r.nextInt(max);
	}

	public static  final int getRandomNum(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
}
	
}
