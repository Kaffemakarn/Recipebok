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
public class CookbookRecipe implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "cookbook_id")
    private Cookbook cookbook;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public CookbookRecipe(Cookbook cookbook, Recipe recipe) {
        this.cookbook = cookbook;
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "CookbookRecipe{" +
                "cookbookId='" + cookbook.getName() + '\'' +
                ", recipeId='" + recipe.getName()+ '\'' +
                '}';
    }
}
