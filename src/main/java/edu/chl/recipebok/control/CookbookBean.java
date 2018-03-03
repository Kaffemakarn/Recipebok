/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;
import edu.chl.recipebok.core.Cookbook;
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
 * @author rahadadgar
 */
@Named("cookbookbean")
//@RequestScoped
@SessionScoped
public class CookbookBean implements Serializable {
    
     private static final Logger LOG = Logger.getLogger(CookbookBean.class.getName());
    @EJB
    private CookBookCatalogue cbCat;
    @Getter
    @Setter
    private Cookbook tmp = new Cookbook();
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
        /*Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        for( Entry<String, String> e : map.entrySet()){
        LOG.log(Level.INFO, "Key " + e.getKey() + " val " + e.getValue() );
        }*/
       DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("cookbookForm:cookbookTable");
       
       LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents()); //) +  );
    }   
  
  
   // ------------ Navigation -------------------

    public void cancel() {
        tmp = new Cookbook();
    }
    
      // --------- Call backend -------------------------
    public void setCookbook() {
       tmp = cbCat.find(tmp.getId());
    }

     public List<Cookbook> findAll() {
        return cbCat.findAll();
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
        cbCat.update(tmp);
        tmp = new Cookbook();
    }

     public void delete() {
        cbCat.delete(tmp.getId());
        tmp = new Cookbook();
    }
}

