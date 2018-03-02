package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.io.Serializable;

/**
 *
 * @author August
 */
@EqualsAndHashCode
public class CookbookRecipePK implements Serializable {

    @Getter
    private String cookbookId;

    @Getter
    private String recipeId;

    public CookbookRecipePK(String cookbookId, String recipeId) {
        this.cookbookId = cookbookId;
        this.recipeId = recipeId;
    }

    @Override
    public String toString() {
        return "CookbookRecipePK{" +
                "cookbookId='" + cookbookId + '\'' +
                ", recipeId='" + recipeId + '\'' +
                '}';
    }
}
