/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Image;
import edu.chl.recipebok.core.QCookbook;
import edu.chl.recipebok.core.QImage;
import edu.chl.recipebok.core.QRecipe;
import edu.chl.recipebok.core.RecipeImage;
import edu.chl.recipebok.core.QRecipeImage;
import edu.chl.recipebok.core.Recipe;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author August
 */
@Stateless
public class RecipeImageCatalogue extends AbstractQuery<RecipeImage, Long> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public RecipeImageCatalogue() {
        // ingredient is default object created by QueryDSL, see Generated Sources
        super(RecipeImage.class, QRecipeImage.recipeImage);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public Image findByRecipe(Recipe recipe) {
        QRecipeImage recipeImage = QRecipeImage.recipeImage;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Image> foundList = qf.select(recipeImage.image)
                .from(recipeImage)
                .where(recipeImage.recipe.eq(recipe))
                .fetch();
        Image found = foundList.get(0);
        out.println(found);
        return found;
    }
}