package main.model;


import java.util.List;
import java.util.Set;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private double height;
    private double weight;
    private int age;
    private String gender;
    private int bmr;
    private List<Setting> settings;
    private int currentSetting;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCurrentSetting() {
        return currentSetting;
    }

    public void setCurrentSetting(int currentSetting) {
        this.currentSetting = currentSetting;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
//
//    public int getBmr(){
////        bmr = 0;
////        if (this.gender.equals("Male")){
////            bmr = (int)(66 + (6.3 * this.weight) + (12.9 * this.height) - (6.8 * this.age));
////        }
////        else if (this.gender.equals("Female")){
////            bmr = (int)(655 + (4.3 * this.weight) + (4.7 * this.height) - (4.7 * this.age));
////        }
////        //should throw exception for security
//        return bmr;
//    }
//
//    public void setBmr(int bmr){
//        this.bmr = bmr;
//    }


}
