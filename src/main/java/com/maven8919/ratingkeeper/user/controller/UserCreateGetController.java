package com.maven8919.ratingkeeper.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maven8919.ratingkeeper.user.model.AddUserRequest;

@Controller
public class UserCreateGetController {
    
    @ModelAttribute(value = "addUserRequest")
    public AddUserRequest addUserRequest() {
        return new AddUserRequest();
    }
    
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String userCreatePage() {
        return "user-create";
    }
}
