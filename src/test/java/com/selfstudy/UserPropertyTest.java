package com.selfstudy;

import com.selfstudy.entity.UserProperty;
import com.selfstudy.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

/**
 * Created by luizfr on 1/25/16.
 */
public class UserPropertyTest {

    private static UserProperty user;

    @BeforeClass
    public static void createUser(){
        UserPropertyTest.user  = new UserProperty();
        user.setFirstName("Zé");
        user.setLastName("das Couves");
        user.setBirthDate(new Date());
        user.setCreateDate(new Date());
        user.setEmail("zedascouves@server.com");
        user.setLastUpdateBy("Alonso");
        user.setLastUpdateDate(new Date());
        user.setCreateBy("Alonso");
    }

    @Test
    public void XmlConfigurationTest(){

        Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        session.save(user);
        session.close();

    }



}
