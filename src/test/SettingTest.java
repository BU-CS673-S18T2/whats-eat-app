package main.model;

import org.junit.Test;
import org.junit.Assert;


public class SettingTest {

    Setting setting = new Setting();
    @Test
    public void getId() {
    }

    @Test
    public void setIdtest() {
        setting.setId(3);
        Assert.assertEquals(3,setting.getId());
    }

    @Test
    public void getBreakfirst_cal() {
    }

    @Test
    public void setBreakfirst_caltest() {
        setting.setBreakfirst_cal(600);
        Assert.assertEquals(600,setting.getBreakfirst_cal());
    }

    @Test
    public void getLunch_cal() {
    }

    @Test
    public void setLunch_caltest() {
        setting.setLunch_cal(600);
        Assert.assertEquals(600,setting.getLunch_cal());
    }

    @Test
    public void getDinner_cal() {
    }

    @Test
    public void setDinner_caltest() {
        setting.setDinner_cal(600);
        Assert.assertEquals(600,setting.getDinner_cal());
    }
}