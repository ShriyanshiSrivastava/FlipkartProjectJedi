package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public interface UserDAO {
    User isAuthenticated(User userData);
    void registerCustomer(Customer customerData);
    void registerGymOwner(GymOwner ownerData);
    void registerUser(User userData);

}
