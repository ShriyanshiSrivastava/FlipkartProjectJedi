package com.flipkart.exceptions;

import static com.flipkart.utils.ColorConstants.ANSI_RED;
import static com.flipkart.utils.ColorConstants.ANSI_RESET;

public class GymCentreNotFoundException extends Exception{
    public GymCentreNotFoundException(){
        System.out.println(ANSI_RED + "Gym Centre not found" + ANSI_RESET);
    }
}
