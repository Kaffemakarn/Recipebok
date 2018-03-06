/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;

import edu.chl.recipebok.util.ExceptionHandler;
import edu.chl.recipebok.core.User;
import java.io.Serializable;
import static java.lang.System.out;
import java.text.Normalizer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.component.dataTable.DataTable;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author rahadadgar
 */
public class UserBean implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());
    //@EJB
    //private UserCatalogue ucat;
    @Getter
    @Setter
    private User tmp = new User();
    private final int start = 0;
    private int nRecords = 50;

    @Getter
    @Setter
    private Normalizer.Form form;

    @PostConstruct
    void post() {
        out.println(this + "Alive");
    }

    public void page() {
       DataTable dt = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("userTable");
       
       LOG.log(Level.INFO, "Test {0}", dt.getJQueryEvents()); //) +  );
    }
    // ------------ Navigation -------------------

    public void cancel() {
        tmp = new User();
    }

    // --------- Call backend -------------------------
    public void setUser() {
        //tmp = ucat.find(tmp.getEmail());
    }

    public List<User> findAll() {
        //return ucat.findAll();
        return null;
    }

    public void add() {
        try {
            //ucat.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        tmp = new User();
    }

    public void update() {
        //ucat.update(tmp);
        tmp = new User();
    }

    public void delete() {
        //ucat.delete(tmp.getEmail());
        tmp = new User();
    }
 
    // find user by username
     public User findByUsername(String name) {
        //return ucat.findByUsername(name);
        return null;
    }
    // find user by user email
      public User findByUserMail(String email) {
        //return ucat.findByUserMail(email);
        return null;
    }
}
