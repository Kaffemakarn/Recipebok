/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;

import edu.chl.recipebok.core.Recipe;
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
 *
 * @author Mickaela
 */
@Named("recipebean")
//@RequestScoped
@SessionScoped
public class RecipeBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(RecipeBean.class.getName());
    @EJB
    private RecipeCatalogue rcat;
    @Getter
    @Setter
    private Recipe tmp = new Recipe();
    private final int start = 0;
    private int nRecords = 50;

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
        tmp = new Recipe();
    }

    // --------- Call backend -------------------------
    public void setAuthor() {
        tmp = rcat.find(tmp.getId());
    }

    public List<Recipe> findAll() {
        return rcat.findAll();
    }

    public void add() {
        /*tmp.setAddress(DataSupplier.getRandomAddress());
        try {
            rcat.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        tmp = new Recipe();*/
    }

    public void update() {
        rcat.update(tmp);
        tmp = new Recipe();
    }

    public void delete() {
        rcat.delete(tmp.getId());
        tmp = new Recipe();
    }

}

