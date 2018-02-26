/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.recipebok.dao;

/**
 * Author: Hajo
 */
import javax.persistence.EntityManager;

public abstract class AbstractDAO<T, K> {

    private final Class<T> clazz;
   
    // To be overridden by subclasses
    public abstract EntityManager getEntityManager();
    // This one if for testing outside container
    public abstract void setEntityManager(EntityManager em);

    protected AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void create(T t) {
        getEntityManager().persist(t);
        flush();    // Because of Exceptionhandling (else will get EJBException)
    }

    public void delete(K id) {
        T t = getEntityManager().getReference(clazz, id);
        getEntityManager().remove(t);
    }

    // Updated as result
    public T update(T t) {
        return getEntityManager().merge(t);
    }

    public T find(K id) {
        return getEntityManager().find(clazz, id);
    }

    protected void flush() {
        getEntityManager().flush();
    }
}
