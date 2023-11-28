
package com.flipkart.business;
import com.flipkart.bean.Slot;

import static com.flipkart.utils.ColorConstants.*;


public class SlotBooking {

    public boolean isAvailable(Slot slot) {
        System.out.println("Checking for avialiability");
        return true;
    }

    public boolean isWaiting() {
        System.out.println(ANSI_GREEN + "Slots Booked, redirecting to Waiting list" + ANSI_RESET);
        return true;
    }

    public boolean bookSlot(Slot slot, String date,int userId) {
        System.out.println(ANSI_GREEN + "Slot booked Successfully" + ANSI_RESET);
        return true;
    }

    public boolean cancelSlot(Slot slot, String date,int userId) {
        System.out.println(ANSI_RED + "Slot cancelled Successfully" + ANSI_RESET);
        return true;
    }
}