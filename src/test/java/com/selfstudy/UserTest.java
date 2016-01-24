package com.selfstudy;

import com.selfstudy.entity.User;
import com.selfstudy.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by luizfr on 1/24/16.
 */
public class UserTest {

    private User user;

    @Before
    public void createUser(){
        User user = new User();
        user.setFirstName("Zé");
        user.setLastName("das Couves");
        user.setBirthDate(new Date());
        user.setCreateDate(new Date());
        user.setEmail("zedascouves@server.com");
        user.setLastUpdateBy("Alonso");
        user.setLastUpdateDate(new Date());
        user.setCreateBy("Alonso");
        this.user = user;
    }

    @Test
    public void XmlConfigurationTest(){

        Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        session.save(user);
        session.close();

    }

    //@Test
    public void PropertiesConfigurationTest(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(user);
        session.close();

    }

}
