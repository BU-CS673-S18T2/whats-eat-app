package main.service;

import main.dao.UserDao;
import main.model.Setting;
import main.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User signin(){
        return userDao.signin();
    }

    public User signup(String username, String email, String password){
        return new User();
    }

    public boolean changePassword(){
        userDao.updateUser(new User());
        return true;
    }

    public Setting addSetting(int userId, Setting setting){
        userDao.addSetting(userId, setting);
        return setting;
    }

    public boolean changeCurrentSetting(int userId, int settingId){
        User user = userDao.findUser(userId);
        user.setCurrentSetting(settingId);
        userDao.updateUser(user);
        return true;
    }
}
