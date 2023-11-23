package com.flipkart.client;

import java.util.Scanner;
import com.flipkart.business.AdminLogic;
import com.flipkart.business.CustomerLogic;
import com.flipkart.business.GymOwnerLogic;

public class ApplicationClient {
	
	
	
	public static void main(String[] args) {
	    System.out.println("Welcome to FlipFit Application");
	    System.out.println("Choices:");
	    System.out.println("1. Login");
	    System.out.println("2. Registration of Customer");
	    System.out.println("3. Update Password");
	    System.out.println("4. Exit");

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the username");
	    String userName = sc.next();
	    System.out.println("Enter the password");
	    String password = sc.next();
	    System.out.println("Enter the role");
	    String role = sc.next();
	    if(role.equals("Admin"))
	    {
	    	
	          System.out.println("Welcome to Admin Menu");
	          AdminLogic admin=new AdminLogic();
	          admin.viewAllGyms();
	    }
	    else if(role.equals("Customer"))
	    {
	       System.out.println("Welcome to Customer Menu");
	       CustomerLogic customer=new CustomerLogic();
	       customer.cancelSlot(0);
	    }
	    else
	    {
	           System.out.println("Welcome GymOwner");
	           GymOwnerLogic gymOwner = new GymOwnerLogic();
	           gymOwner.updateSlot();
	    }
	    // TODO Auto-generated method stub
	    
	}

}
