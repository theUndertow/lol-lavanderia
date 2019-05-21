/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac.lol.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ikki
 */

public class HibernateUtil {

    private static SessionFactory sessionFactory = createSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory createSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory factory = configuration.buildSessionFactory(registry);
            return factory;
        } catch (HibernateException ex) {
            System.err.println("The Session Factory couldn't be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
     public static void closeSessionFactory() {
        try {
            sessionFactory.close();
            StandardServiceRegistryBuilder.destroy(sessionFactory.getSessionFactoryOptions().getServiceRegistry());
        }catch(HibernateException ex) {
            System.err.println("Exception while closing session factory: " + ex);
        }
    }
}