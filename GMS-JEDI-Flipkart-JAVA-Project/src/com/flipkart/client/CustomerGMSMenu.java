package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerLogic;
import com.flipkart.business.UserLogic;


public class CustomerGMSMenu {

    public void testingFunction(){
        System.out.println(" Customer Logic is showing fine");
    }
    CustomerLogic customerBusiness = new CustomerLogic();
    Customer customer = new Customer();


    public void customerRegistration(Scanner sc) {
        System.out.println("Enter your name: ");
        customer.setName(sc.next());

        System.out.println("Enter your email: ");
        customer.setEmail(sc.next());
        System.out.println("Enter your address: ");
        customer.setAddress(sc.next());
        System.out.println("Enter your password: ");
        String password = sc.next();
        User user = new User();
        user.setPassword(password);
        user.setEmail(customer.getEmail());
        user.setRoleId(3);
        UserLogic userBusiness = new UserLogic();
//		UserBusiness.registerUser(user);
//		UserBusiness.registerCustomer(customer);
    }

    public void bookSlot(Scanner sc,String customerEmail) {

    }

    public void cancelBookedSlot(String customerEmail) {

    }

    public void viewAllBookedSlots(String customerEmail) {

    }

    public void customerPage(Scanner sc, String customerEmail) {

        while(true) {
            System.out.println("1. Book slot");
            System.out.println("2. Cancel Booked slot");
            System.out.println("3. View all booked Slots");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookSlot(sc,customerEmail);
                    break;
                case 2:
                    cancelBookedSlot(customerEmail);
                    break;
                case 3:
                    viewAllBookedSlots(customerEmail);
                case 4:
                    ApplicationClient.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }


    }





}