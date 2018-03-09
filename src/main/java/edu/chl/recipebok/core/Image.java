/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    //@Column(nullable=false)
    private UserPerson user;
    
    
    @Getter
    @Setter
    private String filename;
    
}
