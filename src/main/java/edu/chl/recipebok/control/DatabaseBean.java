/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.control;

import edu.chl.recipebok.core.UserPerson;
import edu.chl.recipebok.dao.UserCatalogue;
import edu.chl.recipebok.service.DataSupplier;
import static java.lang.System.out;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import net.bootsfaces.component.commandButton.CommandButton;

/**
 *
 * @author Mickaela
 */
@Named("db")
@RequestScoped
public class DatabaseBean {

    @EJB
    private UserCatalogue ucat;

    @PostConstruct
    void post() {
        out.println( this + "Alive");
        togglePopulateClear(false);
    }

    public void populate(ActionEvent e) {
        togglePopulateClear(true);
        for (UserPerson u : DataSupplier.getUserPersons()) {
            ucat.create(u);
        }
    }
    
    public void clear(ActionEvent e) {
        togglePopulateClear(false);
        ucat.clear();
    }

    private void togglePopulateClear(boolean toggle) {
        CommandButton btn1 = (CommandButton) getComponent("populateBtn");
        CommandButton btn2 = (CommandButton) getComponent("clearBtn");
        if (toggle) {
            btn1.setDisabled(true);
            btn2.setDisabled(false);
        } else {
            btn1.setDisabled(false);
            btn2.setDisabled(true);
        }
    }

    // NOTE: This assume beans are @RequestScope!
    private Object getComponent(String bindingName) {
        return FacesContext.getCurrentInstance().
                getExternalContext().getRequestMap().get(bindingName);
    }
 
}