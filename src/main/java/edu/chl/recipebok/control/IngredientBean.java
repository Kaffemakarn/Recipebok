/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;
import edu.chl.recipebok.core.Cookbook;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.dao.IngredientCatalogue;
import edu.chl.recipebok.util.ExceptionHandler;
import java.io.Serializable;
import static java.lang.System.out;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.*;
import net.bootsfaces.component.dataTable.DataTable;
import net.bootsfaces.utils.FacesMessages;
/**
/**
 *
 * @author rahadadgar
 */
@Named("ingredientbean")
@RequestScoped
//@SessionScoped

public class IngredientBean implements Serializable{

    private static final Logger LOG = Logger.getLogger(IngredientBean.class.getName());
    
    @EJB
    private IngredientCatalogue ingredientCat;
    @Getter
    @Setter
    private Ingredient tmp = new Ingredient();
    private final int start = 0;
    private int nRecords = 50;

    @Getter
    @Setter
    private Form form;
   
      public void page() {
        /*Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        for( Entry<String, String> e : map.entrySet()){
        LOG.log(Level.INFO, "Key " + e.getKey() + " val " + e.getValue() );
        }*/
       //DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("authorForm:authorTable");
       
       //LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents()); //) +  );
    }
      
       // ------------ Navigation -------------------

    public void cancel() {
        tmp = new Ingredient();
    }
    
  // --------- Call backend -------------------------
    public void setIngredient() {
        tmp = (Ingredient) ingredientCat.findByName(tmp.getName());
    }

   
     public void add() {
        try {
            ingredientCat.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        tmp = new Ingredient();
    }

    public void update() {
        ingredientCat.update(tmp);
        tmp = new Ingredient();
    }
    
           // Find a ingredient by name
    public List<Ingredient> findByName(String name) {
        return ingredientCat.findByName(name);
        
    }
}
