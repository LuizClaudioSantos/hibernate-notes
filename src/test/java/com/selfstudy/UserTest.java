package com.selfstudy;

import com.selfstudy.entity.User;
import com.selfstudy.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.*;

import java.util.Date;

/**
 * Created by luizfr on 1/24/16.
 */
public class UserTest {

    private static User user;
    private static Session  session;

    @BeforeClass
    public static void initialize(){
        User user = new User();
        user.setFirstName("Zé");
        user.setLastName("das Couves");
        user.setBirthDate(new Date());
        user.setCreateDate(new Date());
        user.setEmail("zedascouves@server.com");
        user.setLastUpdateBy("Alonso");
        user.setLastUpdateDate(new Date());
        user.setCreateBy("Alonso");
        UserTest.user = user;
        UserTest.session = HibernateUtil.getSessionFactory().openSession();
    }

    @AfterClass
    public static void finilize(){
        UserTest.session.close();
    }

    @Test
    public void PropertiesConfigurationTest(){
        session.beginTransaction();
        session.save(this.user);
        session.getTransaction().commit();
    }

    @Test
    public void updateUser(){
        session.beginTransaction();
        User dbUser = (User) session.get(User.class, this.user.getUserId());
        dbUser.setFirstName("Abreu");
        session.getTransaction().commit();
    }

}
