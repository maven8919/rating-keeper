package com.maven8919.ratingkeeper.user.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maven8919.ratingkeeper.user.domain.UserEntity;
import com.maven8919.ratingkeeper.user.service.UserService;

@Controller
public class ListAllUsersController {

    private UserService userService;

    @Autowired
    public ListAllUsersController(UserService userService) {
        super();
        this.userService = userService;
    }
    
    @ModelAttribute(value = "users")
    public Collection<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @RequestMapping("/users")
    public String getUsersPage() {
        return "users";
    }
    
}
