package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Cookbook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sabrina
 */
public class CookbookCatalogue extends AbstractQuery<Cookbook, String> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public CookbookCatalogue() {
        // cookbook is default object created by QueryDSL, see Generated Sources
        super(Cookbook.class, QCookbook.cookbook);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    // This method should collect all cookbooks that belong to a certain user
    /*
    public List<Cookbook> findByUsername(String username) {
        QCookbook cookbook = QCookbook.cookbook;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Cookbook> found = qf.select(cookbook) 
                .from(cookbook)
                .where(cookbook.username.eq(username))
                .fetch();
        System.out.println(found);
        return found;
    }*/
    
    
}
