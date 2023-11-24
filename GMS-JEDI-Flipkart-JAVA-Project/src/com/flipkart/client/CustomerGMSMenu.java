package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerLogic;
import com.flipkart.business.UserLogic;


public class CustomerGMSMenu {
    private CustomerLogic customerLogic = new CustomerLogic();

    public void testingFunction() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your UserName:");
        String userName = scan.next();
        System.out.println("Enter your Password:");
        String password = scan.next();
        customerLogic.login(userName,password);
        customerPage(scan, customer.getEmail());
    }
    CustomerLogic customerBusiness = new CustomerLogic();
    Customer customer = new Customer();


    public void customerRegistration(Scanner sc) throws Exception {
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
        System.out.println("You are successfully registered");
        Scanner scan = new Scanner(System.in);
        customerPage(scan, customer.getEmail());
    }

    public void bookSlot(Scanner sc,String customerEmail) {

    }

    public void cancelBookedSlot(String customerEmail) {

    }

    public void viewAllBookedSlots(String customerEmail) {

    }

    public void customerPage(Scanner sc, String customerEmail) throws Exception {

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