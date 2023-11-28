package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.flipkart.bean.User;
import com.flipkart.business.UserLogicImpl;
import com.flipkart.utils.ColorConstants.*;

import static com.flipkart.utils.ColorConstants.*;

public class ApplicationClient {
//	public static final String ANSI_RESET = "\u001B[0m";
//	//public static final String ANSI_YELLOW = "\033[1;33m";
//	public static final String ANSI_YELLOW_BG = "\033[43m";
//	public static final String ANSI_CYAN = "\u001B[36m";
//	public static final String ANSI_PURPLE = "\u001B[35m";

	public static void login() throws Exception
	{
		Scanner in = new Scanner(System.in);
		System.out.println(ANSI_BLUE + "Enter your username: " + ANSI_RESET);
		String username = in.next();
		System.out.println(ANSI_BLUE + "Enter your correct password: " + ANSI_RESET);
		String password = in.next();

		User user = new User(username,password,0);
		UserLogicImpl authentication = new UserLogicImpl();
		LocalDateTime localDateTime = LocalDateTime.now();
		if(authentication.authenticateUser(user) != null) {
			System.out.println(ANSI_BLUE + "Welcome " + username + "! You are logged in." + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "Current Date and Time: "+ localDateTime + ANSI_RESET);
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

	    System.out.println(ANSI_BLUE + "Welcome to FlipFit Application" + ANSI_RESET);



	    Scanner sc = new Scanner(System.in);
	    System.out.println(ANSI_YELLOW + "Enter the role" + ANSI_RESET);
	    String role = sc.next();
	    if(role.equalsIgnoreCase("Admin"))
	    {

	          System.out.println(ANSI_BLUE + "Welcome to Admin Menu" + ANSI_RESET);
	          AdminGMSMenu admin=new AdminGMSMenu();
			  admin.AdminPage(sc);

	    }
	    else if(role.equalsIgnoreCase("Customer"))
	    {
	       System.out.println(ANSI_BLUE + "Welcome to Customer Menu" + ANSI_RESET);
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
						System.out.println(ANSI_RED + "Incorrect choice" + ANSI_RESET);
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
					System.out.println(ANSI_RED + "Incorrect choice" + ANSI_RESET);
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
