package com.flipkart.business;

import java.util.List;

import com.flipkart.DAO.AdminDAOImpl;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

public class AdminLogicImpl implements AdminLogic {

	AdminDAOImpl adminGMSDao = new AdminDAOImpl();

	/**
	 * Retrieves a list of all gym owners in the system.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> viewAllGymOwners() {
		return adminGMSDao.seeAllGymOwner();
	}

	/**
	 * Retrieves a list of all gyms in the system.
	 * @return List of Gymnasium objects
	 */
	public List<GymCentre> viewAllGyms() {
		return adminGMSDao.seeAllGyms();
	}

	/**
	 * Retrieves a list of pending gym owner requests.
	 * @return List of GymOwner objects
	 */
	public List<GymOwner> viewPendingGymOwnerRequests() {
		return adminGMSDao.seePendingGymOwnerRequest();
	}

	/**
	 * Retrieves a list of pending gym requests.
	 * @return List of Gymnasium objects
	 */
	public List<GymCentre> viewPendingGymRequests() {
		return adminGMSDao.seePendingGymRequest();
	}

	/**
	 * Approves a single gym owner request.
	 * @param requestId The ID of the request to be approved
	 */
	public void approveGymOwnerRequest(String email) {
		adminGMSDao.approveSingleOwnerRequest(email);
	}

	/**
	 * Approves a single gym request.
	 * @param gymId The ID of the gym request to be approved
	 */
	public void approveGymRequest(int gymId) {
		adminGMSDao.approveSingleGymRequest(gymId);
	}

}
