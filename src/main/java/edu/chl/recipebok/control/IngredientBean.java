/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;
import edu.chl.recipebok.core.Cookbook;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.dao.IngredientCatalogue;
import edu.chl.recipebok.dao.RecipeCatalogue;
import java.io.Serializable;
import static java.lang.System.out;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
//@RequestScoped
@SessionScoped

public class IngredientBean implements Serializable{
 private static final Logger LOG = Logger.getLogger(CookbookBean.class.getName());
    @EJB
    private IngredientCatalogue ibCat;
    @Getter
    @Setter
    private Cookbook tmp = new Cookbook();
    private final int start = 0;
    private int nRecords = 50;

    @Getter
    @Setter
    private Form form;
   
    
    
    
}
