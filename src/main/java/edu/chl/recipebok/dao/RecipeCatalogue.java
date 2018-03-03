/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Recipe;
import static java.lang.System.out;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mickaela
 */
public class RecipeCatalogue extends AbstractQuery<Recipe, String> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public RecipeCatalogue() {
        // author is default object created by QueryDSL, see Generated Sources
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

    public List<Recipe> findByName(String name) {
        QRecipe recipe = QRecipe.recipe;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Recipe> found = qf.select(recipe)
                .from(recipe)
                .where(recipe.firstName.eq(name))
                .fetch();
        out.println(found);
        return found;
    }
    
}
