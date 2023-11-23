package com.flipkart.bean;

public class GymCentre {
	
	private int gymId;
	private int centreId;
	private String locationId;
	private boolean isApproved;
	
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public int getCentreId() {
		return centreId;
	}
	public void setCentreId(int centreId) {
		this.centreId = centreId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public boolean isApproved() {
		return isApproved;
	}
	private int numSeatsPerSlot;
	public int getNoOfSeat() {
		return numSeatsPerSlot;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public void setNoOfSeats(int i) {
		this.numSeatsPerSlot = i;
	}
}

