/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.core;

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
//@Table( name="Recipe")
public class Recipe implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(nullable=false)
    private String id;

    @Getter
    @Setter
    @Column(nullable=false)
    private String name;

    @Getter
    @Setter
    @Column(nullable=false)
    private String creator;

    @Getter
    @Setter
    @Column(nullable=false)
    private String creationTime;

    // TODO add image

    public Recipe(String id, String name, String creator, String creationTime){
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.creationTime = creationTime;
    }

    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", creator=" + creator + ", creationTime=" + creationTime + "}";
    }


}
