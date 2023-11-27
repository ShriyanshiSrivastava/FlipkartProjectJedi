package com.flipkart.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(){
        System.out.println("User was not found");
    }
}
