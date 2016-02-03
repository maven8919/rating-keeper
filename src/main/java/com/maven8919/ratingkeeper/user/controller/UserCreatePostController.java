package com.maven8919.ratingkeeper.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maven8919.ratingkeeper.user.model.AddUserRequest;
import com.maven8919.ratingkeeper.user.service.UserService;
import com.maven8919.ratingkeeper.user.transformer.AddUserRequestToUserEntityTransformer;
import com.maven8919.ratingkeeper.user.validation.AddUserRequestValidatior;

@Controller
public class UserCreatePostController {
    
    private UserService userService;
    private AddUserRequestToUserEntityTransformer addUserRequestToUserEntityTransformer;
    private AddUserRequestValidatior addUserRequestValidator;
    
    @Autowired
    public UserCreatePostController(UserService userService, AddUserRequestToUserEntityTransformer addUserRequestToUserEntityTransformer, AddUserRequestValidatior addUserRequestValidator) {
        super();
        this.userService = userService;
        this.addUserRequestToUserEntityTransformer = addUserRequestToUserEntityTransformer;
        this.addUserRequestValidator = addUserRequestValidator;
    }
    
    @InitBinder("addUserRequest")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(addUserRequestValidator);
    }
    
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute(value = "addUserRequest") AddUserRequest addUserRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String result = "redirect:/";
        if (bindingResult.hasErrors()) {
            result = "user-create";
        } else {
            userService.saveUser(addUserRequestToUserEntityTransformer.transform(addUserRequest));
            redirectAttributes.addFlashAttribute("message", String.format("%s saved!", addUserRequest.getUsername()));
        }
        return result;
    }
    
}
