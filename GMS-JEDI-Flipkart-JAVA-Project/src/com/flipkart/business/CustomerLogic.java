package com.flipkart.business;

public class CustomerLogic {
	public boolean bookSlot() {
		return true;
	}
	public String[] viewSlots() {
		String[] slots = {};
		return slots;
	}
	public boolean cancelSlot(int id) {
		System.out.println("A slot has been canceled");
		return true;
	}
	public boolean makePayment() {
		System.out.println("Payment has been made");
		return true;
	}
}
