/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.managedbeans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import com.dac.lol.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.dac.lol.util.HibernateUtil;

/**
 *
 * @author ikki
 */
@Named(value = "userManagedBean")
@RequestScoped
public class UserManagedBean {

    private User user;

    public UserManagedBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public String create() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return "success";
    }

}
