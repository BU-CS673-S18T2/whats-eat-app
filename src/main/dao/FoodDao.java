package main.dao;


import main.model.Food;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodDao {

    public List<Food> getFoods(String tag){
        return new ArrayList<Food>();
    }

    public List<Food> getAllFoods(){
        return new ArrayList<Food>();
    }
}
