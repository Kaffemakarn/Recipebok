/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.QCookbookRecipe;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.CookbookRecipe;
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
public class CookbookRecipeCatalogue extends AbstractQuery<CookbookRecipe, String> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public CookbookRecipeCatalogue() {
        // author is default object created by QueryDSL, see Generated Sources
        super(CookbookRecipe.class, QCookbookRecipe.cookbookRecipe);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<CookbookRecipe> findByRecipe(Recipe recipe) {
        QCookbookRecipe cookbookRecipe = QCookbookRecipe.cookbookRecipe;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<CookbookRecipe> found = qf.select(cookbookRecipe)
                .from(cookbookRecipe)
                .where(cookbookRecipe.recipe.eq(recipe))
                .fetch();
        out.println(found);
        return found;
    }
    
}