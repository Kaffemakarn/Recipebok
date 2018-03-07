package edu.chl.recipebok.dao;

import edu.chl.recipebok.core.User;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.chl.recipebok.core.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.QRecipe;
import edu.chl.recipebok.core.Recipe;
import static java.lang.System.out;

/**
 *
 * @author August
 */
@Stateless
public class UserCatalogue extends AbstractQuery<User, String> {

    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public UserCatalogue() {
        // user is default object created by QueryDSL, see Generated Sources
        super(User.class, QUser.user);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public User findByUsername(String username) {
        QUser user = QUser.user;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<User> foundList = qf.select(user)
                .from(user)
                .where(user.username.eq(username))
                .fetch();
        User found = foundList.get(0); // TODO
        out.println(found);
        return found;
    }   
    
    
      public User findByUserMail(String email) {
        QUser user = QUser.user;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<User> foundList = qf.select(user)
                .from(user)
                .where(user.email.eq(email))
                .fetch();
        User found = foundList.get(0); // TODO
        out.println(found);
        return found;
    }   
      
      //POSSIBLE TODO?
       /*public List<User> findUserByRecipe(String recipeName ) {
        QRecipe recipe = QRecipe.recipe;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Recipe> foundList = qf.select(recipe)
                .from(recipe)
                .where((recipe.name.eq(recipeName)))
                .fetch();
        //Recipe found = foundList.get(0);
        
        out.println(foundList);
        return found;
    }*/
       
}