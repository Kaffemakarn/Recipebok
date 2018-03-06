package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.QRating;
import edu.chl.recipebok.core.Rating;
import edu.chl.recipebok.core.RatingPK;
import static java.lang.System.out;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sabrina
 */
public class RatingCatalogue extends AbstractQuery<Rating, String> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public RatingCatalogue() {
        // ingredient is default object created by QueryDSL, see Generated Sources
        super(Rating.class, QRating.rating);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<Rating> findByRecipe(String recipeId) {
        QRating rating = QRating.rating;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Rating> found = qf.select(rating)
                .from(rating)
                .where(rating.recipeId.eq(recipeId))
                .fetch();
        out.println(found);
        return found;
    }
    
    public Rating findByUserAndRecipe(String userId, String recipeId){
        /*QRating rating = QRating.rating;
        JPAQueryFactory qf = new JPAQueryFactory(em);*/
        //TODO test this *shrug*
        RatingPK id = new RatingPK(userId, recipeId);
        
        Rating found = em.find(Rating.class, id);
       
        return found;
    }
    
    //TODO don't know if works, as above
    public void delete(String userId, String recipeId) {
        RatingPK id = new RatingPK(userId, recipeId);
        em.remove(id);
    }
    
}
