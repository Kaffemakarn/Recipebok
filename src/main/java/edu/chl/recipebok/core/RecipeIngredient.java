package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author August
 */
@EqualsAndHashCode
@Entity
@IdClass(RecipeIngredientPK.class)
public class RecipeIngredient implements Serializable {

    @Id
    @Getter
    private String recipeId;

    @Id
    @Getter
    private String ingredientName;

    @Getter
    @Setter
    private int quantity;

    public RecipeIngredient(String recipeId, String ingredientName, int quantity) {
        this.recipeId = recipeId;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeId='" + recipeId + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
