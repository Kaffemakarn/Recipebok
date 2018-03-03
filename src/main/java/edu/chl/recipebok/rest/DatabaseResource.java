package edu.chl.recipebok.rest;


import com.google.gson.Gson;
import edu.chl.recipebok.dao.RecipeCatalogue;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author hajo
 */
@Path("db")
public class DatabaseResource {

    @EJB
    private RecipeCatalogue rcat;
    
    private final Gson gson = new Gson();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response recreateDatabase() {
        //TODO use this if we wanna have a datasupplier
        
        return Response.ok(gson.toJson("Database recreated")).build();
    }

}
