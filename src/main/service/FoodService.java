package main.service;

import main.dao.FoodDao;
import main.model.Food;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public interface FoodService {



    public List<Food> foodList();

    public List<Food> getFoods(String tag);
}
