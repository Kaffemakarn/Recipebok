package edu.chl.recipebok.core;

import lombok.*;
//import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author August
 */

//@EqualsAndHashCode (of = {"userId", "recipeId"})
@NoArgsConstructor
//@Entity
//@IdClass(RatingPK.class)
public class Rating  implements Serializable {

    //@Id
    @Getter
    @Setter
    //@Column(nullable=false)
    private String userId;

    //@Id
    @Getter
    @Setter
    //@Column(nullable=false)
    private String recipeId;

    @Getter
    @Setter
    //@Column(nullable=false)
    private int value;

    @Getter
    @Setter
    private String comment;


    public Rating(String userId, String recipeId, int value, String comment) {
        this.userId = userId;
        this.recipeId = recipeId;
        this.value = value;
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Rating{" +
                "userId='" + userId + '\'' +
                ", recipeId='" + recipeId + '\'' +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}
