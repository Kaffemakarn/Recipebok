package edu.chl.recipebok.control;

import java.io.Serializable;
import static java.lang.System.out;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.utils.FacesMessages;
import edu.chl.recipebok.core.Rating;
import edu.chl.recipebok.dao.RatingCatalogue;
import edu.chl.recipebok.util.ExceptionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.dataTable.DataTable;
import net.bootsfaces.component.form.Form;

/**
 *
 * @author Sabrina
 */
@Named("rating")
//@RequestScoped
@SessionScoped
public class RatingBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(RatingBean.class.getName());
    @EJB
    private RatingCatalogue rcat;
    @Getter
    @Setter
    private Rating tmpRating = new Rating();
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
        
        //TODO needs to be changed - what do we actually do with stuff?
        DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("authorForm:authorTable");
        
        LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents()); //) +  );
    }
    // ------------ Navigation -------------------

    public void cancel() {
        tmpRating = new Rating();
    }

    // --------- Call backend -------------------------
    public void setRating() {
        tmpRating = rcat.findByUserAndRecipe(tmpRating.getUserId(), tmpRating.getRecipeId());
    }

    public List<Rating> findAll() {
        return rcat.findAll();
        
    }

    public void add() {
        try {
            rcat.create(tmpRating);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        tmpRating = new Rating();
    }

    public void update() {
        rcat.update(tmpRating);
        tmpRating = new Rating();
    }

    public void delete() {
        rcat.delete(tmpRating.getUserId(), tmpRating.getRecipeId());
        tmpRating = new Rating();
    }

}
