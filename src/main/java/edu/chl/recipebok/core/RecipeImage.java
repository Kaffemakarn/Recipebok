package edu.chl.recipebok.core;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author August
 */
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class RecipeImage implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Getter
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public RecipeImage(Long id, Recipe recipe, Image image) {
        this.id = id;
        this.recipe = recipe;
        this.image = image;
    }

    @Override
    public String toString() {
        return "RecipeImage{" + "id=" + id + 
                ", recipe=" + recipe + 
                ", image=" + image + '}';
    }

    
}
