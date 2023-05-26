package com.kosta.openday.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.classOpenEnrollService; 

@Controller
public class ClassOpenEnrollController {
	
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/");
		return mav;
	}

}
