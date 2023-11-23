package com.flipkart.client;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminLogic;

import java.util.List;
import java.util.Scanner;

public class AdminGMSMenu {
    AdminLogic adminBusiness = new AdminLogic();
    Scanner sc = new Scanner(System.in);

    public void approveGymOwnerRequest() {
        System.out.println("Enter the gymOwner Id");
        int gymOwnerId = sc.nextInt();
        adminBusiness.approveGymOwnerRegistration(gymOwnerId);
    }

    public void approveGymRequest() {
        System.out.println("Enter the gym Id");
        int gymId = sc.nextInt();
        adminBusiness.approveGymRegistration(gymId);
    }

    public void viewPendingGymRequests() {
        List<GymCentre> gyms = adminBusiness.viewPendingGymRequests();
        for (GymCentre gymCenter : gyms) {
            System.out.println(gymCenter.getGymId());
            System.out.println(gymCenter.getLocationId());

            if (gymCenter.isApproved()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public void viewPendingGymOwnerRequests() {
        List<GymOwner> owners = adminBusiness.viewPendingGymOwnerRequests();
        for (GymOwner gymOwner : owners) {
            System.out.println(gymOwner.getId());
            System.out.println(gymOwner.getAddress());
            System.out.println(gymOwner.getEmail());
            System.out.println(gymOwner.getGstNumber());
            System.out.println(gymOwner.getName());

            if (gymOwner.isApproved()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public void viewGymCenters() {
        List<GymCentre> gyms = adminBusiness.viewAllGyms();
        for (GymCentre gymCenter : gyms) {
            System.out.println(gymCenter.getGymId());
            System.out.println(gymCenter.getLocationId());
            //System.out.println(gymCenter.getSlotId());
            if (gymCenter.isApproved()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public void viewAllGymOwners() {
        System.out.println("View All Gym Owners");
        List<GymOwner> owners = AdminLogic.viewAllGymOwners();
        for (GymOwner gymOwner : owners) {
            System.out.println(gymOwner.getId());
            System.out.println(gymOwner.getAddress());
            System.out.println(gymOwner.getEmail());
            System.out.println(gymOwner.getGstNumber());
            System.out.println(gymOwner.getName());

            if (gymOwner.isApproved()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public void AdminPage(Scanner in) throws Exception {
        while (true) {
            System.out.println("1. View All Gym Owners");
            System.out.println("2. View All Gyms");
            System.out.println("3. View Pending Gym Owner Requests");
            System.out.println("4. View Pending Gym Requests");
            System.out.println("5. Approve Gym Request");
            System.out.println("6. Approve Gym Owner Request");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                // Case statements
                case 1:
                    viewAllGymOwners();
                    break;
                case 2:
                    viewGymCenters();
                    break;
                case 3:
                    viewPendingGymOwnerRequests();
                    break;
                case 4:
                    viewPendingGymRequests();
                    break;
                case 5:
                    approveGymRequest();
                    break;
                case 6:
                    approveGymOwnerRequest();
                    break;
                case 7:
                    ApplicationClient.mainPage();
                    break;

                default:
                    System.out.println("Wrong choice");
            }
        }


    }
}
