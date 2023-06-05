package com.kosta.openday.adm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 

@Controller
public class AdmController {
	
	@RequestMapping(value = "/adm/", method = RequestMethod.GET)
	public String main(@RequestParam(value = "page", required = false) String page, Model model) {
		model.addAttribute("page", page);
		return "admin/admMain"; 
	}

	@RequestMapping(value = "/admInquiry",method=RequestMethod.GET)
	public String inquiry() {
		return "announceinquiry/admInquiry";
	}
	
	@RequestMapping(value = "/admInquiryList",method=RequestMethod.GET)
	public String inquiryHistoryList() {
		return "announceinquiry/admInquiryList";
	}
}
