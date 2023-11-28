
package com.flipkart.business;

import static com.flipkart.utils.ColorConstants.ANSI_RED;
import static com.flipkart.utils.ColorConstants.ANSI_RESET;

public class PaymentBusiness {

    public void makePayment() {
        System.out.println(ANSI_RED + "Payment is Successful" + ANSI_RESET);
    }
}