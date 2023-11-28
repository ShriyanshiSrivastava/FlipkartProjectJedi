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
//    @Path("login")
//    @POST
//    @Produces("application/json")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public static Response login(User user){
//        UserLogic authentication = new UserLogicImpl();
//        User user1 =authentication.authenticateUser(user);
//        if(user1 == null)
//        {
//            user1.setRoleId(5);
//            user1.setEmail("Wrong");
//            user1.setPassword("Wrong");
//        }
//        return Response.ok(user1).build();
//    }

    @Path("registeruser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerUser(User user){
        UserLogic userGMSService = new UserLogicImpl();
        userGMSService.registerUser(user);
    }

//    @Path("registercustomer")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void registerCustomer(Customer customer){
//        UserLogic userGMSService = new UserLogicImpl();
//        User user =new User(customer.getEmail(), customer.getPassword(), 1);
//        userGMSService.registerUser(user);
//        userGMSService.registerCustomer(customer);
//
//    }

    @Path("registergymowner")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerGymOwner(GymOwner gymOwner){
        UserLogic userGMSService = new UserLogicImpl();
        userGMSService.registerGymOwner(gymOwner);
    }
}
