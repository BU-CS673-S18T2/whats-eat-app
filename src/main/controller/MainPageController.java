package main.controller;

import main.model.Food;
import main.model.User;
import main.service.FoodService;
import main.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/main")
public class MainPageController {

    @Resource
    private UserService userService;

    @Resource
    private FoodService foodService;

    @RequestMapping("/signin")
    public @ResponseBody User login(){
        return userService.signin();
    }


    @RequestMapping(value="/signup")
    public @ResponseBody User signup(){
        User user = new User();
        user.setUsername("sang");
        user.setPassword("12345");
        user.setEmail("jimmysg@bu.edu");
        return user;
//        return userService.signup(null, null, null);
    }

    @RequestMapping(value="/foodlist")
    public @ResponseBody
    List<Food> foodList(){
        List<Food> foods = new ArrayList<Food>();
        Food apple = new Food();
        apple.setName("apple");
        apple.setCalorie(100);
        Food orange = new Food();
        orange.setName("orange");
        orange.setCalorie(80);
        foods.add(apple);
        foods.add(orange);
        return foods;
//        return foodService.foodList();
    }


    @RequestMapping(value = "{tag}")
    public @ResponseBody
    List<Food> foodsByTag(@PathVariable String tag){
        return foodService.getFoods(tag);
    }



}
