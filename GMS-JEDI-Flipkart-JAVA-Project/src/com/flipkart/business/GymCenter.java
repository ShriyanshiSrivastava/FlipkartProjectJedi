package com.flipkart.business;

public class GymCenter {
	private String[] center;
	public String[] viewAllCenter() {
		return center;
	}
	public String viewOneCenter(int id) {
		return center[id];
	}
}
