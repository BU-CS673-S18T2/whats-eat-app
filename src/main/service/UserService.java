package main.service;

import main.model.Setting;
import main.model.User;

public interface UserService {


    public User signin(String email, String password);

    public User signup(String username, String email, String password, String gender, int height, int weight, int age);

    public boolean changePassword();

    public Setting addSetting(int userId, Setting setting);

    public boolean changeCurrentSetting(int userId, int settingId);
}
