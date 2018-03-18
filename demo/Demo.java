package demo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import theater.systemusers.Admin;
import theater.systemusers.Client;

import theater.systemusers.SystemCheck;
import theater.systemusers.User;
import theater.Cinema;
import theater.Movie;

public class Demo {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
	
		//creating Cinema:
		Cinema cinema = Cinema.getInstance();
		
		// creating admin and signIn with username: admin, password: admin
		Admin admin = Admin.getInstance();
		System.out.println("Admin signIn, please enter admin username: ");
		String adminUsername = sc.nextLine();
		System.out.println("Admin signIn, please enter admin password: ");
		String adminPass = sc.nextLine();
		admin.signIn(adminUsername, adminPass);
		System.out.println(admin.getPassword());
		// Add movies in the cinema
		cinema.addMovie(new Movie("The Avengers", "Action"));
		cinema.addMovie(new Movie("Scary Movie", "Comedy"));
		cinema.addMovie(new Movie("SAW", "Triller"));
		cinema.addMovie(new Movie("Stargate", "Sci-Fi"));
		// set the broadcasts and print the movies for the week
		cinema.setTheBroadcasts();
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
		
		for(Client c : clients) {
			c.showUserInfo();
		}

	}
}
