package com.flipkart.exceptions;

public class GymOwnerNotFoundException extends Throwable {
    public GymOwnerNotFoundException(){
        System.out.println("Gym Owner not found");
    }
}
