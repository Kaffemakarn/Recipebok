/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.core;

import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Sabrina 
 */
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class User {
    
    
    @Getter
    @Setter
    @Id
    private String email;
    
    @Getter
    @Setter
    private String username;
    
    @Getter
    @Setter
    private String picture;
    
    public User(String email, String username, String pictrure){
        this.email = email;
        this.username = username;
        this.picture = picture;
    }
    
    @Override
    public String toString() {
        return username + " (" + email + ")";
    }
    
}
