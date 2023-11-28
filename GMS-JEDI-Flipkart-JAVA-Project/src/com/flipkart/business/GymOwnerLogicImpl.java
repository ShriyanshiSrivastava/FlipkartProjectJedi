package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAOImpl;
import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.exceptions.GymOwnerNotFoundException;
import com.flipkart.exceptions.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

import static com.flipkart.utils.ColorConstants.ANSI_BLUE;
import static com.flipkart.utils.ColorConstants.ANSI_RESET;

/**
 * This class implements the GymOwnerLogicInterface and provides the functionality for GYmOwner operations in the Gym Management System.
 */
public class GymOwnerLogicImpl implements GymOwnerLogic {
	GymOwnerDAO gymOwnerDAO = new GymOwnerDAOImpl();

	/**
	 This method fetches the details of a gym owner based on the gym owner ID.
	 @param gymOwnerId The ID of the gym owner
	 @return The GymOwner object representing the gym owner details
	 */

	public GymOwner getGymOwnerDetails(String gymOwnerId) {
		return gymOwnerDAO.getGymOwnerDetails(gymOwnerId);
	}

	/**
	 This method fetches all the possible slots that a gym owner can select from.
	 @return The list of Slots objects representing the possible slots
	 */
	public List<Slot> viewAllSlots(){
		System.out.println(ANSI_BLUE + "Listing all Slots in GymCenter" + ANSI_RESET);
		return gymOwnerDAO.viewAllSlots();
	}

	/**
	 This method checks if a gym is already booked based on the gym ID.
	 @param gymId The ID of the gym
	 @return true if the gym is already booked, false otherwise
	 */
	public boolean checkIfAlreadyBooked(int gymId) {
		return gymOwnerDAO.checkIfAlreadyBooked(gymId);
	}
	public void addGym(GymCentre gymCenter) {
		gymOwnerDAO.addGym(gymCenter);
	}
	public boolean isApproved(String gymOwnerEmail) {
		return gymOwnerDAO.isApproved(gymOwnerEmail);
	}

	/**
	 This method allows a gym owner to add a particular slot for their gym.
	 @param gymCenterId The ID of the gym
	 @param date The date for the gym
	 */
	public void addSlots(int gymCenterId, String date, String time) {
		gymOwnerDAO.addSlots(gymCenterId, date, time);
		return;
	}
/**
 	This method fetches the gym details that belong to a gym owner.
	@param gymOwnerEmail The email of the gym owner
	@return The list of GymCentre objects representing the gym details
	@throws GymOwnerNotFoundException if the gym owner ID is not found
	@throws IncorrectDataException if no gym data is found
 */
	public List<GymCentre> viewAllGymCenters(String gymOwnerEmail) throws GymOwnerNotFoundException, IncorrectDataException {
		System.out.println(ANSI_BLUE + "Listing all Gym Centres" + ANSI_RESET);
		List<GymCentre> gymList = new ArrayList<GymCentre>();
		if (gymOwnerEmail == null) {
			throw new GymOwnerNotFoundException();
		}
		try {
			gymList = gymOwnerDAO.viewAllGymCenters(gymOwnerEmail);
		} catch (Exception ex) {
			throw new IncorrectDataException();
		}
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.printf(ANSI_BLUE + "%-14s %-16s %-14s %-12s", "CenterId","Location", "Name", "Approved" + ANSI_RESET);

		System.out.println();
		System.out.println("------------------------------------------------------------");
		return gymList;
	}
	public void createSlot(Slot slot){
		gymOwnerDAO.createSlot(slot);
	}

	/**
	 This method checks if a gym is approved based on the gym ID.
	 @param gymId The ID of the gym
	 @return true if the gym is approved, false otherwise
	 */
	public boolean checkGymApproval(int gymId) {
		return gymOwnerDAO.checkGymApproval(gymId);
	}
}
