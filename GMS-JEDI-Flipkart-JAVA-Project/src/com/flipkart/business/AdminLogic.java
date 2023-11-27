package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminLogic {
    List<GymOwner> viewAllGymOwners();
    List<GymCentre> viewAllGyms();
    List<GymOwner> viewPendingGymOwnerRequests();
    List<GymCentre> viewPendingGymRequests();
    void approveGymOwnerRequest(String email);
    void approveGymRequest(int gymId);
}
