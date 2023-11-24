package com.flipkart.client;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.business.GymOwnerLogic;
import com.flipkart.business.UserLogic;

import java.util.List;
import java.util.Scanner;

public class GymGMSMenu {
    public void testingGymOwnerMenu() {
        System.out.println("Gym owner menu is running fine");
    }
    GymOwner gymOwner = new GymOwner();
    GymCentre gymCenter = new GymCentre();

    GymOwnerLogic gymOwnerBusiness = new GymOwnerLogic();

    public void registerGymOwner(Scanner sc){

        System.out.println("Enter your email: ");
        gymOwner.setEmail(sc.next());

        System.out.println("Enter your name: ");
        gymOwner.setName(sc.next());



        System.out.println("Enter your address: ");
        gymOwner.setAddress(sc.next());

        System.out.println("Enter your GST number: ");
        gymOwner.setGstNumber(sc.next());

        System.out.println("Enter your password: ");
        String password = sc.next();

        User user = new User();
        user.setEmail(gymOwner.getEmail());
        user.setPassword(password);
        user.setRoleId(2);

        UserLogic userLogic = new UserLogic();
        userLogic.registerGymOwner(gymOwner);
    }

    public void registerGym(Scanner sc) {
        GymCentre gymCenter = new GymCentre();
        System.out.println("Add gym Details: ");
        System.out.print("Add GymCenter id: ");

        gymCenter.setGymId(sc.nextInt());
        System.out.print("Enter gym location: ");
        gymCenter.setLocationId(sc.next());
        System.out.println("Enter the number of seats: ");
        gymCenter.setNoOfSeats(sc.nextInt());
       // gymCenter.setGymOwnerEmail(gymOwner.getEmail());

        gymOwnerBusiness.addGym(gymCenter);
    }

    public void getAllGymDetails() {
        List<GymCentre> allGyms = gymOwnerBusiness.viewAllGymCenters(gymOwner.getEmail());
        for(GymCentre gym : allGyms) {
            System.out.printf("%-8s\t", gym.getGymId());
            System.out.printf("%-8s\t", gym.getLocationId());
            System.out.printf("%-8s\t", gym.getNoOfSeat());

            if(gym.isApproved())
            {
                System.out.printf("%-8s\t", "Yes");
            }
            else
            {
                System.out.printf("%-8s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------");
    }

    public void addSlots(Scanner sc, String gymOwnerEmail) throws Exception {
        getAllGymDetails();
        System.out.println("Enter the gymCenter id for which you want to add slots: ");
        gymCenter.setGymId(sc.nextInt());
        if(!gymCenter.isApproved()){
            System.out.println("This Gym is not Authorized");
            gymOwnerPage(sc, gymOwnerEmail);
        }
        else {
            System.out.println("Add slot timing: ");
            Slot slot = new Slot();
            slot.setTime(sc.next());
            String date = sc.next();
            gymOwnerBusiness.addSlots(gymCenter.getGymId(),date,slot);
            gymOwnerPage(sc, gymOwnerEmail);
        }
    }

    public void gymOwnerPage(Scanner sc,String gymOwnerEmail) throws Exception {
        if(!gymOwnerBusiness.isApproved(gymOwnerEmail)) {
            System.out.println("You are not a Authorized Gym Owner");
            ApplicationClient.mainPage();
        }
        else {
            gymOwner.setEmail(gymOwnerEmail);
            while(true) {
                System.out.println("1. Add Gyms");
                System.out.println("2. View Gyms");
                System.out.println("3. Add Slots");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        registerGym(sc);
                        break;
                    case 2:
                        getAllGymDetails();
                        break;
                    case 3:
                        addSlots(sc, gymOwnerEmail);
                    case 4:
                        ApplicationClient.mainPage();
                        break;
                    default:
                        System.out.println("incorrect choice");
                }
            }

        }
    }
}
