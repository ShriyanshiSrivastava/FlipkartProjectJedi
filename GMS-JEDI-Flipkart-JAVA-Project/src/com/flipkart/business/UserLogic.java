package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public class UserLogic {
    public void registerCustomer(Customer customer) {
        System.out.println("Customer registered");
    }


    public void registerGymOwner(GymOwner gymOwner) {
        System.out.println("GymOwner registered");
    }

    public void login(User user) {
        System.out.println("Logged in successfully");
    }

    public void logout(User user) {
        System.out.println("LoggedOut in successfully");
    }
}


