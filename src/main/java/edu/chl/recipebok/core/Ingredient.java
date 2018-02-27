/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.core;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;

/**
 *
 * @author Mickaela
 */
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Entity
//@IdClass(IngredientPK.class)
@Table( name="ingredient")
public class Ingredient implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(nullable=false)
    private String id;

    @Id
    @Getter
    @Setter
    @Column(nullable=false)
    private String name;

    public Ingredient(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + "}";
    }

}
