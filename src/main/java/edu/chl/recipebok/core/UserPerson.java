
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
public class UserPerson implements Serializable {

    @Getter
    @Setter
    @Id
    private String email = "default@email";
    
    @Getter
    @Setter
    @Column(unique=true)
    private String username;
    
    @Getter
    @Setter
    private String picture; //TODO Find out how to handle images. Is never used
    
    
    
    public UserPerson(String email, String username, String picture){
        this.email = email;
        this.username = username;
        this.picture = picture;
    }
    
    @Override
    public String toString() {
        return username + " (" + email + ")";
    }
    
}
