package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerLogic {

	List<Slot> allSlots;
	List<GymCentre> allGyms;

	public GymOwner getGymOwnerDetails(String gymOwnerId) {
		return GymOwnerDAO.getGymOwnerDetails(gymOwnerId);
	}

	public List<Slot> viewAllSlots(){
		System.out.println("Listing all Slots in GymCenter");
		//return allSlots;
		return GymOwnerDAO.viewAllSlots();
	}

	public boolean checkIfAlreadyBooked(int gymId) {
		return GymOwnerDAO.checkIfAlreadyBooked(gymId);
	}
	public void addGym(GymCentre gymCenter) {
//		System.out.println("Add gym Details: ");
//		System.out.print("Add GymCenter id: ");
//
//		gymCenter.setGymId(sc.nextInt());
//		System.out.print("Enter gym location: ");
//		gymCenter.setLocationId(sc.next());
//		System.out.println("Enter the number of seats: ");
//		gymCenter.setNoOfSeats(sc.nextInt());
//		System.out.println("Gym added successfully");
//		allGyms.add(gymCenter);
		GymOwnerDAO.addGym(gymCenter);
	}
	public boolean isApproved(String gymOwnerEmail) {
		//System.out.println("Owner approved Successfully");
		return GymOwnerDAO.isApproved(gymOwnerEmail);
	}
	public void addSlots(int gymCenterId,String date) {
		//allSlots.add(slot);
		//System.out.println("Slot added successfully");
		GymOwnerDAO.addSlots(gymCenterId, date);
		return;
	}
	public List<GymCentre> viewAllGymCenters(String gymOwnerEmail){
		System.out.println("Listing all Gym Centres");
		System.out.printf("%5s %10s %8s %10s", "CenterId","Location", "Seats", "Approved");
		System.out.println();
		List<GymCentre> gymList = new ArrayList<GymCentre>();
//		if (gymOwnerId == null) {
//			throw new NoGymOwnerIdFoundException();
//		}
//		try {
//			gymList = gymOwnerGMSDao.viewAllGymCenters(gymOwnerId);
//		} catch (Exception ex) {
//			throw new NoDataFoundException();
//		}
//		return gymList;

		gymList = GymOwnerDAO.viewAllGymCenters(gymOwnerEmail);
		return gymList;
//		return allGyms;
	}
	public void createSlot(Slot slot){
		GymOwnerDAO.createSlot(slot);
	}

	public static boolean checkGymApproval(int gymId) {
		return GymOwnerDAO.checkGymApproval(gymId);
	}
}
