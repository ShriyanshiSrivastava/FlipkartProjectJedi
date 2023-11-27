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

public class GymOwnerLogicImpl implements GymOwnerLogic {

	List<Slot> allSlots;
	List<GymCentre> allGyms;

	GymOwnerDAO gymOwnerDAO = new GymOwnerDAOImpl();

	public GymOwner getGymOwnerDetails(String gymOwnerId) {
		return gymOwnerDAO.getGymOwnerDetails(gymOwnerId);
	}

	public List<Slot> viewAllSlots(){
		System.out.println("Listing all Slots in GymCenter");
		//return allSlots;
		return gymOwnerDAO.viewAllSlots();
	}

	public boolean checkIfAlreadyBooked(int gymId) {
		return gymOwnerDAO.checkIfAlreadyBooked(gymId);
	}
	public void addGym(GymCentre gymCenter) {
		gymOwnerDAO.addGym(gymCenter);
	}
	public boolean isApproved(String gymOwnerEmail) {
		return gymOwnerDAO.isApproved(gymOwnerEmail);
	}
	public void addSlots(int gymCenterId,String date) {
		gymOwnerDAO.addSlots(gymCenterId, date);
		return;
	}
	public List<GymCentre> viewAllGymCenters(String gymOwnerEmail) throws GymOwnerNotFoundException, IncorrectDataException {
		System.out.println("Listing all Gym Centres");
		List<GymCentre> gymList = new ArrayList<GymCentre>();
		if (gymOwnerEmail == null) {
			throw new GymOwnerNotFoundException();
		}
		try {
			gymList = gymOwnerDAO.viewAllGymCenters(gymOwnerEmail);
		} catch (Exception ex) {
			throw new IncorrectDataException();
		}
//		gymList = gymOwnerDAO.viewAllGymCenters(gymOwnerEmail);
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.printf("%5s %10s %8s %10s", "CenterId","Location", "Name", "Approved");
		System.out.println();
		return gymList;
//		return allGyms;
	}
	public void createSlot(Slot slot){
		gymOwnerDAO.createSlot(slot);
	}

	public boolean checkGymApproval(int gymId) {
		return gymOwnerDAO.checkGymApproval(gymId);
	}
}
