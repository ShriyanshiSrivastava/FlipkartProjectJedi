package com.flipkart.client;
import com.flipkart.DAO.GymOwnerDAOImpl;
import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.business.GymOwnerLogicImpl;
import com.flipkart.business.UserLogicImpl;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.IncorrectDataException;
import com.flipkart.exceptions.UserNotFoundException;
import static com.flipkart.utils.ColorConstants.*;

import java.util.List;
import java.util.Scanner;

public class GymGMSMenu {
    public void testingGymOwnerMenu() {
        System.out.println("Gym owner menu is running fine");
    }
    GymOwner gymOwner = new GymOwner();
    GymCentre gymCenter = new GymCentre();
    GymOwnerDAO gymOwnerDAO =new GymOwnerDAOImpl();

    GymOwnerLogicImpl gymOwnerBusiness = new GymOwnerLogicImpl();

    public void registerGymOwner(Scanner sc, String email){
        gymOwner.setEmail(email);

        System.out.println(ANSI_BLUE + "Enter your name: ");
        gymOwner.setName(sc.next());



        System.out.println("Enter your address: ");
        gymOwner.setAddress(sc.next());

        System.out.println("Enter your GST number: ");
        gymOwner.setGstNumber(sc.next());

        System.out.println("Enter your password: " + ANSI_RESET);
        String password = sc.next();

        User user = new User(gymOwner.getEmail(), password, 2);
        user.setEmail(gymOwner.getEmail());
        user.setPassword(password);
        user.setRoleId(2);

        UserLogicImpl userLogicImpl = new UserLogicImpl();
        try {
            userLogicImpl.registerGymOwner(gymOwner);
        } catch (UserNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void registerGym(Scanner in) {
        GymCentre gymDetails = new GymCentre();
        System.out.println("Add gym Details:-");
        System.out.print("Add gymnasium name: ");
        gymDetails.setName(in.next());
        System.out.print("Enter the number of equipments: ");
        gymDetails.setNumItem(in.nextInt());
        System.out.print("Enter gymnasium address: ");
        gymDetails.setAddress(in.next());
        System.out.println("Enter the number of seats per slot: ");
        gymDetails.setNoOfSeats(in.nextInt());
        gymDetails.setGymOwnerEmail(gymOwner.getEmail());

        gymOwnerBusiness.addGym(gymDetails);

        System.out.flush();
    }

    public void getAllGymDetails(Scanner in) {
        List<GymCentre> allGyms=null;
        try {
            allGyms = gymOwnerBusiness.viewAllGymCenters(gymOwner.getEmail());
        } catch (GymOwnerNotFoundException exception){
            System.out.println(exception.getMessage());
        } catch (IncorrectDataException e) {
            throw new RuntimeException(e.getMessage());
        }
        for(GymCentre gym : allGyms) {
            System.out.printf("%-16s", gym.getGymId());
            System.out.printf("%-16s", gym.getAddress());
            System.out.printf("%-16s", gym.getName());

            if(gym.isApproved())
            {
                System.out.printf(ANSI_GREEN + "%-16s", "Yes" + ANSI_RESET);
            }
            else
            {
                System.out.printf(ANSI_RED + "%-16s", "No" + ANSI_RESET);
            }
            System.out.println("");
        }
    }

    public void addSlots(Scanner in, String email) throws Exception {

        getAllGymDetails(in);
        System.out.println(ANSI_BLUE + "Enter the gym id for which you want to add slots: " + ANSI_RESET);
        int gymId = in.nextInt();
        boolean check = gymOwnerDAO.checkGymApproval(gymId);
        if(check == false)
        {
            System.out.println("This gym has not been approved yet");
            gymOwnerPage(in, email);
            return;
        }
            List<Slot> slotInfo = gymOwnerBusiness.viewAllSlots();
            for(Slot slot: slotInfo) {
                System.out.println(slot.getSlotId() + " " + slot.getTime());
            }
        System.out.println(ANSI_BLUE + "Enter time: ");

            String chosenSlots = in.next();
        System.out.println("Enter date: " + ANSI_RESET);
            String time=in.next();
            gymOwnerBusiness.addSlots(gymId, time, chosenSlots);
            gymOwnerPage(in, email);
    }

    private void viewSlots(int gymCentreId) {
        List<Slot> slots = gymOwnerBusiness.viewAllSlots();
        System.out.println();
        System.out.println("--------------------------");
        System.out.printf(ANSI_BLUE + "%-16s %-16s %n", "Date", "Time" + ANSI_RESET);
        System.out.println("--------------------------");
        for (Slot slot : slots) {
            System.out.printf(ANSI_BLUE + "%-17s", slot.getDate());
            System.out.printf("%-16s", slot.getTime() + ANSI_RESET);
            System.out.println("");
        }
        System.out.println("--------------------------");
    }

    public void gymOwnerPage(Scanner sc,String gymOwnerEmail) throws Exception {
        if (!gymOwnerBusiness.isApproved(gymOwnerEmail)) {
            System.out.println(ANSI_RED + "You are not a Authorized Gym Owner" + ANSI_RESET);
            ApplicationClient.mainPage();
        } else {
            gymOwner.setEmail(gymOwnerEmail);
            while (true) {
                System.out.println(ANSI_YELLOW + "1. Add Gyms" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "2. View Gyms" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "3. Add Slots"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW + "4. View Slots"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW + "5. Exit"+ ANSI_RESET);
                System.out.print(ANSI_BLUE + "Enter your choice: "+ ANSI_RESET);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        registerGym(sc);
                        break;
                    case 2:
                        getAllGymDetails(sc);
                        break;
                    case 3:
                        addSlots(sc, gymOwnerEmail);
                        break;
                    case 4:
                        System.out.println(ANSI_BLUE + "Enter the gymId for which you want to view the slots"+ ANSI_RESET);
                        int id = sc.nextInt();
                        viewSlots(id);
                        break;
                    case 5:
                        ApplicationClient.mainPage();
                        break;
                    default:
                        System.out.println(ANSI_RED + "incorrect choice" + ANSI_RESET);
                }
            }

        }
    }
}
