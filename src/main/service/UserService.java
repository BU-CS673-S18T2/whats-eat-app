package main.service;

import main.dao.UserDao;
import main.model.Setting;
import main.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public interface UserService {


    public User signin();

    public User signup(String username, String email, String password);

    public boolean changePassword();

    public Setting addSetting(int userId, Setting setting);

    public boolean changeCurrentSetting(int userId, int settingId);
}
