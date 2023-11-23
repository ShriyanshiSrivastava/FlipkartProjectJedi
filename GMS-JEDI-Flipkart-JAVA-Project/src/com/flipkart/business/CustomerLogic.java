package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class CustomerLogic {
	public Customer getCustomerDetails(int customerId) {
		return new Customer();
	}

	public List<GymCentre> viewAllGymCentres() {
		System.out.println("Listing all Gym Centers");
		return new ArrayList<GymCentre>();
	}

	public List<Slot> viewAllSlots(int GymCenterId){
		System.out.println("Listing all Slots in  GymCenter");
		return new ArrayList<Slot>();
	}

	public boolean bookSlot(int gymCenterId,int slotId,String date,int customerId) {
		if(isAlreadyBooked(slotId,customerId,date)) {
			cancelSlot(slotId,customerId);
		}
		System.out.println("Slot booked");
		return true;
	}

	private boolean isAlreadyBooked(int slotId,int customerId,String date) {

		return true;
	}


	public boolean cancelSlot(int slotId,int customerId) {
		System.out.println("Cancelling Slot");
		return true;
	}

	public List<Slot> viewAllBookings(int customerId) {
		System.out.println("Listing all customer booked slots");
		return new ArrayList<Slot>();
	}
}
