/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Mickaela
 */
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity 
@Table(uniqueConstraints= { @UniqueConstraint(columnNames = {"creator", "name"})})
public class Recipe implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String instructions;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "creator")
    private UserPerson creator;

    @Getter
    @Setter
    private String creationTime;


    public Recipe(String id, String name, String instructions, UserPerson creator, String creationTime){
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.creator = creator;
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", creator=" + creator + ", creationTime=" + creationTime + "}";
    }


}
