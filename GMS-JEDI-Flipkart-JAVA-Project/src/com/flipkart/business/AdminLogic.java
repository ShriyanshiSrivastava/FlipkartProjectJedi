package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

public class AdminLogic {

	public List<GymCentre> viewPendingGymRequests() {
		System.out.println("All pending Gym requests");
		return new ArrayList<GymCentre>();
	}

	public List<GymOwner> viewPendingGymOwnerRequests() {
		System.out.println("All pending GymOwner requests");
		return new ArrayList<GymOwner>();
	}

	public boolean approveGymOwnerRegistration(int gymOwnerId){
		System.out.println("GymOwner Approved Successfully");
		return true;
	}

	public boolean approveGymRegistration(int gymCenterId){
		System.out.println("Gym Approved Successfully");
		return true;
	}

	public static List<GymOwner> viewAllGymOwners() {
		System.out.println("All GymOwners");
		return new ArrayList<GymOwner>();
	}

	public List<GymCentre> viewAllGyms() {
		System.out.println("All Gyms");
		return new ArrayList<GymCentre>();
	}
}
