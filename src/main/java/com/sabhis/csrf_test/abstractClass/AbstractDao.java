/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabhis.csrf_test.abstractClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sabhis231
 */
public class AbstractDao<T> {

    @Autowired
    SessionFactory sessionFactory;
   
    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     *
     * @param obj
     * @return the saved/updated object
     */
    public T saveOrUpdate(T obj) {
        if (obj != null) {
            getCurrentSession().saveOrUpdate(obj);
        }

        return obj;
    }

    /**
     *
     * @param obj
     * @return the saved/updated object
     */
    public T update(T obj) {
        if (obj != null) {
            getCurrentSession().update(obj);
        }
        return obj;
    }

    /**
     *
     * @param obj
     * @return the saved/updated object
     */
    public T save(T obj) {
        if (obj != null) {
            getCurrentSession().save(obj);
        }
        return obj;
    }

    /**
     *
     * @param obj
     * @return
     */
    public T delete(T obj) {
        if (obj != null) {
            getCurrentSession().delete(obj);
        }
        return obj;
    }

}
