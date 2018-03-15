package main.dao.UserDaoImpl;

import main.dao.UserDao;
import main.model.Setting;
import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JDBCUserDao implements UserDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User signin() {
        return null;
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
        return null;
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
}
