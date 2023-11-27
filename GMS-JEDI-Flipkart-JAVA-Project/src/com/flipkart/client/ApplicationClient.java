package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.flipkart.bean.User;
import com.flipkart.business.UserLogicImpl;

public class ApplicationClient {

	public static void login() throws Exception
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String username = in.next();
		System.out.println(username+" ->"+username);
		System.out.println("Enter your correct password: ");
		String password = in.next();

		User user = new User(username,password,0);
		UserLogicImpl authentication = new UserLogicImpl();
		LocalDateTime localDateTime = LocalDateTime.now();
		if(authentication.authenticateUser(user) != null) {
			System.out.println("Welcome " + username + "! You are logged in.");
			System.out.println("Current Date and Time: "+ localDateTime);
			int role = user.getRoleId();
			switch(role) {
				case 1:
					CustomerGMSMenu Customer = new CustomerGMSMenu();
					Customer.CustomerActionPage(in, user.getEmail());

					break;
				case 2:

					break;
				case 3:
					AdminGMSMenu Admin = new AdminGMSMenu();
					Admin.AdminPage(in);
					break;
			}
		}else {
			login();
		}

	}

	public static void mainPage() throws Exception {
	    System.out.println("Welcome to FlipFit Application");



	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the role");
	    String role = sc.next();
	    if(role.equalsIgnoreCase("Admin"))
	    {

	          System.out.println("Welcome to Admin Menu");
	          AdminGMSMenu admin=new AdminGMSMenu();
			  admin.AdminPage(sc);

	    }
	    else if(role.equalsIgnoreCase("Customer"))
	    {
	       System.out.println("Welcome to Customer Menu");
			CustomerGMSMenu customer=new CustomerGMSMenu();
			//while(true){
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				switch (choice) {
					case 1:
						customer.CustomerRegistration(sc);
						break;
					case 2:
						login();
						break;
					case 3:
						ApplicationClient.mainPage();
						break;
					default:
						System.out.println("Incorrect choice");
				}
	    }
	    else if(role.equalsIgnoreCase("GymOwner"))
	    {
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			GymGMSMenu gymOwner=new GymGMSMenu();
			System.out.println("Enter your email: ");
			String email = sc.next();
			switch (choice) {
				case 1:
					gymOwner.registerGymOwner(sc, email);
					gymOwner.gymOwnerPage(sc, email);
					break;
				case 2:
					gymOwner.gymOwnerPage(sc, email);
					break;
				case 3:
					ApplicationClient.mainPage();
					break;
				default:
					System.out.println("Incorrect choice");
			}
//
//			gymOwner.testingGymOwnerMenu();
//			gymOwner.ViewAllDetails();
	    }
	    // TODO Auto-generated method stub
	    
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		mainPage();
	}

}
