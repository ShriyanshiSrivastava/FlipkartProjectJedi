package com.flipkart.DAO;
import com.flipkart.bean.*;
import com.flipkart.utils.SQLConstants;
//import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO{

    //	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost/GMS_db";
//	static final String USER = "root";
//	static final String PASS = "Naman@fk";
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
                //throw new UserNotFoundException();
            }
            stmt.close();
//			      conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        //end try
//		System.out.println("Authentication checked");
        return userData.getRoleId()==0? null:userData;
    }

    public void registerCustomer(Customer customerData) {
        // todo
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            //STEP 4: Execute a query
//               System.out.println("Creating statement...");
            //String sql = "UPDATE Employees set age=? WHERE id=?";
            // String sql1="delete from employee where id=?";
            // stmt.setInt(1, 101);
            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_CUSTOMER_DETAILS_QUERY);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, customerData.getEmail());  // This would set age
            stmt.setString(2, customerData.getName());
            stmt.setString(3, customerData.getAddress());
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
            stmt.close();
//               conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Added Customer details");
        return;
    }

    public static void registerGymOwner(GymOwner ownerData) {
        // todo
        try{

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");

            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYMOWNER_DETAILS_QUERY);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, ownerData.getEmail());  // This would set age
            stmt.setString(2, ownerData.getName());
            stmt.setString(4, ownerData.getAadhar());
            stmt.setString(5, ownerData.getGstNumber());
            stmt.setString(3, ownerData.getAddress());
            stmt.setBoolean(6, false);
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
            stmt.close();
//                  conn.close();x
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Added Gym Owner details");
        return;
    }

    public void registerUser(User userData) {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GMSFlipFit", "root", "2001");
            stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_USER_DETAILS_QUERY);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, userData.getEmail());  // This would set age
            stmt.setString(2,userData.getPassword());
            stmt.setInt(3, userData.getRoleId());
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }//end try
//			   System.out.println("Added User Details");
        return;
    }

}
