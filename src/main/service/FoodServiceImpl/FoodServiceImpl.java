package main.service.FoodServiceImpl;

import main.dao.FoodDao;
import main.model.Food;
import main.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FoodServiceImpl implements FoodService{

    @Resource
    private FoodDao foodDao;

    public List<Food> foodList() {
        return foodDao.getAllFoods();
    }

    public List<Food> getFoods(String tag) {
        return foodDao.getFoods(tag);
    }
}
