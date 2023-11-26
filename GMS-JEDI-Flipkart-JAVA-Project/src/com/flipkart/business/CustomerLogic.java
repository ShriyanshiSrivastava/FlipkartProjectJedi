package com.flipkart.business;

import com.flipkart.DAO.CustomerDAO;
import com.flipkart.DAO.SlotDAO;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerLogic {

	private List<Customer> customerCollection = new CustomerDAO().getCustomerList();
	private List<Slot> slotsList = new SlotDAO().getSlotsList();


	public int login(String userName, String password){
		for(Customer c: customerCollection){
			if(c.getName().equals(userName) && c.getPassword().equals(password)){
				System.out.println("Login Successful");
				return c.getId();
			}
		}
		System.out.println("Login Failed Wrong Credentials");
		return -1;
	}

//  public Customer getCustomerDetails(int customerId) {
//     return new Customer();
//  }

	public List<GymCentre> viewAllGymCentres() {
		System.out.println("Listing all Gym Centers");
		return new ArrayList<GymCentre>();
	}

	public List<Slot> viewAllSlots(int GymCenterId){
		System.out.println("Listing all Slots in  GymCenter");
		return new ArrayList<Slot>();
	}

	public boolean bookSlot(Scanner sc, int customerId) {
		System.out.println("Enter your GymId:");
		String gymId = sc.next();
		System.out.println("Enter your slotId:");
		int slotId = Integer.parseInt(String.valueOf(sc.nextInt()));
		System.out.println("Enter your date:");
		String date = sc.next();
		System.out.println("Enter time for slot");
		String time = sc.next();


		if(isAlreadyBooked(slotId,customerId,date)) {
			System.out.println("Slot is already booked");
			cancelSlot(slotId,customerId,date);
		}
		Slot bookedSlot = new Slot();
		bookedSlot.setGymId(gymId);
		bookedSlot.setDate(date);
		bookedSlot.setTime(time);
		slotsList.add(bookedSlot);

		System.out.println("Slot booked");
		return true;
	}

	private boolean isAlreadyBooked(int slotId,int customerId,String date) {
		for(Slot slot : slotsList)
		{
			if(slot.getCustomerId()==customerId&&slot.getSlotId()==slotId&&slot.getDate()==date)
			{
				return true;
			}
		}
		return false;
	}


	public boolean cancelSlot(int slotId,int customerId, String date) {
		System.out.println("Cancelling Slot");
		Slot removeSlot = null;
		for(Slot slot : slotsList)
		{
			if(slot.getCustomerId()==customerId&&slot.getDate().equals(date))
			{

				removeSlot = slot;
			}
		}
		if(removeSlot!=null)
			slotsList.remove(removeSlot);

		return true;
	}

	public List<Slot> viewAllBookings(int customerId) {
		System.out.println("Listing all customer booked slots");
		System.out.printf("%5s %10s %10s %8s", "CustomerId","GymId", "Date", "Time");
		System.out.println();
		for(Slot slot : slotsList)
		{
			if(slot.getCustomerId()==customerId)
			{
				System.out.printf("%5s %13s %14s %5s", customerId, slot.getGymId(), slot.getDate(),slot.getTime());
				System.out.println();

			}
		}

		return new ArrayList<Slot>();
	}
}