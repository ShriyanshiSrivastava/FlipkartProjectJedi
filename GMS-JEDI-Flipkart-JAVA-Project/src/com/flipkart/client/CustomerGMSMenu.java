package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerLogicImpl;
import com.flipkart.business.UserLogicImpl;
import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.SlotNotFoundException;


public class CustomerGMSMenu {
    Customer customer = new Customer();
    CustomerLogicImpl customerGMSService = new CustomerLogicImpl();

    public void CustomerRegistration(Scanner in) throws Exception {
        System.out.println("Enter your name: ");
        String name = in.next();
        customer.setName(name);
        //System.out.println("Enter your mobile: ");
//        customer.setMobile(in.next());
        System.out.println("Enter your email: ");
        String email = in.next();
        customer.setEmail(email);
        System.out.println("Enter your address: ");
        String address = in.next();
        customer.setAddress(address);
        System.out.println(address);
//        System.out.println("Enter your dob: ");
//        customer.setDob(in.next());
        System.out.println("Enter your password: ");
        String password = in.next();
        customer.setPassword(password);
        System.out.println(password);

        User user = new User(customer.getEmail(),password,1);
        UserLogicImpl userService = new UserLogicImpl();
        userService.registerUser(user);
        userService.registerCustomer(customer);
//     CustomerActionPage(in, customer.getEmail());
        CustomerActionPage(in,email);
    }

    public void viewCatalog(Scanner in, String email) throws Exception {
        System.out.println("Welcome to FlipFit Gym Application");
        System.out.println("Menu:-");
        fetchGymList();

        System.out.print("Choose Gym ID: ");
        int gymId = in.nextInt();
        boolean check = customerGMSService.checkGymApprove(gymId);

        if(!check)
        {
            System.out.println("This gym has not been approved yet!");
            CustomerActionPage(in,email);
            return;
        }
        boolean slotsAvailable = customerGMSService.fetchAvilableSlots(gymId);
        if(slotsAvailable) {
            System.out.print("Enter Slot ID for which you want to make booking: ");
            String slotId = in.next();

            boolean flag =customerGMSService.checkSlotExists(slotId, gymId);
            if(!flag)
            {
                System.out.println("No slots found for this gym");
                CustomerActionPage(in, email);
                return;
            }

            System.out.print("Enter your Date: ");
            String date = in.next();
            int response=0;
            try{
               response = customerGMSService.bookSlots(gymId, slotId, email, date);
            } catch (SlotNotFoundException exception){
                System.out.println(exception.getMessage());
            }
            switch (response) {
                case 0:
                    System.out.println("This time is already booked\nCancelling that slot and booking new");

                    break;
                case 1:
                    System.out.println("There are no more slots left");
                    break;
                case 2:
                    System.out.println("Congratulations your slot is booked");
                    break;
                // Default case statement
                default:
                    System.out.println("Incorrect choice!!! Please try again!!!");
            }
        }
        else {
            viewCatalog(in,email);
        }

    }

    public void fetchGymList() {
        List<GymCentre> gymDetails = null;
        try {
            gymDetails = customerGMSService.fetchGymList();
        } catch (GymCentreNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println();
        System.out.println("**********************************");
        System.out.println("Gym Id \t  GymOwner \t       GymName");
        if(gymDetails==null) throw new NullPointerException();
        for(GymCentre gym: gymDetails) {
            System.out.printf("%-5s\t", gym.getGymId() );
            System.out.printf("%-5s\t",gym.getGymOwnerEmail());
            System.out.printf("%-5s\t", gym.getName() );
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    private void cancelBookedSlots(Scanner in, String email) {
        customerGMSService.fetchBookedSlots(email);
        System.out.print("Enter Booking ID that you want to cancel: ");
        int bookingId =in.nextInt();
        customerGMSService.cancelBookedSlots(bookingId);

    }

    public void CustomerActionPage(Scanner in, String email) throws Exception {
        int choice = 0;

        while(choice != 4) {
//        System.out.println("Welcome to FlipFit Gym Application");

            System.out.println("Menu:-");
            System.out.println("1.View Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4.Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    viewCatalog(in, email);
                    break;
                case 2:
                    customerGMSService.fetchBookedSlots(email);
                    break;
                case 3:
                    cancelBookedSlots(in, email);
                    break;
                case 4:
                    ApplicationClient.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice!!! Please try again!!!");
            }
        }

    }
}