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
@IdClass(CookbookRecipePK.class)

public class CookbookRecipe implements Serializable {

    @Id
    @Getter
    private String cookbookId;

    @Id
    @Getter
    private String recipeId;

    public CookbookRecipe(String cookbookId, String recipeId) {
        this.cookbookId = cookbookId;
        this.recipeId = recipeId;
    }

    @Override
    public String toString() {
        return "CookbookRecipe{" +
                "cookbookId='" + cookbookId + '\'' +
                ", recipeId='" + recipeId + '\'' +
                '}';
    }
}
