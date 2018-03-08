package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.QRecipe;
import edu.chl.recipebok.core.Cookbook;
import edu.chl.recipebok.core.QCookbook;
import edu.chl.recipebok.core.CookbookRecipe;
import edu.chl.recipebok.core.QCookbookRecipe;
import edu.chl.recipebok.core.RecipeCategory;
import edu.chl.recipebok.core.QRecipeCategory;
import edu.chl.recipebok.core.RecipeIngredient;
import edu.chl.recipebok.core.QRecipeIngredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.lang.System.out;
import java.util.ArrayList;

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
    
    // Find recipes by user
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
    
    
    // Find Recipes by recipe name
    public List<Recipe> findByName(String name) {
        QRecipe recipe = QRecipe.recipe;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Recipe> recipeList = qf.select(recipe)
                .from(recipe)
                .where(recipe.name.eq(name))
                .fetch();
       
        out.println(recipeList);
        return recipeList;
    }
    
    // Find a recipe by user and recipe name
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
    
    // Find Recipes by Cookbook
    public List<Recipe> findByCookbook(String cookbookId) {
        
        QRecipe recipe = QRecipe.recipe;
        QCookbookRecipe cookbookRecipe = QCookbookRecipe.cookbookRecipe;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        
        // Get list of recipes using recipeIds from CookbookRecipe entries
        List<Recipe> recipes =
            (qf.select(recipe)
            .from(recipe)
            .where(recipe.id.in
                // Find all recipeIds connected to the specified cookbook       
                (qf.select(cookbookRecipe.recipeId)
                .from (cookbookRecipe)
                .where(cookbookRecipe.cookbookId.eq(cookbookId))))
            .fetch());
                  
        out.println(recipes);
        return recipes;

    }
    
    
    
    // Find all Recipes that belong to a specified category
    public List<Recipe> findByCategory(String category) {
        
        QRecipe recipe = QRecipe.recipe;
        QRecipeCategory recipeCategory = QRecipeCategory.recipeCategory;
        JPAQueryFactory qf = new JPAQueryFactory(em); 
                
        // Get list of recipes using recipeIds from RecipeCategory files
        List<Recipe> recipes =
            (qf.select(recipe)
            .from(recipe)
            .where(recipe.id.in
                // Find all recipeIds connected to the specified Category        
                (qf.select(recipeCategory.recipeId)
                .from (recipeCategory)
                .where(recipeCategory.category.eq(category))))
            .fetch());
                  
        out.println(recipes);
        return recipes;
    }
    
    // Find Recipes that belong to all the specified categories
    public List<Recipe> findByCategories(List<String> categories) {
        // If input list is empty, return empty list
        if (categories.isEmpty()) return new ArrayList<Recipe>();
        
        // Get intersection of all recipe lists
        List<Recipe> recipes = findByCategory(categories.get(0));
        for (int x = 1; x < categories.size(); x++) {
            recipes.retainAll(findByCategory(categories.get(x)));
        }
        
        out.println(recipes);
        return recipes;
    }

    
     
    
    // Find Recipes that use the specified ingredient. 
    public List<Recipe> findByIngredient(String ingredient) {
        /*
        QRecipe recipe = QRecipe.recipe;
        QRecipeIngredient recipeIngredient = QRecipeIngredient.recipeIngredient;
        JPAQueryFactory qf = new JPAQueryFactory(em); 
                
        // Get list of recipes using recipeIds from RecipeIngredient files
        List<Recipe> recipes =
            (qf.select(recipe)
            .from(recipe)
            .where(recipe.id.in
                // Find all recipeIds connected to the specified Ingredient        
                (qf.select(recipeIngredient.recipeId)
                .from (recipeIngredient)
                .where(recipeIngredient.ingredientName.eq(ingredient)))
            .fetch()));
                  
        out.println(recipes);
        return recipes;*/
        return null;
    }
    
    // Find Recipes that use all the specified ingredients
    public List<Recipe> findByIngredients(List<String> ingredients) {
        // If input list is empty, return empty list
        if (ingredients.isEmpty()) return new ArrayList<Recipe>();
        
        // Get intersection of all recipe lists
        List<Recipe> recipes = findByIngredient(ingredients.get(0));
        for (int x = 1; x < ingredients.size(); x++) {
            recipes.retainAll(findByIngredient(ingredients.get(x)));
        }
        
        out.println(recipes);
        return recipes;
    }
}