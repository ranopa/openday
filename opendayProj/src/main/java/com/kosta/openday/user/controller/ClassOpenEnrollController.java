package com.kosta.openday.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.classOpenEnrollService; 

@Controller
public class ClassOpenEnrollController {
	
	@Autowired
	private classOpenEnrollService classopenenrollService;
	
	@RequestMapping(value = "/classOpen", method = RequestMethod.GET)
	public String classOpenForm() {
		return "classOpenEnrollment/classOpen";
	}
	
	@RequestMapping(value = "/classEnrollment", method = RequestMethod.GET)
	public String classEnrollmentForm() {
		return "classOpenEnrollment/classEnrollment";
	}
	
	
	@RequestMapping(value = "/classOpen", method = RequestMethod.POST)
	public ModelAndView classOpen(@ModelAttribute OClassDTO dto) {
		ModelAndView mav = new ModelAndView();
		try {
			classopenenrollService.classCreate(dto);
			System.out.println(11);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(22);
		}
		mav.setViewName("redirect:/");
		return mav;
	}

}
