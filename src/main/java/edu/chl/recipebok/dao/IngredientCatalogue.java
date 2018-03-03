package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.RecipeIngredient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sabrina
 */
public class IngredientCatalogue extends AbstractQuery<Ingredient, String> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public IngredientCatalogue() {
        // cookbook is default object created by QueryDSL, see Generated Sources
        super(Ingredient.class, QIngredient.ingredient);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    // This method should find an ingredient by name   
    /*public List<Ingredient> findByName(String name) {
        QIngredient ingredient = QIngredient.ingredient;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Ingredient> found = qf.select(ingredient) 
                .from(ingredient)
                .where(ingredient.name.eq(name))
                .fetch();
        System.out.println(found);
        return found;
    }*/
    
    //This method should collect all ingredients in a recipe
    /*public List<Ingredient> findByRecipe(String recipeId) {
        QIngredient ingredient = QIngredient.ingredient;
        QRecipeIngredient recipeIngredient = QRecipeIngredient.recipeIngredient; //TODO I don't know if this works of if we need to create something somewhere
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Ingredient> found = qf.select(ingredient) 
                .from(ingredient)
                .where(exists_expression(qf.select(recipeIngredient)
                    .from(recipeIngredient)
                    .where(recipeIngredient.recipeId.eq(recipeId))))
                .fetch();
        System.out.println(found);
        return found;
    }*/
    
    
    
    
}
