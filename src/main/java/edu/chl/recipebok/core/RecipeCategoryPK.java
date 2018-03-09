package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import javax.persistence.ManyToOne;

/**
 *
 * @author August
 */
/*
@EqualsAndHashCode
public class RecipeCategoryPK implements Serializable {

    @Getter
    @ManyToOne
    private Recipe recipe;

    @Getter
    @ManyToOne
    // TODO Ensure that this can only be one of the values in the Category enum
    private Category category;


    public RecipeCategoryPK(Recipe recipe, Category category) {
        this.recipe = recipe;
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecipeCategoryPK{" +
                "recipe='" + recipe + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
*/