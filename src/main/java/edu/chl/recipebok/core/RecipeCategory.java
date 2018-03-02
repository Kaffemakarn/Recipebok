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
@IdClass(RecipeCategoryPK.class)
public class RecipeCategory implements Serializable {

    @Id
    @Getter
    private String recipeId;

    @Id
    @Getter
    // TODO Ensure that this can only be one of the values in the Category enum
    private String category;


    public RecipeCategory(String recipeId, String category) {
        this.recipeId = recipeId;
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "recipeId='" + recipeId + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
