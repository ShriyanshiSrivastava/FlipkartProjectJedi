package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.flipkart.business.CustomerLogic;
import com.flipkart.business.CustomerLogicImpl;

@Path("/v1/customer")
public class CustomerGMSRESTService {
    @Path("viewAllGymCentres")
    @GET
    @Produces("application/json")
    public static Response fetchAllGyms(){
        CustomerLogic customerService = new CustomerLogicImpl();
        try{
            return Response.ok(customerService.fetchGymList()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("viewAllSlots")
    @GET
    @Produces("application/json")
    public static Response fetchAllSlots(@QueryParam("gymId") int gymId){
        CustomerLogic customerService = new CustomerLogicImpl();
        try{
            return Response.ok(customerService.fetchAvailableSlots(gymId)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("bookNewSlot")
    @POST
    @Produces("application/json")
    public static Response createBooking(@QueryParam("gymId") int gymId, @QueryParam("slotId") String slotId, @QueryParam("email") String email, @QueryParam("date") String date){
        CustomerLogic customerGMSDao = new CustomerLogicImpl();
        try{
            System.out.println(gymId);
            System.out.println(slotId);
            System.out.println(email);
            System.out.println(date);
            return Response.ok(customerGMSDao.bookSlots(gymId,slotId,email,date)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}
