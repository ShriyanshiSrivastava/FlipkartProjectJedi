package com.flipkart.client;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminLogicImpl;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.utils.ColorConstants.*;

public class AdminGMSMenu {
    AdminLogicImpl adminBusiness = new AdminLogicImpl();

    public void approveGymCentre(Scanner in) {
        // TODO Auto-generated method stub
        System.out.println(ANSI_BLUE + "Enter the gym Id: " + ANSI_RESET);
        int gymId = in.nextInt();
        adminBusiness.approveGymRequest(gymId);

    }

    public void approveGymOwner(Scanner in) {
        // TODO Auto-generated method stub
        System.out.println(ANSI_BLUE + "Enter the owner email: " + ANSI_RESET);
        String email = in.next();
        adminBusiness.approveGymOwnerRequest(email);

    }

    public void viewPendingGymCentres() {
        // TODO Auto-generated method stub
        List<GymCentre> gymDetails = adminBusiness.viewPendingGymRequests();
        System.out.println("--------------------------------------------------------");
        System.out.printf(ANSI_BLUE + "%-16s %-13s %-16s %-16s %n", "Gym Id","Name", "Address", "Approved" + ANSI_RESET);
        System.out.println("--------------------------------------------------------");
        for(GymCentre gym: gymDetails) {
            System.out.printf("%-16s", gym.getGymId());
            System.out.printf("%-16s", gym.getName());
            System.out.printf("%-16s", gym.getAddress());
            if(gym.isApproved())
            {
                System.out.printf("%-16s", "Yes");
            }
            else
            {
                System.out.printf("%-16s", "No");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------");
    }

    public void viewPendingGymOwners() {
        // TODO Auto-generated method stub
        List<GymOwner> gymOwnerDetails = adminBusiness.viewPendingGymOwnerRequests();

        System.out.printf(ANSI_BLUE + "%-19s %-13s %-24s %-17s %-15s %n", "Email", "Name", "Aadhaar Number", "GST Number", "Approved" + ANSI_RESET);
        for(GymOwner owner: gymOwnerDetails) {
            System.out.printf(ANSI_YELLOW + "%-16s\t", owner.getEmail());
            System.out.printf("%-16s\t", owner.getName());
            System.out.printf("%-16s\t", owner.getAadhar());
            System.out.printf("%-16s\t", owner.getGstNumber() + ANSI_RESET);
            if(owner.isApproved())
            {
                System.out.printf("%-16s\t", "Yes");
            }
            else
            {
                System.out.printf("%-16s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void viewAllGyms() {
        // TODO Auto-generated method stub
        List<GymCentre> gymDetails = adminBusiness.viewAllGyms();

        System.out.printf(ANSI_BLUE + "%-16s %-13s %-11s %16s %n", "Gym Id", "Name", "Address", "Approved" + ANSI_RESET);
        for(GymCentre gym: gymDetails) {
            System.out.printf(ANSI_YELLOW + "%-16s", gym.getGymId());
            System.out.printf("%-16s", gym.getName());
            System.out.printf("%-20s", gym.getAddress() + ANSI_RESET);
            if(gym.isApproved())
            {
                System.out.printf(ANSI_GREEN + "%-20s", "Yes" + ANSI_RESET);
            }
            else
            {
                System.out.printf(ANSI_RED + "%-20s", "No" + ANSI_RESET);
            }
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void viewAllGymOwners() {

        List<GymOwner> gymOwnerDetails = adminBusiness.viewAllGymOwners();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf(ANSI_BLUE + "%-15s %-13s %-16s %-12s %12s %n", "Email", "Name", "Address", "GST Number", "Approved" + ANSI_RESET);
        System.out.println("------------------------------------------------------------------");
        for(GymOwner owner: gymOwnerDetails) {

            System.out.printf(ANSI_YELLOW + "%-16s", owner.getEmail());
            System.out.printf("%-16s", owner.getName());
            System.out.printf("%-16s", owner.getAddress());
            System.out.printf("%-18s", owner.getGstNumber() + ANSI_RESET);
            if(owner.isApproved())
            {
                System.out.printf("%-18s", "Yes");
            }
            else
            {
                System.out.printf("%-18s", "No");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }

    public void AdminPage(Scanner in) throws Exception {
        while(true) {
            System.out.println(ANSI_YELLOW + "1. View All Gym Owners");
            System.out.println("2. View All Pending Gym Owners");
            System.out.println("3. View All Gym Centres");
            System.out.println("4. View All Pending Gym Centres");
            System.out.println("5. Approve Gym Owner");
            System.out.println("6. Approve Gym Centre");
            System.out.println("7. Exit" + ANSI_RESET);
            System.out.print(ANSI_BLUE + "Enter number: " + ANSI_RESET);
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
