package edu.chl.recipebok.dao;


import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.chl.recipebok.core.Ingredient;
import edu.chl.recipebok.core.QIngredient;

/**
 * DAO for authors, an stateless EJB session bean
 * @author hajo
 */
@Stateless
public class IngredientCatalogue extends AbstractQuery<Ingredient, String> {

    @PersistenceContext(unitName = "recipebok_pu")
    private EntityManager em;
      

    public IngredientCatalogue() {
        // author is default object created by QueryDSL, see Generated Sources
        super(Ingredient.class, QIngredient.ingredient);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<Ingredient> findByName(String name) {
        QIngredient ingredient = QIngredient.ingredient;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        List<Ingredient> found = qf.select(ingredient)
                .from(ingredient)
                .where(ingredient.name.eq(name))
                .fetch();
        out.println(found);
        return found;
    }
}
