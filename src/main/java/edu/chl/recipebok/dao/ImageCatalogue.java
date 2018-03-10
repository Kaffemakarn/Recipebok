package edu.chl.recipebok.dao;

import edu.chl.recipebok.core.Image;
import edu.chl.recipebok.core.QImage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author August
 */
@Stateless
public class ImageCatalogue extends AbstractQuery<Image, Long> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public ImageCatalogue() {
        super(Image.class, QImage.image);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}