package edu.chl.recipebok.rest;


import com.google.gson.Gson;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.dao.RecipeCatalogue;
import static java.lang.System.out;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Sabrina
 */
@Path("recipes")
public class RecipeResource {

    private static final Logger LOG = Logger.getLogger(RecipeResource.class.getName());

    @Context
    private UriInfo uriInfo;

    @EJB
    private RecipeCatalogue rcat;
    private final Gson gson = new Gson(); //TODO fix Gson I guess?

    // Provides access to application and request URI information. 
    // Relative URIs are relative to the base URI of the application
    @GET
    @Path("{id : [AZaz]+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") String id) {
        Recipe p = rcat.find(id);
        if (p != null) {
            return Response.ok(gson.toJson(p)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); 
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        out.println("*** findAll");
        List<Recipe> recipes = rcat.findAll();
        out.println(recipes);
        return Response.ok(gson.toJson(recipes)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Path("count")
    public Response count() {
        int count = rcat.count();
        return Response.ok(gson.toJson(count)).build();
    }

    /* TODO @GET
    @Path("range")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findRange(@QueryParam("fst") int firstResult,
            @QueryParam("max") int n) {
        List<TodoNote> notes = list.getNotes();
       
        return Response.ok(gson.toJson(notes)).build();
    }*/
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response create(@FormParam("id") String id, @FormParam("name") String name,
            @FormParam("creator") String creator, @FormParam("creationTime") String creationTime) {
        Recipe recipe = new Recipe(id, name, creator, creationTime);
        rcat.create(recipe);
        
        //TODO also need to create RecipeCategoys, RecipeIngredients
        //based on input in some way
        
        //This probalby puts the recipe at the url /recipeId ?
        URI authorUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(recipe.getId()))
                .build(recipe);
        // Set it to 201 (created) and setting response header 'Location'
        // Inspect with cURL
        return Response.created(authorUri).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Recipe recipe) {
        rcat.create(recipe);
        URI recipeUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(recipe.getId()))
                .build(recipe);
        // Set it to 201 (created) and setting response header 'Location'
        // Inspect with cURL
        return Response.created(recipeUri).build();
    }

    @DELETE
    @Path("{id: [AZaz]+}")
    public Response delete(@PathParam("id") String id) {
        // A successful response SHOULD be 200 (OK) if the response 
        // includes an entity describing the status, 202 (Accepted) if 
        // the action has not yet been enacted, or 204 (No Content) if 
        // the action has been enacted but the response does not 
        // include an entity.
        rcat.delete(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("{id: [AZaz]+}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response update(@FormParam("id") String id, @FormParam("name") String name,
            @FormParam("creator") String creator, @FormParam("creationTime") String creationTime) {
        Recipe recipe = rcat.find(id);
        if (recipe != null) {
            recipe.setName(name);
            
            rcat.update(recipe);
            //If an existing resource is modified, either the 200 (OK) or 204 
            //(No Content) response codes SHOULD be sent to indicate 
            //successful completion of the request.
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{id: [AZaz]+}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Recipe recipe) {
        Recipe r = rcat.find(recipe.getId());
        if (r != null) {
            r.setName(recipe.getName());
            
            rcat.update(recipe);
            //If an existing resource is modified, either the 200 (OK) or 204 
            //(No Content) response codes SHOULD be sent to indicate 
            //successful completion of the request.
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
