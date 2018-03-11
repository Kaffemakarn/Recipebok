
package edu.chl.recipebok.core;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;

/**
 *
 * @author Mickaela
 */
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Ingredient implements Serializable {

    @Id
    @Getter
    @Setter
    private String name;

    public Ingredient(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

