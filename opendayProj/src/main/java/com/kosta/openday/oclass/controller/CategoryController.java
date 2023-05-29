package com.kosta.openday.oclass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosta.openday.oclass.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	HttpSession session;
	
	
	
	
}
