package com.example.registerform.controller;

import com.example.registerform.model.User;
import com.example.registerform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    public String getUserPage() {
        return "add-user";
    }

    @PostMapping("/test")
    public String registerUser(@RequestParam(name = "txtUsername") String username,
                               @RequestParam(name = "txtPassword") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        repository.save(user);
        return "redirect:/test";
    }
}
