package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

/**
 *
 * @author August
 */
@EqualsAndHashCode
public class RecipeIngredientPK implements Serializable {

    @Getter
    private String recipeId;

    @Getter
    private String ingredientName;

    public RecipeIngredientPK(String recipeId, String ingredientName) {
        this.recipeId = recipeId;
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "RecipeIngredientPK{" +
                "recipeId='" + recipeId + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
