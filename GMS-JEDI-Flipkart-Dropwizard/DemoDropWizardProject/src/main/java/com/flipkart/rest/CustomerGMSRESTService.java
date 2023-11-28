package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.flipkart.business.CustomerLogic;
import com.flipkart.business.CustomerLogicImpl;

@Path("/v1/customer")
public class CustomerGMSRESTService {
    @Path("allgyms")
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

    @Path("allslots")
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

//    @Path("cancelbooking")
//    @DELETE
//    @Produces("application/json")
//    public static Response cancelBooking(@QueryParam("bookingId") int bookingId){
//
//        CustomerLogic customerService = new CustomerLogicImpl();
//        try{
//            return Response.ok(customerService.cancelBookedSlots(bookingId)).build();
//        }
//        catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//    }

    @Path("createbooking")
    @POST
    @Produces("application/json")
    public static Response createBooking(@QueryParam("gymId") int gymId, @QueryParam("slotId") String slotId, @QueryParam("email") String email, @QueryParam("date") String date){
        CustomerLogic customerGMSDao = new CustomerLogicImpl();
        try{
            return Response.ok(customerGMSDao.bookSlots(gymId,slotId,email,date)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

//    @Path("mybookings")
//    @GET
//    @Produces("application/json")
//    public static Response getBookings(@QueryParam("email") String email){
//        CustomerLogic customerGMSDao = new CustomerLogicImpl();
//        try{
//            return Response.ok(customerGMSDao.fetchBookedSlots(email)).build();
//        }
//        catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//    }

    @Path("bookslots")
    @POST
    @Produces("application/json")
    public static Response bookGymSlots(@QueryParam("gymId") int gymId, @QueryParam("slotId") String slotId, @QueryParam("email") String email, @QueryParam("date") String date) {
        CustomerLogic customerGMSService = new CustomerLogicImpl();
        try {
            return Response.ok(customerGMSService.bookSlots(gymId, slotId, email, date)).build();
        } catch (Exception exception) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}
