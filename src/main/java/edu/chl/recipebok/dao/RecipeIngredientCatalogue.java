/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.QIngredient;
import edu.chl.recipebok.core.QRecipeIngredient;
import edu.chl.recipebok.core.RecipeIngredient;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mickaela
 */
@Stateless
public class RecipeIngredientCatalogue extends AbstractQuery<RecipeIngredient, String> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public RecipeIngredientCatalogue() {
        // author is default object created by QueryDSL, see Generated Sources
        super(RecipeIngredient.class, QRecipeIngredient.recipeIngredient);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<RecipeIngredient> findByName(String name) {
        QRecipeIngredient recipeIngredient = QRecipeIngredient.recipeIngredient;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<RecipeIngredient> found = qf.select(recipeIngredient)
                .from(recipeIngredient)
                .where(recipeIngredient.ingredientName.eq(name))
                .fetch();
        out.println(found);
        return found;
    }
    
    public List<RecipeIngredient> findByRecipeId(String recipeId) {
        QRecipeIngredient recipeIngredient = QRecipeIngredient.recipeIngredient;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<RecipeIngredient> found = qf.select(recipeIngredient)
                .from(recipeIngredient)
                .where(recipeIngredient.recipeId.eq(recipeId))
                .fetch();
        out.println(found);
        return found;
    }
    
}
