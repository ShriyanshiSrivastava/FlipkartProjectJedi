package com.flipkart.DAO;
import com.flipkart.bean.*;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.utils.SQLConstants;
//import com.flipkart.exception.UserNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    static Connection conn = null;
    static PreparedStatement stmt = null;

    public User isAuthenticated(User userData){


        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");


            stmt = conn.prepareStatement(SQLConstants.SQL_AUTH_QUERY);
            stmt.setString(1, userData.getEmail());
            stmt.setString(2, userData.getPassword());
            ResultSet rs = stmt.executeQuery();
            if(rs.next() == true)
            {
                int roleId = rs.getInt("roleId");
                userData.setRoleId(roleId);
            }
            else {
                throw new UserNotFoundException();
            }
            stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userData.getRoleId()==0? null:userData;
    }

    public void registerCustomer(Customer customerData) {
        // todo
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_CUSTOMER_DETAILS_QUERY);
            stmt.setString(1, customerData.getEmail());
            stmt.setString(2, customerData.getName());
            stmt.setString(3, customerData.getAddress());
            stmt.setString(4, customerData.getPassword());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Added Customer details");
    }

    public void registerGymOwner(GymOwner ownerData) {
        // todo
        try{

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYMOWNER_DETAILS_QUERY);
            stmt.setString(1, ownerData.getEmail());
            stmt.setString(2, ownerData.getName());
            stmt.setString(4, ownerData.getAadhar());
            stmt.setString(5, ownerData.getGstNumber());
            stmt.setString(3, ownerData.getAddress());
            stmt.setBoolean(6, false);
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Added Gym Owner details");
    }

    public void registerUser(User userData) {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_USER_DETAILS_QUERY);
            stmt.setString(1, userData.getEmail());  // This would set age
            stmt.setString(2,userData.getPassword());
            stmt.setInt(3, userData.getRoleId());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
