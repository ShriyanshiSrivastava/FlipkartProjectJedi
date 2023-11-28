package com.flipkart.DAO;

import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class SlotDAOImpl implements SlotDAO
{
    List<Slot> slotsList = new ArrayList<>();

    public List<Slot> getSlotsList() {
        return slotsList;
    }

}