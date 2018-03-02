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
@EqualsAndHashCode
@Entity
//@IdClass(IngredientPK.class)
@Table( name="ingredient")
public class Ingredient implements Serializable {

    @Id
    @Getter
    @Column(nullable=false)
    private String name;

    public Ingredient(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{ name = " + name + "}";
    }

}

