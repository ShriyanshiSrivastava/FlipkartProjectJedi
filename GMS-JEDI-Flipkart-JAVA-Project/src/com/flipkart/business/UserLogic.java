package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public interface UserLogic {
    void registerCustomer(Customer customerData);
    void registerGymOwner(GymOwner ownerData);
    User authenticateUser(User userData);
    void registerUser(User userData);
    boolean logout(User userData);
}
