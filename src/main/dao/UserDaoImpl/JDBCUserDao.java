package main.dao.UserDaoImpl;

import main.dao.UserDao;
import main.model.Setting;
import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JDBCUserDao implements UserDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User signin(String email, String password) {
        String sql = "SELECT * FROM User WHERE email = ? AND password = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{email, password}, new UserRowMapper<User>());
        //return a User instance if success, return NULL if failed
        return users.get(0);
    }

    public User addUser(User user) {
        String sql = String.format("insert into User values(NULL, '%s','%s', '%s', %s, %s, %s, %s)",
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getHeight(),
                user.getWeight(),
                user.getAge(),
                user.getCurrentSetting());
        jdbcTemplate.execute(sql);
        System.out.println("dao: "+user);
        return user;
    }

    public boolean addSetting(int userId, Setting setting) {
        return false;
    }

    public boolean deleteSetting(int id) {
        return false;
    }

    public User updateUser(User user) {
        return null;
    }

    public User findUser(int userId) {

        return null;
    }

    class UserRowMapper<T> implements RowMapper {

        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUsername(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getInt("age"));
            user.setCurrentSetting(rs.getInt("current_setting"));
            user.setHeight(rs.getInt("height"));
            user.setWeight(rs.getInt("weight"));
            return user;
        }
    }
}
