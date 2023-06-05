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
import com.kosta.openday.user.service.OClassService;

@Controller
public class AdmController {
	@Autowired
	private AdmService admService;

	@Autowired
	private OClassService oClassService;

	@RequestMapping(value = "/adm/", method = RequestMethod.GET)
	public String main(@RequestParam(value = "page", required = false) String page, Model model) {
		model.addAttribute("page", page);
		return "admin/admMain";
	}

	// 개설신청 목록 조회
	@RequestMapping(value = "/adm/adminWatingList", method = RequestMethod.GET)
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

	// 개설 승낙
	@RequestMapping(value = "/adm/adminallow", method = RequestMethod.POST)
	public String allowNewClass(@RequestParam Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			if (oClass == null) 
				throw new Exception("존재하지 않는 클래스");
			
			admService.allowOClass(clsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingList";
	}

	// 개설 거절 
	@RequestMapping(value = "/adm/adminrefuse", method = RequestMethod.POST)
	public String refuseNewClass(@RequestParam Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			if (oClass == null) 
				throw new Exception("존재하지 않는 클래스");
			
			admService.refuseOClass(clsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingList";
	}
	
	@RequestMapping(value="/adm/adminwaitingdetail")
	public String watingDetail(@RequestParam Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			
			model.addAttribute("oClass", oClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingDetail";
	}

	@RequestMapping(value = "/admInquiry", method = RequestMethod.GET)
	public String inquiry() {
		return "announceinquiry/admInquiry";
	}

	@RequestMapping(value = "/admInquiryList", method = RequestMethod.GET)
	public String inquiryHistoryList() {
		return "announceinquiry/admInquiryList";
	}

}
