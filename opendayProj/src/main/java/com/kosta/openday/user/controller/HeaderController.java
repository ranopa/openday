package com.kosta.openday.user.controller;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class HeaderController {
	@Autowired
	private HttpSession session;

	@Autowired
	UserService userService;
	
	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String login() {
		return "/login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam Map<String, String> map, HttpSession session) throws Exception {

		ModelAndView mav = new ModelAndView();
		try {
			UserDTO user = userService.userLogin(map);
			mav.setViewName("redirect:/");

			session.setAttribute("userId", user);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			mav.setViewName("/login/login");
		}
		return mav;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}

	// 검색필터
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView getSearchOClass(@RequestParam("scdLoc") String scdLoc,
			@RequestParam(value="startDate", required = false, defaultValue = "all") String startDate,
			@RequestParam(value="endDate", required = false, defaultValue = "all") String endDate,
			@RequestParam("clsCode") String clsCode) {
		
		Date sqlStartDate = null;
		Date sqlEndDate = null;
		if(!startDate.equals("all")) {
			String[] start = startDate.split("-");
			String[] end = endDate.split("-");
			
			sqlStartDate = Date.valueOf(start[2]+"-"+start[1]+"-"+start[0]);
			sqlEndDate = Date.valueOf(end[2]+"-"+end[1]+"-"+end[0]);
			
		}
		
		ModelAndView mav = new ModelAndView();
		try {
			  List<CollectDTO> collectList = userService.getSearchOClass(scdLoc,
					  sqlStartDate, sqlEndDate, clsCode); 
			  System.out.println(collectList.size());
			  mav.addObject("collectList", collectList);
			  List<CodeDTO> codeList= codeService.categoryInfoList();
			  mav.addObject("codeList", codeList);
			  mav.setViewName("subClassList");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mav;
	}

}
