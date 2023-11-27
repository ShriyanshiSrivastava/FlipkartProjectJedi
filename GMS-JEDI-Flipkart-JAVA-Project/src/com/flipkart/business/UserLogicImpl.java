package com.flipkart.business;

import com.flipkart.DAO.UserDAOImpl;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public class UserLogicImpl implements UserLogic {
    UserDAOImpl userGMSDao = new UserDAOImpl();

    /**

     Registers a customer in the database.
     @param customerData The Customer object representing the customer data
     */
    public void registerCustomer(Customer customerData) {
        userGMSDao.registerCustomer(customerData);
    }
    /**

     <<<<<<< Updated upstream

     public void registerGymOwner(GymOwner gymOwner) {
     //System.out.println("GymOwner registered");
     UserDAO.registerGymOwner(gymOwner);
     =======
     Registers a gym owner in the database.
     @param ownerData The GymOwner object representing the gym owner data
     */
    public void registerGymOwner(GymOwner ownerData) {
        userGMSDao.registerGymOwner(ownerData);

    }
    /**

     Authenticates a user based on the provided user data.
     @param userData The User object representing the user data
     @return The authenticated User object if authentication is successful, null otherwise
     */
    public User authenticateUser(User userData) {
        try {
            User authenticatedUser = userGMSDao.isAuthenticated(userData);
            return authenticatedUser;
        } catch (Exception e) {
            System.out.println("User Not Found");

        }
        return null;
    }
    /**

     Registers a user in the database.
     @param userData The User object representing the user data
     */
    public void registerUser(User userData) {
        userGMSDao.registerUser(userData);
    }
    /**

     Logs out a user.
     @param userData The User object representing the user data
     @return true if the user is successfully logged out, false otherwise
     */
    public boolean logout(User userData) {
        // Perform logout logic here
        return true;
    }
}


