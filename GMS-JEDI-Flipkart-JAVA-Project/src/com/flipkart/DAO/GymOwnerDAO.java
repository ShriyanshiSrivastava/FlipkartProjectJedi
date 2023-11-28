package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.List;

public interface GymOwnerDAO {
    GymOwner getGymOwnerDetails(String gymOwnerId);
    List<Slot> viewAllSlots();
    int findCapacity(int gymId);
    boolean checkIfAlreadyBooked(int gymId);
    void addSlots(int gymId, String time, String date);
    void createSlot(Slot slot);
    List<GymCentre> viewAllGymCenters(String gymOwnerEmail);
    void addGym(GymCentre gymDetails);
    boolean isApproved(String email);
    boolean checkGymApproval(int gymId);

}
