package com.maven8919.ratingkeeper.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maven8919.ratingkeeper.user.model.AddUserRequest;
import com.maven8919.ratingkeeper.user.service.UserService;
import com.maven8919.ratingkeeper.user.transformer.AddUserRequestToUserEntityTransformer;

@Controller
public class UserCreatePostController {
    
    private UserService userService;
    private AddUserRequestToUserEntityTransformer addUserRequestToUserEntityTransformer;
    
    @Autowired
    public UserCreatePostController(UserService userService, AddUserRequestToUserEntityTransformer addUserRequestToUserEntityTransformer) {
        super();
        this.userService = userService;
        this.addUserRequestToUserEntityTransformer = addUserRequestToUserEntityTransformer;
    }

    @ModelAttribute(value = "addUserRequest")
    public AddUserRequest createListUsersModel() {
        return new AddUserRequest();
    }
    
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createUser(@Valid AddUserRequest addUserRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String result = "redirect:/";
        if (bindingResult.hasErrors()) {
            System.out.println("Has errors!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            result = "/";
        }
        userService.saveUser(addUserRequestToUserEntityTransformer.transform(addUserRequest));
        redirectAttributes.addFlashAttribute("message", String.format("%s saved!", addUserRequest.getUsername()));
        return result;
    }
    
}
