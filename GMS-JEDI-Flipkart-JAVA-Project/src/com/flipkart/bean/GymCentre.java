package com.flipkart.bean;

public class GymCentre {
	
	private int gymId;
	private String locationId;
	private String name;
	private int totalSeatsPerSlot;
	private String address;
	private boolean isApproved;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
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
	public int getNoOfSeat() {
		return totalSeatsPerSlot;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public void setNoOfSeats(int i) {
		this.totalSeatsPerSlot = i;
	}
}

