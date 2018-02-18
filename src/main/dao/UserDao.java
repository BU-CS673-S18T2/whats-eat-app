package main.dao;

import main.model.Setting;
import main.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {



    public User signin(){
        System.out.println("userDao");
        return new User();
    }

    public User addUser(){
        return new User();
    }

    public boolean addSetting(int userId, Setting setting){
        return true;
    }

    public boolean deleteSetting(int id){
        return true;
    }

    public User updateUser(User user){
        return new User();
    }

    public User findUser(int userId){
        return new User();
    }
}
