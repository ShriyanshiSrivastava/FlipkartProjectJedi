package com.flipkart.bean;

public class BookedSlot {

    private String slotId;
    private String gymId;
    private String customerEmail;
    private String date;


    private int bookingId;
    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    public String getSlotId() {
        return slotId;
    }
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }
    public String getGymId() {
        return gymId;
    }
    public void setGymId(String gymId) {
        this.gymId = gymId;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

}