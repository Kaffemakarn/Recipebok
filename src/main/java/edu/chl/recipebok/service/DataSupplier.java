package edu.chl.recipebok.service;

import edu.chl.recipebok.core.Category;
import edu.chl.recipebok.core.Cookbook;
import edu.chl.recipebok.core.CookbookRecipe;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.Rating;
import edu.chl.recipebok.core.Recipe;
//import edu.chl.recipebok.core.RecipeCategory;
import edu.chl.recipebok.core.RecipeIngredient;
import edu.chl.recipebok.core.UserPerson;
import java.util.ArrayList;
import java.util.List;

/**
 * Just to get some data (used to re-populate database)
 *
 * @author Sabrina
 */

public class DataSupplier {
    
    //Note that these methods must all be used in order to properly populate the database
    
    
    static UserPerson s = new UserPerson("Sabrina@mail", "Sabrina", "Strong picture");
    static UserPerson t = new UserPerson("Trafalgar@mail", "Trafalgar", "Pretty picture");
        
    static String inst1 = "First, take the tomatoes and chop them coarsely. \n"
                + "Then, put them in a pot together with the water and all spices.\n"
                + "Let it boil for 20 minutes and then serve with bread.";
        
    static Recipe tomatosoup = new Recipe("1", "Tomatsoppa", inst1, s, "2018-03-02");

    static String inst2 = "Defrost the chicken. \n"
            + "Mix the soy sauce with the spices and let the chicken marinate in the sauce. \n"
            + "Then put the chicken in the oven and cook for 30 minutes.";

    static Recipe chicken = new Recipe("2", "Marinated Chicken", inst2, t, "1066-06-06");
    
    static Cookbook cookbook = new Cookbook("0001", s, "Beautiful Food");
    
    //user recipe value comment
    static Rating rating1 = new Rating(s, tomatosoup, 4, "Great");
    static Rating rating2 = new Rating(t, tomatosoup, 1, "Not good");
    static Rating rating3 = new Rating(t, chicken, 5, "Amazing");
    
    
    
    
    public static List<UserPerson> getUserPersons(){
        
        List<UserPerson> l = new ArrayList<>();
        
        l.add(s);
        l.add(t);
        return l;
    }
    
    
    public static List<Recipe> getRecipes(){
        
        List<Recipe> recipes = new ArrayList<Recipe>();
      
        recipes.add(tomatosoup);
        recipes.add(chicken);
        
        return recipes;
        
    }
    
    public static List<Rating> getRatings(){
        List<Rating> ratings = new ArrayList<>();
        
        ratings.add(rating1);
        ratings.add(rating2);
        ratings.add(rating3);

        return ratings;
    }
    
    //this creates the ingredient connections for the above recipes
    public static List<RecipeIngredient> getRecipeIngredients(){
        List<RecipeIngredient> i = new ArrayList<>();
        
        
        
        //public RecipeIngredient(Recipe recipe, String ingredientName, int quantity)
        i.add(new RecipeIngredient(tomatosoup, new Ingredient("Tomato"), 10));
        i.add(new RecipeIngredient(tomatosoup, new Ingredient("Water"), 7));
        i.add(new RecipeIngredient(tomatosoup, new Ingredient("Bread"), 1));
        i.add(new RecipeIngredient(tomatosoup, new Ingredient("Spices"), 4));
        
        i.add(new RecipeIngredient(chicken, new Ingredient("Chicken"), 1));
        i.add(new RecipeIngredient(chicken, new Ingredient("Soy sauce"), 2));
        i.add(new RecipeIngredient(chicken, new Ingredient("Spices"), 15));
        
        return i;       
    }
    
    public static List<Ingredient> getIngredients(){
        
        List<Ingredient> i = new ArrayList<>();
        
        i.add(new Ingredient("Chicken"));
        i.add(new Ingredient("Tomato"));
        i.add(new Ingredient("Soy sauce"));
        i.add(new Ingredient("Spices"));
        i.add(new Ingredient("Water"));
        i.add(new Ingredient("Bread"));
        
        return i;
        
    }
    
    
    //public Cookbook(String id, String userId, String cookbookName)
    
    public static List<Cookbook> getCookbooks(){
        
        List<Cookbook> l = new ArrayList<>();        
        l.add(cookbook);
        
        return l;
    }
    
    public static List<CookbookRecipe> getCookbookRecipes(){
        List<CookbookRecipe> l = new ArrayList<>();
        
        l.add(new CookbookRecipe(cookbook, tomatosoup));
        l.add(new CookbookRecipe(cookbook, chicken));
        
        return l;
    }
    
    /*
    public static List<Category> getCategories(){
        List<Category> l = new ArrayList<>();
        
        l.add(Category.LOW_CARB);
        l.add(Category.VEGAN);
        
        return l;
    }
    */
    
    /*
    public static List<RecipeCategory> getRecipeCategories(){
        
        List<RecipeCategory> l = new ArrayList<>();
        
        l.add(new RecipeCategory("TOMATSOPPA", "VEGAN"));
        l.add(new RecipeCategory("CHICKEN", "LOW_CARB"));
        
        return null;
    }
    */
}

