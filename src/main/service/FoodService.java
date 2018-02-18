package main.service;

import main.dao.FoodDao;
import main.model.Food;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodService {

    @Resource
    private FoodDao foodDao;

    public List<Food> foodList(){
        return foodDao.getAllFoods();
    }

    public List<Food> getFoods(String tag){
        return foodDao.getFoods(tag);
    }
}
