package com.flipkart.client;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminLogicImpl;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.utils.ColorConstants.ANSI_BLUE;
import static com.flipkart.utils.ColorConstants.ANSI_RESET;

public class AdminGMSMenu {
    AdminLogicImpl adminBusiness = new AdminLogicImpl();

    public void approveGymCentre(Scanner in) {
        // TODO Auto-generated method stub
        System.out.println("Enter the gym Id: ");
        int gymId = in.nextInt();
        adminBusiness.approveGymRequest(gymId);

    }

    public void approveGymOwner(Scanner in) {
        // TODO Auto-generated method stub
        System.out.println("Enter the owner email: ");
        String email = in.next();
        adminBusiness.approveGymOwnerRequest(email);

    }

    public void viewPendingGymCentres() {
        // TODO Auto-generated method stub
        List<GymCentre> gymDetails = adminBusiness.viewPendingGymRequests();

        System.out.println(ANSI_BLUE + "Gym Id \t Name \tAddress \tApproved " + ANSI_RESET);
        for(GymCentre gym: gymDetails) {
            System.out.printf("%-5s\t", gym.getGymId());
            System.out.printf("%-8s\t", gym.getName());
            System.out.printf("%-8s\t", gym.getAddress());
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
        System.out.println("**********************************");
    }

    public void viewPendingGymOwners() {
        // TODO Auto-generated method stub
        List<GymOwner> gymOwnerDetails = adminBusiness.viewPendingGymOwnerRequests();

        System.out.println("Email \t\t\t Name \t\t AadhaarNumber \t GSTNumber \tApproved ");
        for(GymOwner owner: gymOwnerDetails) {
            System.out.printf("%-5s\t", owner.getEmail());
            System.out.printf("%-8s\t", owner.getName());
            System.out.printf("%-8s\t", owner.getAadhar());
            System.out.printf("%-8s\t", owner.getGstNumber());
            if(owner.isApproved())
            {
                System.out.printf("%-8s\t", "Yes");
            }
            else
            {
                System.out.printf("%-8s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void viewAllGyms() {
        // TODO Auto-generated method stub
        List<GymCentre> gymDetails = adminBusiness.viewAllGyms();

        System.out.println("Gym Id \t Name \tAddress \tApproved ");
        for(GymCentre gym: gymDetails) {
            System.out.println("Cheeku");
            System.out.printf("%-5s\t", gym.getGymId());
            System.out.printf("%-8s\t", gym.getName());
            System.out.printf("%-8s\t", gym.getAddress());
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
        System.out.println("**********************************");
    }

    public void viewAllGymOwners() {

        List<GymOwner> gymOwnerDetails = adminBusiness.viewAllGymOwners();
        System.out.println();
        System.out.println("**********************************");
        System.out.println("Email \t\t\t Name \t\t Address \t GSTNumber \tApproved ");
        for(GymOwner owner: gymOwnerDetails) {

            System.out.printf("%-8s\t", owner.getEmail());
            System.out.printf("%-8s\t", owner.getName());
            System.out.printf("%-8s\t", owner.getAddress());
            System.out.printf("%-8s\t", owner.getGstNumber());
            if(owner.isApproved())
            {
                System.out.printf("%-8s\t", "Yes");
            }
            else
            {
                System.out.printf("%-8s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("**********************************");
        System.out.println();
    }

    public void AdminPage(Scanner in) throws Exception {
        while(true) {
            System.out.println("1. View All Gym Owners");
            System.out.println("2. View All Pending Gym Owners");
            System.out.println("3. View All Gym Centres");
            System.out.println("4. View All Pending Gym Centres");
            System.out.println("5. Approve Gym Owner");
            System.out.println("6. Approve Gym Centre");
            System.out.println("7. Exit");
            System.out.print("Enter number: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    viewAllGymOwners();
                    break;
                case 2:
                    viewPendingGymOwners();
                    break;
                case 3:
                    viewAllGyms();
                    break;
                case 4:
                    viewPendingGymCentres();
                    break;
                case 5:
                    approveGymOwner(in);
                    break;
                case 6:
                    approveGymCentre(in);
                    break;
                case 7:
                    ApplicationClient.mainPage();
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }

    }
}
