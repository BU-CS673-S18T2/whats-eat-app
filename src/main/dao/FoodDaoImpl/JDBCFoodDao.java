package main.dao.FoodDaoImpl;

import main.dao.FoodDao;
import main.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class JDBCFoodDao implements FoodDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Food> getFoods(String tag) {
        String sql = "SELECT * FROM FOOD WHERE ingredient like ?";
        tag = "%" + tag + "%";
        List<Food> foods = jdbcTemplate.query(sql, new Object[]{tag}, new FoodRowMapper<Food>());
        return foods;
    }

    public List<Food> getFoods(double cal) {
        String sql = "SELECT * FROM FOOD WHERE Food.calorie < ?";
        List<Food> foods = jdbcTemplate.query(sql, new Object[]{cal}, new FoodRowMapper<Food>());
        return foods;
    }

    public List<Food> getAllFoods() {
        String sql = "SELECT * FROM FOOD";
        List<Food> foods = jdbcTemplate.query(sql, new FoodRowMapper<Food>());
        return foods;
    }


    class FoodRowMapper<T> implements RowMapper{

        public Food mapRow(ResultSet rs, int i) throws SQLException {
            Food food = new Food();
            food.setName(rs.getString("name"));
            food.setCalorie(rs.getInt("calorie"));
            food.setIngredient(rs.getString("ingredient"));
            return food;
        }
    }
}
