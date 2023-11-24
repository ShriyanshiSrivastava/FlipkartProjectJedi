package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerLogic;
import com.flipkart.business.UserLogic;


public class CustomerGMSMenu {
    private CustomerLogic customerLogic = new CustomerLogic();
    int customerId;

    public void testingFunction(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your UserName:");
        String userName = scan.next();
        System.out.println("Enter your Password:");
        String password = scan.next();

        customerId =  customerLogic.login(userName,password);

        if(customerId!=-1)
        {
            customerPage(scan);
        }



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
        // UserBusiness.registerUser(user);
        //UserBusiness.registerCustomer(customer);
    }

    public void bookSlot(Scanner sc,int customerId) {
        customerLogic.bookSlot(sc,customerId);

    }

    public void cancelBookedSlot(Scanner sc) {
        System.out.println("Enter Slot Id");
        int slotId = sc.nextInt();
        System.out.println("Enter Date");
        String date = sc.next();
        customerLogic.cancelSlot(slotId,customerId,date);
        customerPage(sc);

    }

    public void viewAllBookedSlots(Scanner sc ,int customerId) {
        customerLogic.viewAllBookings(customerId);
        customerPage(sc);
    }

    public void customerPage(Scanner sc) {

        while(true) {
            System.out.println("1. Book slot");
            System.out.println("2. Cancel Booked slot");
            System.out.println("3. View all booked Slots");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookSlot(sc,customerId);
                    break;
                case 2:
                    cancelBookedSlot( sc);
                    break;
                case 3:
                    viewAllBookedSlots(sc,customerId);
                case 4:
                    ApplicationClient.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }


    }
}