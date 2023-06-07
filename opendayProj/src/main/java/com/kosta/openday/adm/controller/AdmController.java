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

	@RequestMapping(value = "/inquiry",method=RequestMethod.GET)
	public String inquiry() {
		return "announceinquiry/inquiry";
	}
	
	@RequestMapping(value = "/inquiryList",method=RequestMethod.GET)
	public String inquiryHistoryList() {
		return "announceinquiry/inquiryList";
	}
	
	@RequestMapping(value = "/inquiryDetail",method=RequestMethod.GET)
	public String inquiryHistoryDetial() {
		return "announceinquiry/inquiryDetail";
	}
	
	@RequestMapping(value = "/announcementList",method=RequestMethod.GET)
	public String announcementList() {
		return "announceinquiry/announcementList";
	}
}
