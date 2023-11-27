package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface CustomerDAO {
    List<GymCentre> fetchGymList();
    public void fetchSlotList(int gymId);
    public void bookSlots(int gymId, String slotId,String email,String date);
    public boolean isFull(String slotId,String date);
    public void fetchBookedSlots(String email);
    public void cancelBooking(String slotId, String email, String date);
    public boolean alreadyBooked(String slotId, String email, String date);
    public boolean checkSlotExists(String slotId, int gymId);
    public void cancelBookedSlots(int bookingId);
    public boolean checkGymApprove(int gymId);
}
