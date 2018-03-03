package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.QRecipe;
import edu.chl.recipebok.core.Recipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.lang.System.out;

/**
 *
 * @author August
 */


@Stateless
public class RecipeCatalogue extends AbstractQuery<Recipe, String> {

    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public RecipeCatalogue() {
        // cookbook is default object created by QueryDSL, see Generated Sources
        super(Recipe.class, QRecipe.recipe);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<Recipe> findByUser(String user) {
        QRecipe recipe = QRecipe.recipe;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Recipe> found = qf.select(recipe)
                .from(recipe)
                .where(recipe.creator.eq(user))
                .fetch();
        out.println(found);
        return found;
    }
    
    public Recipe findByUserAndName(String user, String name) {
        QRecipe recipe = QRecipe.recipe;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Recipe> foundList = qf.select(recipe)
                .from(recipe)
                .where(recipe.creator.eq(user).and(recipe.name.eq(name)))
                .fetch();
        Recipe found = foundList.get(0);
        out.println(found);
        return found;
    }
        
}

