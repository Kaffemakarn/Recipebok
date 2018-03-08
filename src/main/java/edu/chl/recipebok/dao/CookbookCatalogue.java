/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.dao;

import edu.chl.recipebok.core.Cookbook;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.chl.recipebok.core.QCookbook;
import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.UserPerson;

/**
 *
 * @author August
 */


@Stateless
public class CookbookCatalogue extends AbstractQuery<Cookbook, String> {

    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public CookbookCatalogue() {
        // cookbook is default object created by QueryDSL, see Generated Sources
        super(Cookbook.class, QCookbook.cookbook);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<Cookbook> findByUser(UserPerson user) {
        QCookbook cookbook = QCookbook.cookbook;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Cookbook> found = qf.select(cookbook)
                .from(cookbook)
                .where(cookbook.user.eq(user))
                .fetch();
        out.println(found);
        return found;
    }
    
    public Cookbook findByUserAndName(UserPerson user, String cookbookName) {
        QCookbook cookbook = QCookbook.cookbook;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Cookbook> foundList = qf.select(cookbook)
                .from(cookbook)
                .where(cookbook.user.eq(user).and(cookbook.name.eq(cookbookName)))
                .fetch();
        Cookbook found = foundList.get(0);
        out.println(found);
        return found;
    }
        
}

