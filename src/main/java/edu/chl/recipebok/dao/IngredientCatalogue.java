package edu.chl.recipebok.dao;


import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.QIngredient;
import edu.chl.recipebok.core.QRecipeIngredient;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.RecipeIngredient;
import java.util.ArrayList;

/**
 * DAO for authors, an stateless EJB session bean
 * @author hajo
 */
@Stateless
public class IngredientCatalogue extends AbstractQuery<Ingredient, String> {

    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public IngredientCatalogue() {
        // author is default object created by QueryDSL, see Generated Sources
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

    public List<Ingredient> findByName(String name) {
        QIngredient ingredient = QIngredient.ingredient;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Ingredient> found = qf.select(ingredient)
                .from(ingredient)
                .where(ingredient.name.eq(name))
                .fetch();
        out.println(found);
        return found;
    }
    
    public List<Ingredient> findByRecipe(Recipe recipe) {
        QRecipeIngredient recipeIngredient = QRecipeIngredient.recipeIngredient;
        QIngredient ingredient = QIngredient.ingredient;
        JPAQueryFactory qf = new JPAQueryFactory(em);

        List<Ingredient> ingredients = 
                (qf.select(ingredient)
                .from(ingredient)
                .where(ingredient.in
                    (qf.select(recipeIngredient.ingredient)
                    .from(recipeIngredient)
                    .where(recipeIngredient.recipe.eq(recipe))))
                .fetch());
  
        out.println(ingredients);
        return ingredients;
    }

}
