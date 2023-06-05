package com.kosta.openday.adm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.openday.adm.service.AdmService;
import com.kosta.openday.user.dto.OClassDTO; 

@Controller
public class AdmController {
	@Autowired
	private AdmService admService;
	
	@RequestMapping(value = "/adm/", method = RequestMethod.GET)
	public String main(@RequestParam(value = "page", required = false) String page, Model model) {
		model.addAttribute("page", page);
		return "admin/admMain"; 
	}
	
	@RequestMapping(value="/adm/adminWatingList", method=RequestMethod.GET)
	public String watingList(Model model) {
		String status = "승인대기";
		try {
			List<OClassDTO> watingOClassList = admService.findOClassByStatus(status);
			model.addAttribute("list", watingOClassList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "admin/adminWaitingList";
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
