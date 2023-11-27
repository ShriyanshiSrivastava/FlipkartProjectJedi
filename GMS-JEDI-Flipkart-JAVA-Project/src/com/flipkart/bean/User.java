package com.flipkart.bean;

public class User {

	public User (String email,String password,int roleId) {
		this.email=email;
		this.password=password;
		this.roleId=roleId;
	}
	
	private int roleId;
	private String email;
	private String password;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
