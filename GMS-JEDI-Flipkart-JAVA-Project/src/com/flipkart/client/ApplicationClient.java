package com.flipkart.client;

import java.util.Scanner;
import com.flipkart.business.AdminLogic;
import com.flipkart.business.CustomerLogic;
import com.flipkart.business.GymOwnerLogic;

public class ApplicationClient {

	public static void mainPage() throws Exception {
	    System.out.println("Welcome to FlipFit Application");



	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the role");
	    String role = sc.next();
	    if(role.equals("Admin"))
	    {

	          System.out.println("Welcome to Admin Menu");
	          AdminGMSMenu admin=new AdminGMSMenu();
			  admin.AdminPage(sc);

	    }
	    else if(role.equals("Customer"))
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
						customer.customerRegistration(sc);
						break;
					case 2:
						customer.testingFunction();
						break;
					case 3:
						ApplicationClient.mainPage();
						break;
					default:
						System.out.println("Incorrect choice");
				}
			//}
//			customer.testingFunction();
//			customer.CustomerRegistration();
	    }
	    else if(role.equals("GymOwner"))
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
