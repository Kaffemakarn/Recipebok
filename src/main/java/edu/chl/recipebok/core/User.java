/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.core;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Sabrina 
 */
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="user" )
//TODO "User is a reserved SQL99 keyword"? 
public class User implements Serializable {

    @Getter
    @Id
    private String email;
    
    @Getter
    @Setter
    @Column(unique=true)
    private String username;
    
    @Getter
    @Setter
    private String picture; //TODO Find out how to handle images.
    
    public User(String email, String username, String picture){
        this.email = email;
        this.username = username;
        this.picture = picture;
    }
    
    @Override
    public String toString() {
        return username + " (" + email + ")";
    }
    
}
