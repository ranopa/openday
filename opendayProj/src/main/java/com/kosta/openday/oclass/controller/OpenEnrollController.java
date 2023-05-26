package com.kosta.openday.oclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.oclass.dto.OclassDTO;
import com.kosta.openday.oclass.service.OClassService; 

@Controller
public class OpenEnrollController {
	
	private OClassService oclassService;

	@RequestMapping(value = "/classOpen", method = RequestMethod.GET)
	public String classOpenForm() {
		return "classOpen";
	}
	
	@RequestMapping(value = "/classEnrollment", method = RequestMethod.GET)
	public String classEnrollmentForm() {
		return "classEnrollment";
	}
	
	
	@RequestMapping(value = "/classOpen", method = RequestMethod.POST)
	public ModelAndView classOpen(@ModelAttribute OclassDTO dto) {
		ModelAndView mav = new ModelAndView();
		try {
			oclassService.classCreate(dto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/");
		return mav;
	}
	
	
	/*
	 * @RequestMapping(value = "/classOpen", method = RequestMethod.POST) public
	 * ModelAndView classOpen(@ModelAttribute OclassDTO dto,
	 * 
	 * @RequestPart(value="file",required=false) MultipartFile file) { ModelAndView
	 * mav = new ModelAndView(); try { oclassService.classCreate(dto, file); }
	 * catch(Exception e) { e.printStackTrace(); } mav.setViewName("redirect:/");
	 * return mav; }
	 */
	
	
	
	
	
	
	
}
