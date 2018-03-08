package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author August
 */

/*
@EqualsAndHashCode
@NoArgsConstructor
@Entity
//@IdClass(RecipeCategoryPK.class)
public class RecipeCategory implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    //@Id
    @Getter
    @ManyToOne
    private Recipe recipe;

    //@Id
    @Getter
    @ManyToOne
    // TODO Ensure that this can only be one of the values in the Category enum
    private Category category;


    public RecipeCategory(Recipe recipeId, Category category) {
        this.recipe = recipe;
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "recipe='" + recipe + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
*/