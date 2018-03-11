package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(uniqueConstraints= { @UniqueConstraint(columnNames = {"user", "name"})})
public class Cookbook implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "userperson_email")
    private UserPerson user;

    @Getter
    @Setter
    //@Column(nullable=false)
    private String name;


    public Cookbook(String id, UserPerson user, String name)
    {
        this.id = id;
        this.user = user;
        this.name = name;
    }


    @Override
    public String toString(){
        return "Cookbook{ " + "id=" + id + ", " + "creator = " + user.getUsername() +
                ", Cookbook Name = " + name + "}";
    }

}
