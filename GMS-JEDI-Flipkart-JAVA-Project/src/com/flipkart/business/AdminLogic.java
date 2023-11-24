package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

public class AdminLogic {

	List<GymCentre> pendingGymCentres;
	List<GymOwner> pendingGymOwners;
	List<GymCentre> allGymCentres;
	List<GymOwner> allGymOwners;

	public AdminLogic(){
		GymCentre gc1=new GymCentre();
		gc1.setName("Gym1");
		gc1.setAddress("Bellandur");
		gc1.setGymId(1);
		gc1.setApproved(true);

		GymCentre gc2=new GymCentre();
		gc2.setName("Gym2");
		gc2.setAddress("Delhi");
		gc2.setGymId(2);
		gc2.setApproved(true);

		GymCentre gc3=new GymCentre();
		gc3.setName("Gym3");
		gc3.setAddress("Noida");
		gc3.setGymId(3);
		gc3.setApproved(false);

		GymOwner go1=new GymOwner();
		go1.setAadhar("12345");
		go1.setName("Owner1");
		go1.setEmail("owner1@flipfit");
		go1.setGstNumber("12345");
		go1.setApproved(true);

		GymOwner go2=new GymOwner();
		go2.setAadhar("45762");
		go2.setName("Owner2");
		go2.setEmail("owner2@flipfit");
		go2.setGstNumber("45762");
		go2.setApproved(true);

		GymOwner go3=new GymOwner();
		go3.setAadhar("718728");
		go3.setName("Owner3");
		go3.setEmail("owner3@flipfit");
		go3.setGstNumber("718728");
		go3.setApproved(false);

		pendingGymCentres = new ArrayList<>();
		pendingGymCentres.add(gc3);

		pendingGymOwners = new ArrayList<>();
		pendingGymOwners.add(go3);

		allGymCentres = new ArrayList<>();
		allGymCentres.add(gc1);
		allGymCentres.add(gc2);

		allGymOwners = new ArrayList<>();
		allGymOwners.add(go1);
		allGymOwners.add(go2);
	}

	public List<GymCentre> viewPendingGymRequests() {
		System.out.println("All pending Gym requests");
		return pendingGymCentres;
	}

	public List<GymOwner> viewPendingGymOwnerRequests() {
		System.out.println("All pending GymOwner requests");
		return pendingGymOwners;
	}

	public boolean approveGymOwnerRegistration(int gymOwnerId){
		System.out.println("GymOwner Approved Successfully");
		return true;
	}

	public boolean approveGymRegistration(int gymCenterId){
		System.out.println("Gym Approved Successfully");
		return true;
	}

	public List<GymOwner> viewAllGymOwners() {
		System.out.println("All GymOwners");
		return allGymOwners;
	}

	public List<GymCentre> viewAllGyms() {
		System.out.println("All Gyms");
		return allGymCentres;
	}

	public void approveGymRequest(int gymId) {
		for(int i=0; i<pendingGymCentres.size(); i++){
			if(pendingGymCentres.get(i).getGymId()==gymId){
				pendingGymCentres.get(i).setApproved(true);
				allGymCentres.add(pendingGymCentres.get(i));
				pendingGymCentres.remove(pendingGymCentres.get(i));
				break;
			}
		}
		System.out.println("Gym centre has been approved");

	}

	public void approveGymOwnerRequest(String email) {
		for(int i=0;i<pendingGymOwners.size();i++) {
			if(Objects.equals(pendingGymOwners.get(i).getEmail(), email)) {
				pendingGymOwners.get(i).setApproved(true);
				allGymOwners.add(pendingGymOwners.get(i));
				pendingGymOwners.remove(pendingGymOwners.get(i));
				break;
			}
		}
		System.out.println("Gym owner has been approved");
	}
}
