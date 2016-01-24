package com.selfstudy.util;

import com.selfstudy.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by luizfr on 1/24/16.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            return configuration.buildSessionFactory(
                    new StandardServiceRegistryBuilder().build());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error buildind the factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactoryXML() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            return configuration
                    .buildSessionFactory(new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building the factory");
        }
    }

    public static SessionFactory getSessionFactoryXML() {
        sessionFactory = buildSessionFactoryXML();
        return sessionFactory;
    }

}