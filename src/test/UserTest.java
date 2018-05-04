package main.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    User user = new User();
    @Test
    public void getIdtest() {

    }

    @Test
    public void setIdtest() {
        user.setId(3);
        Assert.assertEquals(3, user.getId());
    }

    @Test
    public void getUsernametest() {

    }

    @Test
    public void setUsernametest() {
        user.setUsername("admin");
        Assert.assertEquals("admin", user.getUsername());
    }

    @Test
    public void getPasswordtest() {

    }

    @Test
    public void setPasswordtest() {
        user.setPassword("admin123");
        Assert.assertEquals("admin123", user.getPassword());
    }

    @Test
    public void getSettings() {

    }

    @Test
    public void setSettings() {

    }

    @Test
    public void getEmailtest() {

    }

    @Test
    public void setEmail() {
        user.setEmail("admin@we.com");
        Assert.assertEquals("admin@we.com", user.getEmail());
    }

    @Test
    public void getCurrentSetting() {
    }

    @Test
    public void setCurrentSetting() {
        user.setCurrentSetting(33);
        Assert.assertEquals(33, user.getCurrentSetting());
    }

    @Test
    public void getGender() {
    }

    @Test
    public void setGender() {
        user.setGender("male");
        Assert.assertEquals("male", user.getGender());
    }

    @Test
    public void getHeight() {
    }

    @Test
    public void setHeight() {
        user.setHeight(170);
        Assert.assertEquals(170, user.getHeight());
    }

    @Test
    public void getWeight() {

    }

    @Test
    public void setWeight() {
        user.setWeight(150);
        Assert.assertEquals(150, user.getWeight());
    }

    @Test
    public void getAge() {
    }

    @Test
    public void setAge() {
        user.setAge(18);
        Assert.assertEquals(18, user.getAge());
    }
}