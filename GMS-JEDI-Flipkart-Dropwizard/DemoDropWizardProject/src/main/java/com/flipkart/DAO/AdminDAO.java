package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminDAO {
    List<GymCentre> seeAllGyms();
    List<GymOwner> seeAllGymOwner();
    List<GymCentre> seePendingGymRequest();
    void approveSingleOwnerRequest(String email);
    void approveSingleGymRequest(int gymId);
}
