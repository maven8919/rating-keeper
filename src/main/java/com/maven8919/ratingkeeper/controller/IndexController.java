package com.maven8919.ratingkeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final String REQUEST_MAPPING_FOR_INDEX = "/";
	private static final String INDEX_LOGICAL_VIEW = "index";
	
	private Facebook facebook;

	@Autowired
	public IndexController(Facebook facebook) {
        super();
        this.facebook = facebook;
    }
	
	@ModelAttribute(value="name")
	public String facebookName() {
	    return facebook.userOperations().getUserProfile().getFirstName();
	}
	

    @RequestMapping(REQUEST_MAPPING_FOR_INDEX)
	public String index() {
		return INDEX_LOGICAL_VIEW;
	}
}
