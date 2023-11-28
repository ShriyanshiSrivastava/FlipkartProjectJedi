package com.flipkart.bean;

public class Slot {
	private String gymId;
	private static int slotId;
	private int customerId;
	private String date;
	private String time;

	public static int getSlotId()
	{
		return slotId;
	}

	public void setSlotId(int slotId)
	{
		this.slotId = slotId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getGymId() {
		return gymId;
	}
	public void setGymId(String gymId) {
		this.gymId = gymId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}