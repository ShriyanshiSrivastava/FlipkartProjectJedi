package com.flipkart.DAO;

import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class SlotDAO
{
    List<Slot> slotsList = new ArrayList<>();

    public SlotDAO()
    {

        Slot s1 = new Slot();
        s1.setCustomerId(1);
        s1.setGymId("12");
        s1.setCentreId("34");
        s1.setTotalSlots(100);
        s1.setDate("10-12-23");
        s1.setTime("3-4");


        Slot s2 = new Slot();
        s2.setCustomerId(2);
        s2.setGymId("12");
        s2.setCentreId("34");
        s2.setTotalSlots(100);
        s2.setDate("10-11-23");
        s2.setTime("3-4");


        Slot s3 = new Slot();
        s3.setCustomerId(2);
        s3.setGymId("32");
        s3.setCentreId("34");
        s3.setTotalSlots(100);
        s3.setDate("10-12-23");
        s3.setTime("3-4");


        Slot s4 = new Slot();
        s4.setCustomerId(4);
        s4.setGymId("112");
        s4.setCentreId("34");
        s4.setTotalSlots(100);
        s4.setDate("10-12-23");
        s4.setTime("4-5");
        slotsList.add(s1);
        slotsList.add(s2);
        slotsList.add(s3);
        slotsList.add(s4);
    }
    public List<Slot> getSlotsList() {
        return slotsList;
    }

}