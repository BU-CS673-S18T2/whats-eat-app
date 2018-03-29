package main.controller;

import main.model.Food;
import main.model.User;
import main.service.FoodService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
    public @ResponseBody User signup() throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int age = Integer.parseInt(request.getParameter("age"));

        User user = userService.signup(username, email, password, gender, height, weight, age);
        System.out.println(username+gender+weight+height+age);
        return user;
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
