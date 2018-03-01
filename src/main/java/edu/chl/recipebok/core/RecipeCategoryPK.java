package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

/**
 *
 * @author August
 */
@EqualsAndHashCode
public class RecipeCategoryPK implements Serializable {

    @Getter
    private String recipeId;

    @Getter
    // TODO Ensure that this can only be one of the values in the Category enum
    private String category;


    public RecipeCategoryPK(String recipeId, String category) {
        this.recipeId = recipeId;
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecipeCategoryPK{" +
                "recipeId='" + recipeId + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
