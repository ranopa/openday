package com.kosta.openday.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.teacher.service.TeacherService; 

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/tcHome")
	public ModelAndView tcHome() {
		ModelAndView mav = new ModelAndView("teacher/tcHome");
		
		try {
			mav.addObject("tcAnlist",teacherService.tcAnnouncement());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/tcClass")
	public ModelAndView tcClass() {
		ModelAndView mav = new ModelAndView("teacher/tcClass");
		
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
