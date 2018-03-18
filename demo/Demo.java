package demo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import theater.systemusers.Client;

import theater.systemusers.SystemCheck;
import theater.systemusers.User;
import theater.Admin;
import theater.Cinema;
import theater.Movie;

public class Demo {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
	
		//creating Cinema:
		Cinema cinema = Cinema.getInstance();
		
		// admin signIn with username: admin, password: admin
		Admin admin = Admin.getInstance();
		System.out.println("Admin signIn, please enter admin username: ");
		String adminUsername = sc.nextLine();
		System.out.println("Admin signIn, please enter admin password: ");
		String adminPass = sc.nextLine();
		
		admin.signIn(adminUsername, adminPass);
		
		// Add movies in the cinema
		admin.addMovieToCinema(new Movie("The Avengers", "Action"));
		admin.addMovieToCinema(new Movie("Scary Movie", "Comedy"));
		admin.addMovieToCinema(new Movie("SAW", "Triller"));
		admin.addMovieToCinema(new Movie("Stargate", "Sci-Fi"));
		
		System.out.println("\nALL MOVIES IN: " + cinema.getName());
		cinema.showAllMovies();
		
		// set the broadcasts and print the movies for the week
		admin.addBroadcasts();
		cinema.printBroadcasts();
		
		
		
		System.out.println("         For the demo lets register some clients ");
		System.out.println("         Lets begin the registrations: ");
		
		//Make some people (10 Clients and one admin)
		ArrayList<Client> clients = new ArrayList();
		for(int i = 1; i <= 3;i++) {
			Client client = new Client("Client" + i, "client" + i + "@abv.bg", "0875154510");
			clients.add(client);
			if(client != null) {
				client.registration();
			}
		}
	
		//Make reservations
		for(Client c : clients) {
			c.makeReservation(cinema, SystemCheck.getRandomNum(1, 10));
		}

		clients.get(0).profileChanges();
		clients.get(1).profileChanges();
		
		//3 clients to cancel reservations
		clients.get(SystemCheck.getRandomNum(clients.size()-1)).cancelLastReservation();
		clients.get(SystemCheck.getRandomNum(clients.size()-1)).cancelLastReservation();
		clients.get(SystemCheck.getRandomNum(clients.size()-1)).cancelLastReservation();
		
		admin.removeUser(clients.get(1));
		cinema.showAllUsers();

	}
}
