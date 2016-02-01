package com.maven8919.ratingkeeper.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final String REQUEST_MAPPING_FOR_INDEX = "/";
	private static final String INDEX_LOGICAL_VIEW = "index";
	
    @RequestMapping(REQUEST_MAPPING_FOR_INDEX)
    public String index() {
		return INDEX_LOGICAL_VIEW;
	}
}
