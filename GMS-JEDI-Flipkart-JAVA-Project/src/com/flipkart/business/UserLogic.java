package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exceptions.UserNotFoundException;

public interface UserLogic {
    void registerCustomer(Customer customerData);
    void registerGymOwner(GymOwner ownerData) throws UserNotFoundException;
    User authenticateUser(User userData);
    void registerUser(User userData);
}
