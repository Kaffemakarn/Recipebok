package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode()
@Entity
@Table(uniqueConstraints= { @UniqueConstraint(columnNames = {"userId", "cookbookName"})})
public class Cookbook implements Serializable {

    @Id
    @GeneratedValue
    @Getter
    //@Setter
    private String id;

    @Getter
    @Setter
    @Column(nullable=false)
    private String userId;

    @Getter
    @Setter
    @Column(nullable=false)
    private String cookbookName;


    public Cookbook(String id, String userId, String cookbookName)
    {
        this.id = id;
        this.userId = userId;
        this.cookbookName = cookbookName;
    }


    @Override
    public String toString(){
        return "Cookbook{" + /* "id = " + id +
                ", */"userId = " + userId +
                ", Cookbook Name = " + cookbookName + "}";
    }

}
