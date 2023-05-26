package com.kosta.openday.adm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

@Controller
public class AdmController {
	@RequestMapping(value = "/announcementList",method=RequestMethod.GET)
	public String noticeList() {
		return "announceinquiry/announcementList";
	}
}
