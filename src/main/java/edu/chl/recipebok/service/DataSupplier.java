package edu.chl.recipebok.service;

import edu.chl.recipebok.core.Category;
import edu.chl.recipebok.core.Cookbook;
import edu.chl.recipebok.core.CookbookRecipe;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.RecipeCategory;
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
    
    
    
    public static List<UserPerson> getUsers(){
        
        List<UserPerson> l = new ArrayList<>();
        
        //(String email, String username, String picture)
        l.add(new UserPerson("Sabrina@mail", "Sabrina", "Strong picture"));
        l.add(new UserPerson("Trafalgar@mail", "Trafalgar", "Pretty picture"));
        return l;
    }
    
    //provides recipes created by the above users
    public static List<Recipe> getRecipes(){
        
        List<Recipe> recipes = new ArrayList<Recipe>();
        
        String instructions = "First, take the tomatoes and chop them coarsely. \n"
                + "Then, put them in a pot together with the water and all spices.\n"
                + "Let it boil for 20 minutes and then serve with bread.";
        
        //String id, String name, String creator, String creationTime)
        recipes.add(new Recipe("TOMATSOPPA", "Tomatsoppa", instructions, "Sabrina@mail", "2018-03-02"));
        
        instructions = "Defrost the chicken. \n"
                + "Mix the soy sauce with the spices and let the chicken marinate in the sauce. \n"
                + "Then put the chicken in the oven and cook for 30 minutes.";
        
        recipes.add(new Recipe("CHICKEN", "Marinated Chicken", instructions, "Trafalgar@mail", "1066-06-06"));
        
        return recipes;
        
    }
    
    //this creates the ingredient connections for the above recipes
    public static List<RecipeIngredient> getRecipeIngredients(){
        List<RecipeIngredient> i = new ArrayList<>();
        
        //public RecipeIngredient(String recipeId, String ingredientName, int quantity)
        i.add(new RecipeIngredient("TOMATSOPPA", "Tomato", 10));
        i.add(new RecipeIngredient("TOMATSOPPA", "Water", 7));
        i.add(new RecipeIngredient("TOMATSOPPA", "Bread", 1));
        i.add(new RecipeIngredient("TOMATSOPPA", "Spices", 4));
        
        i.add(new RecipeIngredient("CHICKEN", "Chicken", 1));
        i.add(new RecipeIngredient("CHICKEN", "Soy sauce", 2));
        i.add(new RecipeIngredient("CHICKEN", "Spices", 15));
        
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
        
        
        l.add(new Cookbook("IDONE", "Sabrina@mail", "Beautiful Food"));
        
        return l;
    }
    
    public static List<CookbookRecipe> getCookbookRecipes(){
        List<CookbookRecipe> l = new ArrayList<>();
        
        l.add(new CookbookRecipe("IDONE", "TOMATSOPPA"));
        l.add(new CookbookRecipe("IDONE", "CHICKEN"));
        
        return l;
    }
    
    public static List<Category> getCategories(){
        List<Category> l = new ArrayList<>();
        
        l.add(Category.LOW_CARB);
        l.add(Category.VEGAN);
        
        return l;
    }
    
    public static List<RecipeCategory> getRecipeCategories(){
        
        List<RecipeCategory> l = new ArrayList<>();
        
        l.add(new RecipeCategory("TOMATSOPPA", "VEGAN"));
        l.add(new RecipeCategory("CHICKEN", "LOW_CARB"));
        
        return null;
    }
    
}
