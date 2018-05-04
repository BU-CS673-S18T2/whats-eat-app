package main.model;

import org.junit.Test;
import org.junit.Assert;

public class FoodTest {
Food food = new Food();
    @Test
    public void getIngredient() {
    }

    @Test
    public void setIngredient() {
        food.setIngredient("tomato");
        Assert.assertEquals("tomato",food.getIngredient());
    }

    @Test
    public void getId() {
    }

    @Test
    public void setId() {
        food.setId(4);
        Assert.assertEquals(4,food.getId());
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
        food.setName("Ketchup");
        Assert.assertEquals("Ketchup",food.getName());
    }

    @Test
    public void getCalorie() {
    }

    @Test
    public void setCalorie() {
        food.setCalorie(300);
        Assert.assertEquals(300,food.getCalorie());
    }
}