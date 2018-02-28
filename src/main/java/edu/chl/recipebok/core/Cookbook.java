package edu.chl.recipebok.core;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode()
@Entity
public class Cookbook implements Serializable {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @Column(nullable=false)
    private String userID;

    @Getter
    @Setter
    @Column(nullable=false)
    private String cookbookName;



    public Cookbook(String id, String userID, String cookbookName)
    {
        this.id = id;
        this.userID =userID;
        this.cookbookName = cookbookName;

    }


    @Override
    public String toString(){
        return "Cookbook{" + "id = " + id +
                ", userID = " + userID +
                ", Cookbook Name = " + cookbookName + "}";
    }






    // old code


}
