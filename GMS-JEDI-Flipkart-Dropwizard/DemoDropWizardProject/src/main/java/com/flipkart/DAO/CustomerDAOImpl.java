package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.utils.SQLConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.utils.ColorConstants.*;

public class CustomerDAOImpl implements CustomerDAO {
    public List<GymCentre> fetchGymList() {
        List<GymCentre> gymDetails = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_APPROVED_GYMS);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                GymCentre gym = new GymCentre();
                gym.setGymId(rs.getInt("gymId"));
                gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
                gym.setName(rs.getString("name"));
                gym.setAddress(rs.getString("address"));
                gym.setNumItem(rs.getInt("numItem"));
                gymDetails.add(gym);
            }
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return gymDetails;
    }

    public void fetchSlotList(int gymId) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYM_SLOT_QUERY);
            stmt.setInt(1, gymId);
            ResultSet output = stmt.executeQuery();
            if(!output.next()) {
                System.out.println(ANSI_RED + "No Slot Found" + ANSI_RESET);

            }
            System.out.println( "-----------------------------------------" + ANSI_RESET);
            System.out.printf(ANSI_BLUE + "%-16s %-16s %-16s %n", "Slot Id", "Slot Time", "Gym Id" + ANSI_RESET);
            System.out.println( "-----------------------------------------" + ANSI_RESET);
            do {
                System.out.printf(ANSI_YELLOW + "%-16s", output.getString(3) );
                System.out.printf("  %-16s", output.getString(5) );
                System.out.printf("  %-16s", output.getString(1) + ANSI_RESET);
                System.out.println("");
            }while(output.next());
            System.out.println( "-----------------------------------------" + ANSI_RESET);
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }
    }

    public void bookSlots(int gymId, String slotId,String email,String date) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");


            stmt = conn.prepareStatement(SQLConstants.SQL_BOOK_SLOT_QUERY);
            stmt.setString(1, slotId);
            stmt.setInt(2, gymId);
            stmt.setString(3, email);
            stmt.setString(4, date);

            stmt.executeUpdate();

        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }

        return;
    }

    public boolean isFull(String slotId,String date) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            stmt = conn.prepareStatement(SQLConstants.SQL_COUNT_CURRENT_CAPACITY_QUERY);
            stmt.setString(1, slotId);
            stmt.setString(2, date);
            ResultSet output = stmt.executeQuery();
            output.next();
            int current_capacity = output.getInt(1);
            stmt = conn.prepareStatement(SQLConstants.SQL_FIND_CAPACITY);
            stmt.setString(1, slotId);
            output = stmt.executeQuery();
            output.next();
            int total_capacity = output.getInt(2);
            System.out.println("total_CP" + total_capacity);
            return current_capacity>=total_capacity;
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return false;
    }

    public void fetchBookedSlots(String email) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_BOOKED_SLOT_QUERY);
            stmt.setString(1, email);
            ResultSet output = stmt.executeQuery();
            System.out.println( "-----------------------------------------" + ANSI_RESET);
            System.out.printf(ANSI_BLUE + "%-16s %-16s %-16s %n", "Booking Id", "Date", "Gym Id" + ANSI_RESET);
            System.out.println( "-----------------------------------------" + ANSI_RESET);
            while(output.next()) {
                System.out.printf(ANSI_YELLOW + "%-16s", output.getInt(5) );
                System.out.printf("  %-16s",output.getString(4));
                System.out.printf("%-16s", output.getString(2) + ANSI_RESET);
                System.out.println("");
            }
            System.out.println( "-----------------------------------------" + ANSI_RESET);
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
    }

    public void cancelBooking(String slotId, String email, String date) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_CANCEL_BOOKED_SLOT_QUERY);
            stmt.setString(1, email);
            stmt.setString(2, slotId);
            stmt.setString(3, date);
            stmt.executeUpdate();

        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }


    }


    public boolean alreadyBooked(String slotId, String email, String date) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_ALREADY_BOOKED_SLOT_QUERY);
            stmt.setString(1, email);
            stmt.setString(2, slotId);
            stmt.setString(3, date);
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

    public boolean checkSlotExists(String slotId, int gymId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_SLOT_QUERY);
            System.out.println(slotId);
//            System.out.println(gymId);
            stmt.setString(1, slotId);
            stmt.setInt(2, gymId);
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


    public void cancelBookedSlots(int bookingId) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_CANCEL_BOOKING);
            stmt.setInt(1, bookingId);
            stmt.executeUpdate();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }

    }

    //@Override
    public boolean checkGymApprove(int gymId) {
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