package com.kjh.hojak.controller;

import com.kjh.hojak.domain.User;
import com.kjh.hojak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody User user) throws Exception {
        userService.create(user);
    }

    @GetMapping("/user")
    public List<User> getAllUser() throws Exception {
        return userService.findAll();
    }
}
