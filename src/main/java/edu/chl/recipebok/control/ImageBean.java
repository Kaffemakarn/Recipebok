package edu.chl.recipebok.control;

import edu.chl.recipebok.core.Image;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.UserPerson;
import edu.chl.recipebok.dao.ImageCatalogue;
import edu.chl.recipebok.dao.RecipeImageCatalogue;
import edu.chl.recipebok.dao.UserImageCatalogue;
import edu.chl.recipebok.util.ExceptionHandler;
import java.io.Serializable;
import static java.lang.System.out;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.*;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author August
 */
@Named("imagebean")
@RequestScoped
public class ImageBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(ImageBean.class.getName());
    
    @EJB
    private ImageCatalogue imcat;
    @EJB
    private RecipeImageCatalogue ricat;
    @EJB
    private UserImageCatalogue uicat;
       
    @Getter
    @Setter
    private Image tmp = new Image();
    //private final int start = 0;
    //private int nRecords = 50;

    @Getter
    @Setter
    private Form form;

    @PostConstruct
    void post() {
        out.println(this + "Alive");
    }

    // ------------ Navigation -------------------

    public void cancel() {
        tmp = new Image();
    }

    // --------- Call backend -------------------------
    public void setImage() {
        tmp = imcat.find(tmp.getId());
    }

    public List<Image> findAll() {
        return imcat.findAll();
    }

    public void add() {
        //tmp.setAddress(DataSupplier.getRandomAddress());
        
        try {
            imcat.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        tmp = new Image();

    }

    public void update() {
        imcat.update(tmp);
        tmp = new Image();
    }

    public void delete() {
        imcat.delete(tmp.getId());
        tmp = new Image();
    }
    
    // TODO why error msgs? Seems to work anyway...
    
    public Image findByRecipe(Recipe recipe) {
        return ricat.findByRecipe(recipe);
    }
   
    public Image findByUser(UserPerson user) {
        return uicat.findByUser(user);
    }

}
