/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;

import edu.chl.recipebok.util.ExceptionHandler;
import edu.chl.recipebok.core.UserPerson;
import edu.chl.recipebok.dao.UserCatalogue;
import edu.chl.recipebok.service.DataSupplier;
import java.io.Serializable;
import static java.lang.System.out;
import java.text.Normalizer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.component.dataTable.DataTable;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author rahadadgar
 */
@Named("userbean")
@SessionScoped
public class UserBean implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());
    @EJB
    private UserCatalogue ucat;
    @Getter
    @Setter
    private UserPerson tmp = new UserPerson();
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
        tmp = new UserPerson();
    }

    // --------- Call backend -------------------------
    public void setUser() {
        tmp = ucat.find(tmp.getEmail());
    }

    public List<UserPerson> findAll() {
        return ucat.findAll();
    }

    public void add() {
        try {
            ucat.create(tmp);
            FacesMessages.info("Success");
        } catch (RuntimeException sql) {
            String message = ExceptionHandler.getMessage(sql);
            FacesMessages.info("Fail " + message);
        }
        tmp = new UserPerson();
    }

    public void update() {
        ucat.update(tmp);
        tmp = new UserPerson();
    }

    public void delete() {
        ucat.delete(tmp.getEmail());
        tmp = new UserPerson();
    }
 
    // find user by username
    public UserPerson findByUsername(String name) {
        return ucat.findByUsername(name);
    }
    // find user by user email
    public UserPerson findByUserMail(String email) {
        return ucat.findByUserMail(email);
    }
}
