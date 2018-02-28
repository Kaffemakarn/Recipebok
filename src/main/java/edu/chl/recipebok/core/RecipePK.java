package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
public class RecipePK implements Serializable {

    @Getter
    private String cookbookId;

    @Getter
    private String recipeId;



    public RecipePK(String cookbookId, String recipeId) {
        this.cookbookId = cookbookId;
        this.recipeId = recipeId;
    }


    @Override
    public String toString() {
        return "RecipePK{" +
                "cookbookId ='" + cookbookId + '\'' +
                ", recipeId='" + recipeId + '\'' +
                '}';
    }
}
