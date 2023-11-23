package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

public class AdminLogic {
	
	public boolean approve() {
		System.out.println("Approve");
		return true;
	}
	
	public List<GymCentre> viewPendingOwnerRequests(){
		System.out.println("View Pending Owner Requests");
		return new ArrayList<GymCentre>();
	}
	
	public List<GymOwner> viewGymOwners(){
		System.out.println("View gym owners");
		return new ArrayList<GymOwner>();
	}
	
	public List<GymCentre> viewAllGyms(){
		System.out.println("View all gyms");
		return new ArrayList<GymCentre>();
	}
}
