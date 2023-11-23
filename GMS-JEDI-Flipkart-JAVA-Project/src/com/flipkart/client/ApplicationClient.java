package com.flipkart.client;

import java.util.Scanner;
import com.flipkart.business.AdminLogic;
import com.flipkart.business.CustomerLogic;
import com.flipkart.business.GymOwnerLogic;

public class ApplicationClient {
	
	
	
	public static void mainPage() {
	    System.out.println("Welcome to FlipFit Application");



	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the role");
	    String role = sc.next();
	    if(role.equals("Admin"))
	    {

	          System.out.println("Welcome to Admin Menu");
	          AdminGMSMenu admin=new AdminGMSMenu();
	          admin.viewAllGymOwners();
	    }
	    else if(role.equals("Customer"))
	    {
	       System.out.println("Welcome to Customer Menu");
			CustomerGMSMenu customer=new CustomerGMSMenu();
			customer.testingFunction();
//			customer.CustomerRegistration();
	    }
	    else if(role.equals("GymOwner"))
	    {
	           System.out.println("Welcome GymOwner");
			GymGMSMenu gymOwner=new GymGMSMenu();
			gymOwner.testingGymOwnerMenu();
//			gymOwner.ViewAllDetails();
	    }
	    // TODO Auto-generated method stub
	    
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		mainPage();
	}

}
