package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Role;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    List<Customer> customerList = new ArrayList<Customer>();

    public CustomerDAO() {
        Customer c1 = new Customer();
        c1.setName("Iram Khalid");
        c1.setPassword("121");
        c1.setId(1);
        c1.setCardNumber(123132123);
        c1.setAddress("address1");
        c1.setCvv(190);
        c1.setEmail("iram@flipfit.com");

        Customer c2 = new Customer();
        c2.setName("XYZ");
        c2.setPassword("123");
        c2.setId(2);
        c2.setCardNumber(1231321223);
        c2.setAddress("address2");
        c2.setCvv(190);
        c2.setEmail("xyz@flipfit.com");

        Customer c3 = new Customer();
        c3.setName("ABS");
        c3.setPassword("121");
        c3.setId(3);
        c3.setCardNumber(311232123);
        c3.setAddress("address3");
        c3.setCvv(210);
        c3.setEmail("abs@flipfit.com");

        Customer c4 = new Customer();
        c4.setName("MNS");
        c4.setPassword("121");
        c4.setId(4);
        c4.setCardNumber(524242123);
        c4.setAddress("address4");
        c4.setCvv(521);
        c4.setEmail("MNS@flipfit.com");


        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        customerList.add(c4);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}