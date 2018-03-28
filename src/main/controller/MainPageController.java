package main.controller;

import main.model.Food;
import main.model.User;
import main.service.FoodService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/signin")
    public @ResponseBody User signin(){
        String username = request.getParameter("uname");
        String email = request.getParameter("email");
        return userService.signin(username, email);
    }


    @RequestMapping(value="/signup")
    public @ResponseBody User signup(){
        String username = request.getParameter("uname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return userService.signup(username, email, password);
    }

    @RequestMapping(value="/foodlist")
    public @ResponseBody
    List<Food> foodList(){
        return foodService.foodList();
    }


    @RequestMapping(value = "/food/{tag}")
    public @ResponseBody
    List<Food> foodsByTag(@PathVariable String tag){
        return foodService.getFoods(tag);
    }



}
