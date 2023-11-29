package com.flipkart.rest;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.UserLogic;
import com.flipkart.business.UserLogicImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/authentication")
public class UserGMSRESTService {
    @Path("registerCustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerCustomer(Customer customer){
        UserLogic userGMSService = new UserLogicImpl();
        User user =new User(customer.getEmail(), customer.getPassword(), 1);
        userGMSService.registerUser(user);
        userGMSService.registerCustomer(customer);

    }

    @Path("registerGymOwner")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerGymOwner(GymOwner gymOwner){
        UserLogic userGMSService = new UserLogicImpl();
        userGMSService.registerGymOwner(gymOwner);
    }
}
