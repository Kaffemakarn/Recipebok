package edu.chl.recipebok.core;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author August
 */
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class UserImage implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @OneToOne
    @JoinColumn(name = "userperson_email")
    private UserPerson user;

    @Getter
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public UserImage(Long id, UserPerson user, Image image) {
        this.id = id;
        this.user = user;
        this.image = image;
    }

    @Override
    public String toString() {
        return "UserImage{" + "id=" + id + 
                ", user=" + user + 
                ", image=" + image + '}';
    }
}