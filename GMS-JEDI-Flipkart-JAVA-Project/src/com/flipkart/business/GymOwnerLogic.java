package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerLogic {

	public GymOwner getGymOwnerDetails(int gymOwnerId) {
		return new GymOwner();
	}

	public List<Slot> viewAllSlots(int GymCenterId){
		System.out.println("Listing all Slots in  GymCenter");
		return new ArrayList<Slot>();
	}
	public void addGym(GymCentre gymCenter) {
		System.out.println("Slot added successfully");
		return;
	}
	public boolean isApproved(String gymOwnerEmail) {
		System.out.println("Owner approved Successfully");
		return true;
	}
	public void addSlots(int gymCenterId,String date,Slot slot) {
		System.out.println("Slot added successfully");
		return;
	}
	public List<GymCentre> viewAllGymCenters(String gymOwnerEmail){
		System.out.println("Listing all GymCenter");
		return new ArrayList<GymCentre>();
	}
}
