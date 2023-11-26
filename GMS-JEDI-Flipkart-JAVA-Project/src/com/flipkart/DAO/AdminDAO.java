package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.utils.DBConnection;
import com.flipkart.utils.SQLConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    public List<GymCentre> seeAllGyms() {

        List<GymCentre> gymDetails = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching gyms..");

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYMS);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                GymCentre gym = new GymCentre();
                gym.setGymId(rs.getInt("gymId"));
                gym.setName(rs.getString("name"));
                gym.setAddress(rs.getString("address"));
                gym.setApproved(rs.getBoolean("isApproved"));
                gymDetails.add(gym);
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        return gymDetails;
        // TODO Auto-generated method stub

    }

    public List<GymOwner> seeAllGymOwner() {

        List<GymOwner> gymOwnerDetails = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching gym owners..");

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYMOWNERS);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setEmail(rs.getString("email"));
                gymOwner.setName(rs.getString("name"));
                gymOwner.setAadhar(rs.getString("aadhar"));
                gymOwner.setGstNumber(rs.getString("gstNumber"));
                gymOwner.setAddress(rs.getString("address"));
                gymOwner.setApproved(rs.getBoolean("isApproved"));
                gymOwnerDetails.add(gymOwner);
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        return gymOwnerDetails;
    }

    public List<GymOwner> seePendingGymOwnerRequest() {
        // TODO Auto-generated method stub
        List<GymOwner> gymOwnerDetails = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching pending gym owners..");

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_NOT_APPROVED_GYMOWNERS);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setEmail(rs.getString("email"));
                gymOwner.setName(rs.getString("name"));
                gymOwner.setAadhar(rs.getString("aadhar"));
                gymOwner.setGstNumber(rs.getString("gstNumber"));
                gymOwner.setAddress(rs.getString("address"));
                gymOwner.setApproved(rs.getBoolean("isApproved"));
                gymOwnerDetails.add(gymOwner);
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        return gymOwnerDetails;
    }

    public List<GymCentre> seePendingGymRequest() {
        // TODO Auto-generated method stub
        List<GymCentre> gymDetails = new ArrayList<GymCentre>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching gyms..");

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_NOT_APPROVED_GYMS);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                GymCentre gym = new GymCentre();
                gym.setGymId(rs.getInt("gymId"));
                gym.setName(rs.getString("name"));
                gym.setAddress(rs.getString("address"));
                gym.setApproved(rs.getBoolean("isApproved"));
                gymDetails.add(gym);
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }

        return gymDetails;
    }


    public void approveSingleOwnerRequest(String email) {
        // TODO Auto-generated method stub
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching gyms owners..");

            stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_OWNER_BY_ID);
            stmt.setString(1, email);
            stmt.executeUpdate();
            System.out.println("The gym owner has been approved!");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void approveSingleGymRequest(int gymId) {
        // TODO Auto-generated method stub
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching gyms..");

            stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_BY_ID);
            stmt.setInt(1, gymId);
            stmt.executeUpdate();
            System.out.println("The gym has been approved!");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }

}
