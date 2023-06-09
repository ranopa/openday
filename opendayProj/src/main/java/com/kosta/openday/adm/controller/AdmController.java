package com.kosta.openday.adm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.service.AdmService;
import com.kosta.openday.user.dto.UserDTO; 

@Controller
public class AdmController {
	@Autowired
	private AdmService admService;
	
	@RequestMapping(value = "/adm/", method = RequestMethod.GET)
	public String main(@RequestParam(value = "page", required = false) String page, Model model) {
		model.addAttribute("page", page);
		return "admin/admMain"; 
	}

	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public String inquiryForm(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    UserDTO user = (UserDTO) session.getAttribute("userId");
	    if (user == null) {
	        // 로그인되어 있지 않으면 로그인 페이지로 이동
	        return "redirect:/loginform";
	    }
	    
	    return "announceinquiry/inquiry";
	}
	
	@RequestMapping(value="/inquiry", method=RequestMethod.POST)
	public ModelAndView inquiry(@ModelAttribute AdmInquiryDTO admInquiryDTO, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		try {
			UserDTO user = (UserDTO)session.getAttribute("userId");
			System.out.println(user.getUserId());
			admInquiryDTO.setUserId(user.getUserId());
			admService.inquiryInsert(admInquiryDTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/inquiryList");
		return mav;
	}
	
	@RequestMapping(value = "/inquiryList")
	public ModelAndView inquiryHistoryList() {
		ModelAndView mav = new ModelAndView();
		try {
			List<AdmInquiryDTO> AdmInquiryDTO = admService.inquiryListSelect();
			mav.addObject("ilist", AdmInquiryDTO);
			mav.setViewName("announceinquiry/inquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "/inquiryUpdate", method=RequestMethod.POST )
	public ModelAndView inquiryUpdate(@RequestParam("admNum") Integer admNum, @RequestParam("admTitle") String admTitle,
									  @RequestParam("admContent") String admContent)  {
		ModelAndView mav = new ModelAndView();
		try {
			admService.inquiryUpdate(admNum, admTitle, admContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/announceinquiry/inquiryDetail");
		return mav;
	}
	
	@RequestMapping(value = "/inquiryDelete",method=RequestMethod.GET)
	public ModelAndView inquiryDelete(@RequestParam("admNum") Integer admNum) {
		ModelAndView mav = new ModelAndView();
		try {
			admService.inquiryDelete(admNum);
			mav.setViewName("redirect:/announceinquiry/inquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "/inquiryDetail",method=RequestMethod.GET)
	public String inquiryHistoryDetial() {
		return "announceinquiry/inquiryDetail";
	}
	
	@RequestMapping(value = "/announcementList",method=RequestMethod.GET)
	public String announcementList() {
		return "announceinquiry/announcementList";
	}
	
	@RequestMapping(value = "/announcementDetail",method=RequestMethod.GET)
	public String announcementDetail() {
		return "announceinquiry/announcementDetail";
	}
}
