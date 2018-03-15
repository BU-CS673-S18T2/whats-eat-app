package main.service.UserServiceImpl;

import main.dao.UserDao;
import main.model.Setting;
import main.model.User;
import main.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User signin() {
        return null;
    }

    public User signup(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return userDao.addUser(user);
    }

    public boolean changePassword() {
        return false;
    }

    public Setting addSetting(int userId, Setting setting) {
        return null;
    }

    public boolean changeCurrentSetting(int userId, int settingId) {
        return false;
    }
}
