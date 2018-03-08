package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author August
 */

@EqualsAndHashCode (of = {"userId", "recipeId"})
@NoArgsConstructor
@Entity
//@IdClass(RatingPK.class)
public class Rating  implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
       
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "userperson_email")
    private UserPerson user;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Getter
    @Setter
    private int value;

    @Getter
    @Setter
    private String comment;


    public Rating(UserPerson user, Recipe recipe, int value, String comment) {
        this.user = user;
        this.recipe = recipe;
        this.value = value;
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Rating{" +
                "userId='" + user.getEmail() + '\'' +
                ", recipeId='" + recipe.getId() + '\'' +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}
