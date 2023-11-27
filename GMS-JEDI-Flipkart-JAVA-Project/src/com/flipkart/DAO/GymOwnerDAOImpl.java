package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.utils.SQLConstants;

public class GymOwnerDAOImpl implements GymOwnerDAO {
    static Connection conn = null;
    static PreparedStatement stmt = null;

    public GymOwner getGymOwnerDetails(String gymOwnerId) {
        GymOwner gymOwnerDetails = new GymOwner();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching gym...");

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYMOWNER_DETAILS_QUERY);
            stmt.setString(1, gymOwnerId);

            ResultSet rs = stmt.executeQuery();
            gymOwnerDetails.setEmail(rs.getString("email"));
            gymOwnerDetails.setName(rs.getString("name"));
            gymOwnerDetails.setAadhar(rs.getString("aadharNumber"));
            gymOwnerDetails.setGstNumber(rs.getString("gstNumber"));
            gymOwnerDetails.setAddress(rs.getString("address"));
            gymOwnerDetails.setApproved(rs.getBoolean("isApproved"));

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gymOwnerDetails;

    }

    public List<Slot> viewAllSlots(){
        List<Slot> allSlot = new ArrayList<Slot>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching all slots...");

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_SLOTS);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Slot slot = new Slot();
                slot.setSlotId(rs.getInt("slotId"));
                slot.setSlotId(Integer.parseInt(rs.getString("gymId")));
                slot.setCustomerId(rs.getInt("custId"));
                slot.setDate(rs.getString("date"));
                slot.setTime(rs.getString("time"));
                allSlot.add(slot);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allSlot;
    }

    public int findCapacity(int gymId) {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            stmt = conn.prepareStatement(SQLConstants.SQL_FIND_CAPACITY);
            stmt.setInt(1, gymId);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return rs.getInt("totalSeatsPerSlot");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public boolean checkIfAlreadyBooked(int gymId) {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_SLOT_FOR_GYM);
            stmt.setInt(1, gymId);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public void addSlots(int gymId, String time) {
        int slotCapacity = findCapacity(gymId);
        int custId=0;
        int slotId=0;
        String date=time;
        try{

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_ALL_SLOTS);
            stmt.setString(1, String.valueOf(gymId));
            stmt.setInt(2, custId);
            stmt.setInt(3, slotId);
            stmt.setString(4, date);
            stmt.setString(5, time);
            stmt.executeUpdate();
            System.out.println("Slot added!");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSlot(Slot slot){

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/GMSFlipFit", "root", "2001");
            statement = connection.prepareStatement(SQLConstants.CREATE_SLOT);

            statement.setInt(1,slot.getSlotId());
            statement.setString(2,slot.getTime());
            statement.executeUpdate();
            statement.close();

        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
    }
    public List<GymCentre> viewAllGymCenters(String gymOwnerEmail) {

        List<GymCentre> gymDetails = new ArrayList<GymCentre>();


        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            System.out.println("Fetching gym...");

            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYM_DETAILS_QUERY);
            stmt.setString(1, gymOwnerEmail);

            ResultSet rs = stmt.executeQuery();
            System.out.println();
            System.out.println("Gym Owner Email : " + gymOwnerEmail);
            while (rs.next()) {
                GymCentre gym = new GymCentre();
                gym.setGymId(rs.getInt("gymId"));
                gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
                gym.setName(rs.getString("name"));
                gym.setAddress(rs.getString("address"));
                gym.setNumItem(rs.getInt("numItem"));
                gym.setApproved(rs.getBoolean("isApproved"));
                gymDetails.add(gym);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gymDetails;

    }

    public void addGym(GymCentre gymDetails) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYM_DETAILS_QUERY);

            // Hard coded d
            // Bind values into the parameters.
            stmt.setInt(1, gymDetails.getGymId());  // This would set age
            stmt.setString(6, gymDetails.getGymOwnerEmail());
            stmt.setString(3, gymDetails.getName());
            stmt.setString(4, gymDetails.getAddress());
            stmt.setInt(7, gymDetails.getNumItem());
            stmt.setInt(2,gymDetails.getNoOfSeat());
            stmt.setBoolean(5, false);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isApproved(String email) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_OWNER_APPROVE);
            stmt.setString(1, email);
            ResultSet output = stmt.executeQuery();
            if(output.next())
                return true;
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return false;
    }

    public boolean checkGymApproval(int gymId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_GYM_APPROVE);
            stmt.setInt(1, gymId);
            ResultSet output = stmt.executeQuery();
            if(output.next())
                return true;
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return false;
    }

}