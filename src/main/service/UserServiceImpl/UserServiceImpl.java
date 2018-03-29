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

    public User signin(String email, String password) {
        return userDao.signin(email, password);
    }

    public User signup(String username, String email, String password, String gender, int height, int weight, int age) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setHeight(height);
        user.setWeight(weight);
        user.setAge(age);
        System.out.println("before add: "+ user);
        user = userDao.addUser(user);
        System.out.println("After add: " + user);
        return user;
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
