package edu.chl.recipebok.core;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author August
 */
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Image implements Serializable{
        
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
    private String filename;

    public Image(Long id, UserPerson user, String filename) {
        this.id = id;
        this.user = user;
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Image{" + "id=" + id + 
                ", user=" + user + 
                ", filename=" + filename + '}';
    }
    
    
    
}
