package main.dao.FoodDaoImpl;

import main.dao.FoodDao;
import main.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JDBCFoodDao implements FoodDao{
    public List<Food> getFoods(String tag) {
        return null;
    }

    public List<Food> getAllFoods() {
        return null;
    }
}
