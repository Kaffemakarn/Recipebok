package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author August
 */
@EqualsAndHashCode
public class RecipePK implements Serializable {

    @Getter
    private String creator;

    @Getter
    private String recipeId;


    public RecipePK(String creator, String recipeId) {
        this.creator = creator;
        this.recipeId = recipeId;
    }


    @Override
    public String toString() {
        return "RecipePK{" +
                "creator ='" + creator + '\'' +
                ", recipeId='" + recipeId + '\'' +
                '}';
    }
}
