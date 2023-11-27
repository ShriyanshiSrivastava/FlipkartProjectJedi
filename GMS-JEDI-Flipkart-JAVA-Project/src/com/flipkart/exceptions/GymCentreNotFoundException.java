package com.flipkart.exceptions;

public class GymCentreNotFoundException extends Exception{
    public GymCentreNotFoundException(){
        System.out.println("Gym Centre not found");
    }
}
