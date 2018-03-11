package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author August
 */
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class RecipeIngredient implements Serializable {
    
    
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Getter
    @Setter
    @ManyToOne
    private Recipe recipe;

    @Getter
    @Setter
    @ManyToOne
    private Ingredient ingredient;

    @Getter
    @Setter
    private int quantity;

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, int quantity) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipe='" + recipe + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
