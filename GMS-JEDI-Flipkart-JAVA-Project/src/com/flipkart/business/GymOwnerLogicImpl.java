package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAOImpl;
import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

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
		gymOwnerDAO.addGym(gymCenter);
	}
	public boolean isApproved(String gymOwnerEmail) {
		//System.out.println("Owner approved Successfully");
		return gymOwnerDAO.isApproved(gymOwnerEmail);
	}
	public void addSlots(int gymCenterId,String date) {
		//allSlots.add(slot);
		//System.out.println("Slot added successfully");
		gymOwnerDAO.addSlots(gymCenterId, date);
		return;
	}
	public List<GymCentre> viewAllGymCenters(String gymOwnerEmail){
		System.out.println("Listing all Gym Centres");
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
		gymList = gymOwnerDAO.viewAllGymCenters(gymOwnerEmail);
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
