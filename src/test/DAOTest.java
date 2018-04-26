package test;

import main.dao.UserDao;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class DAOTest {

    @Autowired
    private static UserDao userDao;

//    @BeforeClass
//    public static void init() {
//        ApplicationContext
//                context = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        userDao = (UserDao)context.getBean("userDao");
//    }


    @Test
    public void userTest(){
        System.out.println(userDao.findUser(1));
    }
}
