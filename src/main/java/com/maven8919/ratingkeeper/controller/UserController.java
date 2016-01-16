package com.maven8919.ratingkeeper.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@ModelAttribute("user")
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/user")
	public String userView() {
		return "user";
	}
	
}
