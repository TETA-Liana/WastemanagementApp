package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.User;
import com.management.wastemanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins="http://localhost:8081")

@RequestMapping(path="/api/v1/user")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}