package demo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

import theater.systemusers.Admin;
import theater.systemusers.Client;

import theater.systemusers.SystemCheck;
import theater.systemusers.User;
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
		for(int i = 1; i <= 3;i++) {
			Client c = new Client("Client" + i, "TheClient" + i,"1234" + i , "Batka" + i + "@abv.bg", "0875154510");
			clients.add(c);
			c.registration();
			c.logOut(c.getPassword());
		}
		
		Admin theAdmin = new Admin("Bai Admin", "TheAdmin", "azsumnumberone", "Golemiq@abv.bg", "0895666666");
		//Print the program of movies in the cinema
		cinema.printBroadcasts();
		//Make reservations
		for(Client c : clients) {
			c.makeReservation(SystemCheck.getRandomNum(1, 10));
		}
		//3 clients to cancel reservations
		clients.get(SystemCheck.getRandomNum(clients.size()-1)).cancelLastReservation();
		clients.get(SystemCheck.getRandomNum(clients.size()-1)).cancelLastReservation();
		clients.get(SystemCheck.getRandomNum(clients.size()-1)).cancelLastReservation();
		
		
	}
}
