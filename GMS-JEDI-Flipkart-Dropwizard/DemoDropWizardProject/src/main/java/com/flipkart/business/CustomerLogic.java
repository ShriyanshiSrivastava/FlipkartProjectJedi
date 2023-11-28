package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.exceptions.GymCentreNotFoundException;
import com.flipkart.exceptions.SlotNotFoundException;

import java.util.List;

public interface CustomerLogic {
    List<GymCentre> fetchGymList();
    boolean fetchAvailableSlots(int gymId);
    int bookSlots(int gymId, String slotId, String email, String date);
    boolean alreadyBooked(String slotId, String email, String date);
    boolean isFull(String slotId, String date);
    void fetchBookedSlots(String email);
    boolean checkSlotExists(String slotId, int gymId);
    void cancelBookedSlots(int bookingId);
    boolean checkGymApprove(int gymId);
}
