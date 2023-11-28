package com.flipkart.rest;

import com.flipkart.business.GymOwnerLogic;
import com.flipkart.business.GymOwnerLogicImpl;
import com.flipkart.exceptions.GymOwnerNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/gyms")
public class GymOwnerGMSRESTService {
    @Path("gyminfo")
    @GET
    @Produces("application/json")
    public static Response viewAllGymCenters(@QueryParam("email") String email) {
        GymOwnerLogic gymOwnerService = new GymOwnerLogicImpl();
        try {
            return Response.ok(gymOwnerService.viewAllGymCenters(email)).build();
        } catch (Exception exception) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}
