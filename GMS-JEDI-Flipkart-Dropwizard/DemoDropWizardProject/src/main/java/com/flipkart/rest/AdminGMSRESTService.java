package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;

import com.flipkart.business.AdminLogic;
import com.flipkart.business.AdminLogicImpl;

@Path("/v1/admin")
public class AdminGMSRESTService {
    @Path("viewAllGyms")
    @GET
    @Produces("application/json")
    public static Response viewAllGyms(){
        AdminLogic adminSer = new AdminLogicImpl();
        try{
            return Response.ok(adminSer.viewAllGyms()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("viewAllGymOwners")
    @GET
    @Produces("application/json")
    public static Response viewAllGymOwners(){
        AdminLogic adminSer = new AdminLogicImpl();
        try{
            return Response.ok(adminSer.viewAllGymOwners()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("viewPendingGymOwnerRequests")
    @GET
    @Produces("application/json")
    public static Response viewPendingGymOwnerRequests(){
        AdminLogic adminSer = new AdminLogicImpl();
        try{
            return Response.ok(adminSer.viewPendingGymOwnerRequests()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("seependinggym")
    @GET
    @Produces("application/json")
    public static Response viewPendingGymRequests(){
        AdminLogic adminSer = new AdminLogicImpl();
        try{
            return Response.ok(adminSer.viewPendingGymRequests()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("approveGymOwnerRequest")
    @PUT
    public static String approveGymOwnerRequest(@QueryParam("email") String email){
//        System.out.println("Email is:"+email);
        try {
            AdminLogic adminSer = new AdminLogicImpl();
            adminSer.approveGymOwnerRequest(email);
            return "Approved!";
        }catch(Exception exception){
            return exception.getMessage();
        }
    }

    @Path("approveGymRequest")
    @PUT
    public static String approveGymRequest(@QueryParam("gymId") int gymId){
//        System.out.println("Email is:"+email);
        try{
            AdminLogic adminSer = new AdminLogicImpl();
            adminSer.approveGymRequest(gymId);
            return "Approved!";
        }catch(Exception exception){
            return  exception.getMessage();
        }
    }
}
