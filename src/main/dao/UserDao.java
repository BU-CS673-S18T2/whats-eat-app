package main.dao;

import main.model.Setting;
import main.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {



    public User signin();

    public User addUser();

    public boolean addSetting(int userId, Setting setting);

    public boolean deleteSetting(int id);

    public User updateUser(User user);

    public User findUser(int userId);
}
