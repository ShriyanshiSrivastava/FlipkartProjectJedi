
package com.flipkart.business;
import com.flipkart.bean.Slot;


public class SlotBooking {

    public boolean isAvailable(Slot slot) {
        System.out.println("Checking for avialiability");
        return true;
    }

    public boolean isWaiting() {
        System.out.println("Slots Booked, redirecting to Waiting list");
        return true;
    }

    public boolean bookSlot(Slot slot, String date,int userId) {
        System.out.println("Slot booked Successfully");
        return true;
    }

    public boolean cancelSlot(Slot slot, String date,int userId) {
        System.out.println("Slot cancelled Successfully");
        return true;
    }
}