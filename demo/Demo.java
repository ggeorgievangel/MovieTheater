package demo;

import java.time.LocalTime;
import java.util.ArrayList;

import systemusers.Admin;
import systemusers.Client;
import theater.Cinema;
import theater.Movie;

public class Demo {

	public static void main(String[] args) {	
		
		Cinema cinema = Cinema.getInstance();
		// Add movies in the cinema
		cinema.addMovie(new Movie("The Avengers", "Action"));
		cinema.addMovie(new Movie("Scary Movie", "Comedy"));
		cinema.addMovie(new Movie("SAW", "Triller"));
		cinema.addMovie(new Movie("Stargate", "Sci-Fi"));
		cinema.setTheBroadcasts();
		
		//Make some people (10 Clients and one admin)
		ArrayList<Client> clients = new ArrayList();
		for(int i = 1; i <= 10;i++) {
			clients.add(new Client("Client" + i, "TheClient" + i,"1234" + i , "Batka" + i + "@abv.bg", "0875154515"));
		}
		Admin theAdmin = new Admin("Bai Admin", "TheAdmin", "azsumnumberone", "Golemiq@abv.bg", "0895666666");
		
		//Print the program of movies in the cinema
		cinema.printBroadcasts();
		
		
		
		
		
	}
}
