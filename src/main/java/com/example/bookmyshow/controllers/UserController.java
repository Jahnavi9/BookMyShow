package com.example.bookmyshow.controllers;

import com.example.bookmyshow.DTO.SignIn;
import com.example.bookmyshow.DTO.SignUp;
import com.example.bookmyshow.Services.UserService;
import com.example.bookmyshow.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup")
    public User signup(@RequestBody SignUp signUp)
    {
        return userService.signup(signUp.getEmail(), signUp.getPassword());
    }
    @PostMapping("/signin")
    public boolean signin(@RequestBody SignIn signin)
    {
        return userService.signin(signin.getEmail(), signin.getPassword());
    }
}
