/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;

import edu.chl.recipebok.core.Cookbook;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.RecipeIngredient;
import edu.chl.recipebok.core.UserPerson;
import edu.chl.recipebok.dao.RecipeCatalogue;
import edu.chl.recipebok.dao.RecipeIngredientCatalogue;
import edu.chl.recipebok.dao.UserCatalogue;
import edu.chl.recipebok.util.ExceptionHandler;
import java.io.Serializable;
import static java.lang.System.out;
import java.text.Normalizer.Form;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
//import javax.faces.bean.SessionScoped;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.*;
import net.bootsfaces.component.dataTable.DataTable;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author Mickaela
 */
@Named("recipebean")
@RequestScoped
//@SessionScoped
public class RecipeBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(RecipeBean.class.getName());
    @EJB
    private RecipeCatalogue rcat;
    @EJB
    private RecipeIngredientCatalogue ricat;
    @EJB
    private UserCatalogue ucat;
    @Getter
    @Setter
    private Recipe tmp = new Recipe();
    private final int start = 0;
    private int nRecords = 50;
    
    @Getter
    @Setter
    private String useremail = "";
    
    @Getter
    @Setter
    private boolean showingredients = false;

    @Getter
    @Setter
    private Form form;

    @PostConstruct
    void post() {
        out.println(this + "Alive");
    }

    public void page() {
        //FacesContext.
        //DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("recipeTable");
       
        //Container c = (Container) FacesContext.getCurrentInstance().getViewRoot().findComponent("recipeview");
       
        //LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents()); //) +  );
    }
    // ------------ Navigation -------------------

    public void cancel() {
        tmp = new Recipe();
    }

    // --------- Call backend -------------------------
    public void setRecipe() {
        tmp = rcat.find(tmp.getId());
    }

    public List<Recipe> findAll() {
        return rcat.findAll();
    }

    public void add() {
        
        tmp.setCreationTime(new Date().toString());
        
        this.setCreatorByEmail();
        
        //tmp.setId(Integer.toString(120));
        //tmp.setCreator(ucat.find("Sabrina@mail"));
        
        try {
            rcat.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        //tmp = new Recipe();

    }

    public void update() {
        rcat.update(tmp);
        tmp = new Recipe();
    }

    public void delete() {
        rcat.delete(tmp.getId());
        tmp = new Recipe();
    }
    
    
    public void setCreatorByEmail(){
        tmp.setCreator(ucat.findByUserMail(useremail));
    }
    
    // Find recipes by user
    public List<Recipe> findByUser(UserPerson user) {
        return rcat.findByUser(user);
    }
    
    // Find recipes by recipe name
    public List<Recipe> findByName(String name) {
        return rcat.findByName(name);
    }
    
      // Find a recipe by user and recipe name
    public Recipe findByUserAndName(UserPerson user, String name) {
        return rcat.findByUserAndName(user, name);
    }

    // Find Recipes by Cookbook
    public List<Recipe> findByCookbook(Cookbook cookbookId) {
        return rcat.findByCookbook(cookbookId);
    }

    
    // Find Recipes that use the specified ingredient. 
    public List<Recipe> findByIngredient(Ingredient ingredient) {
        return rcat.findByIngredient(ingredient);
    }
    
    public void toggle(){
        showingredients = !showingredients;
    }
    
    public boolean showingredients(){
        return this.showingredients;
    }    
    
    // Find Recipes that use all the specified ingredients
    public List<Recipe> findByIngredients(List<Ingredient> ingredients) {
        return rcat.findByIngredients(ingredients);
    }
    
    
    
    public List<RecipeIngredient> findRecipeIngredients(Recipe recipe){
        return null;
        //return ricat.findByRecipe(recipe);
    }
    
}
