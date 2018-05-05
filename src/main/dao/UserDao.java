package main.dao;

import main.model.Setting;
import main.model.User;
import org.springframework.stereotype.Repository;


public interface UserDao {



    public User signin(String email, String password);

    public User addUser(User user);

    public boolean addSetting(int userId, Setting setting);

    public boolean deleteSetting(int id);

    public User updateUser(User user);

    public User findUser(int userId);
}
