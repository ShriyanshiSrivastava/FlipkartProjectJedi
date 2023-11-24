package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymOwnerLogic {

	List<Slot> allSlots;
	List<GymCentre> allGyms;

	public GymOwnerLogic() {
		Slot s1=new Slot();
		s1.setGymId("1");
		s1.setDate("12-10-23");
		s1.setTime("4 pm");
		s1.setCentreId("1");
		s1.setTotalSlots(10);
		allSlots=new ArrayList<>();
		allSlots.add(s1);

		GymCentre gc1=new GymCentre();
		gc1.setGymId(1);
		gc1.setNoOfSeats(10);
		gc1.setLocationId("1");
		gc1.setApproved(true);

		GymCentre gc2=new GymCentre();
		gc2.setGymId(2);
		gc2.setNoOfSeats(20);
		gc2.setLocationId("2");
		gc2.setApproved(true);

		GymCentre gc3=new GymCentre();
		gc3.setGymId(3);
		gc3.setApproved(false);

		allGyms = new ArrayList<>();
		allGyms.add(gc1);
		allGyms.add(gc2);
	}

	public GymOwner getGymOwnerDetails(int gymOwnerId) {
		return new GymOwner();
	}

	public List<Slot> viewAllSlots(int GymCenterId){
		System.out.println("Listing all Slots in GymCenter");
		return allSlots;
	}
	public void addGym(Scanner sc, GymCentre gymCenter) {
		System.out.println("Add gym Details: ");
		System.out.print("Add GymCenter id: ");

		gymCenter.setGymId(sc.nextInt());
		System.out.print("Enter gym location: ");
		gymCenter.setLocationId(sc.next());
		System.out.println("Enter the number of seats: ");
		gymCenter.setNoOfSeats(sc.nextInt());
		System.out.println("Gym added successfully");
		allGyms.add(gymCenter);
	}
	public boolean isApproved(String gymOwnerEmail) {
		System.out.println("Owner approved Successfully");
		return true;
	}
	public void addSlots(int gymCenterId,String date,Slot slot) {
		allSlots.add(slot);
		System.out.println("Slot added successfully");
		return;
	}
	public List<GymCentre> viewAllGymCenters(String gymOwnerEmail){
		System.out.println("Listing all Gym Centres");
		System.out.printf("%5s %10s %8s %10s", "CenterId","Location", "Seats", "Approved");
		System.out.println();
		return allGyms;
	}
}
