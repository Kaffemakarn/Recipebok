package edu.chl.recipebok.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.ManyToOne;

/**
 *
 * @author August
 */
@EqualsAndHashCode
public class RecipePK implements Serializable {

    @ManyToOne
    @Getter
    private UserPerson creator;

    @ManyToOne
    @Getter
    private Recipe recipe;


    public RecipePK(UserPerson creator, Recipe recipe) {
        this.creator = creator;
        this.recipe = recipe;
    }


    @Override
    public String toString() {
        return "RecipePK{" +
                "creator ='" + creator + '\'' +
                ", recipeId='" + recipe + '\'' +
                '}';
    }
}
