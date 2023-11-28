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

        System.out.println("Enter your name: ");
        gymOwner.setName(sc.next());



        System.out.println("Enter your address: ");
        gymOwner.setAddress(sc.next());

        System.out.println("Enter your GST number: ");
        gymOwner.setGstNumber(sc.next());

        System.out.println("Enter your password: ");
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
        //gymOwnerBusiness.addGym(gymCenter);
        GymCentre gymDetails = new GymCentre();
        System.out.println("Add gym Details:-");
        System.out.print("Add gymnasium name: ");
        gymDetails.setName(in.next());
        System.out.print("Enter the number of equipments: ");
        gymDetails.setNumItem(in.nextInt());
        System.out.print("Enter gymnasium address: ");
        gymDetails.setAddress(in.next());
//        System.out.print("Add gymnasium area in square foot: ");
//        gymDetails.s(in.nextDouble());
        System.out.println("Enter the number of seats per slot: ");
        gymDetails.setNoOfSeats(in.nextInt());
//		System.out.println(gymOwner.getOwnerId());
        gymDetails.setGymOwnerEmail(gymOwner.getEmail());
//		System.out.println(gymDetails);

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
            System.out.printf("%-8s\t", gym.getGymId());
            System.out.printf("%-8s\t", gym.getAddress());
            //System.out.printf("%-8s\t", gym.getNoOfSeat());
            System.out.printf("%-8s\t", gym.getName());

            if(gym.isApproved())
            {
                System.out.printf("%-8s\t",ANSI_GREEN + "Yes" + ANSI_RESET);
            }
            else
            {
                System.out.printf("%-8s\t",ANSI_RED + "No" + ANSI_RESET);
            }
            System.out.println("");
        }
        System.out.println(ANSI_YELLOW + "-------------------------------------" + ANSI_RESET);
    }

    public void addSlots(Scanner in, String email) throws Exception {

        getAllGymDetails(in);
        System.out.println("Enter the gym id for which you want to add slots: ");
        int gymId = in.nextInt();
        boolean check = gymOwnerDAO.checkGymApproval(gymId);
        if(check == false)
        {
            System.out.println("This gym has not been approved yet");
            gymOwnerPage(in, email);
            return;
        }
            System.out.println("Select which slots you want to add in space separated numbers: \n");
            List<Slot> slotInfo = gymOwnerBusiness.viewAllSlots();
            for(Slot slot: slotInfo) {
                System.out.println(slot.getSlotId() + " " + slot.getTime());
            }
            String chosenSlots = in.next();
            gymOwnerBusiness.addSlots(gymId,chosenSlots);
            gymOwnerPage(in, email);


//        getAllGymDetails(in);
//        System.out.println("Enter the gymCenter id for which you want to add slots: ");
//        gymCenter.setGymId(in.nextInt());
//        if(!gymOwnerBusiness.isApproved(email)){
//            System.out.println("This Gym is not Authorized");
////			System.out.println("This Gym is not Authorized");
//            gymOwnerPage(in, email);
//        }
//        else {
//            viewAllSlots();
//            System.out.println("Add slot timing: ");
//
//            Slot slot = new Slot();
//            slot.setTime(in.next());
//            System.out.println("Add slot Id: ");
//            slot.setSlotId(in.nextInt());
//            gymOwnerBusiness.addSlots(gymCenter.getGymId(), slot.getTime());
//            gymOwnerBusiness.addSlots(gymCenter.getGymId(), slot.getTime());
//            gymOwnerPage(in, email);
//        }
    }

    private void viewSlots(int gymCentreId) {
        List<Slot> slots = gymOwnerBusiness.viewAllSlots();
        System.out.println();
        System.out.println("**********************************");
        System.out.println("Time ");
        for (Slot slot : slots) {

            System.out.printf("%-8s\t", slot.getTime());
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void gymOwnerPage(Scanner sc,String gymOwnerEmail) throws Exception {
        if (!gymOwnerBusiness.isApproved(gymOwnerEmail)) {
            System.out.println("You are not a Authorized Gym Owner");
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
