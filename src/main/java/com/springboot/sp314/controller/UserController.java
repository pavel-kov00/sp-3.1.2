package com.springboot.sp314.controller;


import com.springboot.sp314.model.User;
import com.springboot.sp314.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/add")
    public String addUser() {
        return "adduser";
    }

    @PostMapping("/add")
    public String addUserPost(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id,Model model){
        model.addAttribute("user",userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/edit/{id}")
    public String updateUserPost(@ModelAttribute User user,@PathVariable("id") long id){
        userService.updateUser(user,id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
