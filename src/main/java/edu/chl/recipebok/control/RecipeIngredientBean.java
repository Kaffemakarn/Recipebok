/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;


import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.RecipeIngredient;
import edu.chl.recipebok.dao.IngredientCatalogue;
import edu.chl.recipebok.dao.RecipeCatalogue;
import edu.chl.recipebok.dao.RecipeIngredientCatalogue;
import edu.chl.recipebok.util.ExceptionHandler;
import java.io.Serializable;
import static java.lang.System.out;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.*;
import net.bootsfaces.component.button.Button;
import net.bootsfaces.component.dataTable.DataTable;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author Mickaela
 */
@Named("ribean")
@RequestScoped
//@SessionScoped
public class RecipeIngredientBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(RecipeBean.class.getName());
    @EJB
    private RecipeCatalogue rcat;
    @EJB
    private RecipeIngredientCatalogue ricat;
    @EJB
    private IngredientCatalogue icat;
    
    @Getter
    @Setter
    private RecipeIngredient tmp = new RecipeIngredient();
    private final int start = 0;
    private int nRecords = 50;
    
    @Getter
    @Setter
    private String ingredientname = "";
    
    @Getter
    @Setter
    private String recipeid = "";

    @Getter
    @Setter
    private Form form;

    @PostConstruct
    void post() {
        out.println(this + "Alive");
    }

    public void page() {
       
        DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("recipeTable");
        
        LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents()); //) +  );
    }
    // ------------ Navigation -------------------

    public void cancel() {
        tmp = new RecipeIngredient();
    }

    // --------- Call backend -------------------------
    public void setRI() {
        tmp = ricat.find(tmp.getId());
    }

    public List<RecipeIngredient> findAll() {
        return ricat.findAll();
    }

    public void add() {
        
        
        tmp.setIngredient(icat.find(ingredientname));
        tmp.setRecipe(rcat.find(recipeid));
        
        try {
            ricat.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        tmp = new RecipeIngredient();

    }

    public void update() {
        ricat.update(tmp);
        tmp = new RecipeIngredient();
    }

    public void delete() {
        ricat.delete(tmp.getId());
        tmp = new RecipeIngredient();
    }
    
    
    public List<RecipeIngredient> findRecipeIngredients(Recipe recipe){
        return ricat.findByRecipe(recipe);
    }
    
}
