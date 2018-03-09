package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import javax.persistence.ManyToOne;

/**
 *
 * @author August
 */
@EqualsAndHashCode
public class RecipeIngredientPK implements Serializable {

    @ManyToOne
    @Getter
    private Recipe recipe;

    @ManyToOne
    @Getter
    private Ingredient ingredient;

    public RecipeIngredientPK(Recipe recipe, Ingredient ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "RecipeIngredientPK{" +
                "recipe='" + recipe + '\'' +
                ", ingredient='" + ingredient + '\'' +
                '}';
    }
}
