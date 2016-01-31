/**
 * 
 */
package com.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.test.entity.Country;
import com.test.service.LocationService;

/**
 * @author Debashish Mitra
 *
 */
@Controller
@Path("/")
public class LocationController {
    
    @Resource(name="locationService")
    private LocationService locationService;
    
   @Path("/getAllCountries")
   @GET
   @Produces({ MediaType.APPLICATION_JSON})
    public Response getAllCountries() {
	List<Country> countries = locationService.getAllCountries();
	return Response.ok().entity(countries).build();
    }
}
