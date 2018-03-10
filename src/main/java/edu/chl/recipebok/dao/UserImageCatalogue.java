/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Image;
import edu.chl.recipebok.core.QImage;
import edu.chl.recipebok.core.QRecipeImage;
import edu.chl.recipebok.core.UserImage;
import edu.chl.recipebok.core.QUserImage;
import edu.chl.recipebok.core.Recipe;
import edu.chl.recipebok.core.UserPerson;
import edu.chl.recipebok.dao.AbstractQuery;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author August
 */
@Stateless
public class UserImageCatalogue extends AbstractQuery<UserImage, Long> {
    
    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public UserImageCatalogue() {
        // ingredient is default object created by QueryDSL, see Generated Sources
        super(UserImage.class, QUserImage.userImage);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public Image findByUser(UserPerson user) {
        QUserImage userImage = QUserImage.userImage;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Image> foundList = qf.select(userImage.image)
                .from(userImage)
                .where(userImage.user.eq(user))
                .fetch();
        Image found = foundList.get(0);
        out.println(found);
        return found;
    }
}