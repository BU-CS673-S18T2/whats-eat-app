package main.model;

import org.junit.Test;
import org.junit.Assert;


public class HistoryTest {
History history = new History();
    @Test
    public void getId() {
    }

    @Test
    public void setId() {
        history.setId(4);
        Assert.assertEquals(4,history.getId());
    }

    @Test
    public void getUserId() {
    }

    @Test
    public void setUserId() {
        history.setUserId(4);
        Assert.assertEquals(4,history.getUserId());
    }

    @Test
    public void getFoodId() {
    }

    @Test
    public void setFoodId() {
        history.setFoodId(4);
        Assert.assertEquals(4,history.getFoodId());
    }

    @Test
    public void isChosen() {
    }

    @Test
    public void setChosen() {
        history.setChosen(true);
        Assert.assertTrue(history.isChosen());
    }
}