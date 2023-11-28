package com.flipkart.business;

import com.flipkart.DAO.CustomerDAOImpl;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.SlotNotFoundException;

import java.util.List;

import static com.flipkart.utils.ColorConstants.ANSI_RED;
import static com.flipkart.utils.ColorConstants.ANSI_RESET;

/**
 * This class implements the CustomerLogicInterface and provides the functionality for customer operations in the Gym Management System.
 */
public class CustomerLogicImpl implements CustomerLogic {

	CustomerDAOImpl customerDaoImpl = new CustomerDAOImpl();

	/**
	 * Fetches the details of a customer based on the customer ID.
	 * @param customerId The ID of the customer
	 * @return Customer object representing the customer details
	 */
	public Customer fetchCustomerDetails(String customerId) {
		return new Customer();
	}

	/**
	 * Fetches the list of available gyms for the customer.
	 * @return List of Gym objects representing the available gyms
	 */
	public List<GymCentre> fetchGymList() throws GymCentreNotFoundException {
		List<GymCentre> gymList =  customerDaoImpl.fetchGymList();
		if(gymList.size()==0){
			throw new GymCentreNotFoundException();
		}

		return gymList;
	}


	/**
	 * Fetches the availability of slots for a particular gym.
	 * @param gymId The ID of the gym
	 * @return true if slots are available, false otherwise
	 */
	public boolean fetchAvilableSlots(int gymId){
		try {
			customerDaoImpl.fetchSlotList(gymId);
			return true;
		} catch  (Exception e){
			System.out.println(ANSI_RED + "No Slot Found" + ANSI_RESET);
		}
		return false;
	}

	/**
	 * Books slots for a customer at a specified gym, date, and slot time.
	 * @param gymId The ID of the gym
	 * @param slotId The ID of the slot
	 * @param email The email of the customer
	 * @param date The date of the slot
	 * @return The booking ID if the slots are successfully booked, 0 if the slot is already booked and replaced, 1 if the slot is already full, 2 if the slots are successfully booked
	 */
	public int bookSlots(int gymId, String slotId, String email, String date) throws SlotNotFoundException {
		if(slotId == null){
			throw new SlotNotFoundException();
		}
		if(alreadyBooked(slotId, email, date)) {
			customerDaoImpl.cancelBooking(slotId, email, date);
			customerDaoImpl.bookSlots(gymId, slotId, email, date);
			return 0;
		} else if(isFull(slotId, date)) {
			return 1;
		} else {
			customerDaoImpl.bookSlots(gymId, slotId, email, date);
			return 2;
		}
	}

	/**
	 * Checks if a customer has already booked a slot at a specified slot time and date.
	 * @param slotId The ID of the slot
	 * @param email The email of the customer
	 * @param date The date of the slot
	 * @return true if the customer has already booked a slot, false otherwise
	 */
	public boolean alreadyBooked(String slotId, String email, String date) {
		return customerDaoImpl.alreadyBooked(slotId, email, date);
	}

	/**
	 * Checks if a slot is already full for a specified slot time and date.
	 * @param slotId The ID of the slot
	 * @param date The date of the slot
	 * @return true if the slot is full, false otherwise
	 */
	public boolean isFull(String slotId, String date) {
		return customerDaoImpl.isFull(slotId, date);
	}


	/**
	 * Fetches the booked slots for a customer based on the customer's email.
	 * @param email The email of the customer
	 */
	public void fetchBookedSlots(String email) {
		customerDaoImpl.fetchBookedSlots(email);
	}

	/**
	 * Checks if a slot exists for a specified slot ID and gym ID.
	 * @param slotId The ID of the slot
	 * @param gymId The ID of the gym
	 * @return true if the slot exists, false otherwise
	 */
	public boolean checkSlotExists(String slotId, int gymId) {
		return customerDaoImpl.checkSlotExists(slotId, gymId);
	}

	/**
	 * Cancels a booked slot for a customer based on the booking ID.
	 * @param bookingId The ID of the booking to cancel
	 */
	public void cancelBookedSlots(int bookingId) {
		customerDaoImpl.cancelBookedSlots(bookingId);
	}

	/**
	 * Checks if a gym is approved for a specified gym ID.
	 * @param gymId The ID of the gym
	 * @return true if the gym is approved, false otherwise
	 */
	public boolean checkGymApprove(int gymId) {
		return customerDaoImpl.checkGymApprove(gymId);
	}
}