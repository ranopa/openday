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
import org.springframework.web.bind.annotation.ResponseBody;
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

	@ResponseBody
	@RequestMapping(value = "/categorylist", method = RequestMethod.POST)
	public List<CodeDTO> categoryList() {
		List<CodeDTO> codeList = null;
		try {
			codeList = codeService.categoryInfoList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return codeList;
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

	//강사 클래스 검색
	@RequestMapping(value = "/searchinput", method = RequestMethod.GET)
	public ModelAndView getSearchInputOClass(@RequestParam("keyword") String keyword) {
		System.out.println(keyword);
		ModelAndView mav = new ModelAndView();
		try {
			List<CollectDTO> searchInputList = userService.getSearchInputOClass(keyword);
			mav.addObject("searchInputList",searchInputList);
			 mav.setViewName("toSubClassList");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mav;
	}
	
	/* 메인 매뉴 클릭시 */
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ModelAndView getMainMenuOClassList(@RequestParam("codNum") String codNum) {
	
		ModelAndView mav = new ModelAndView();
		try {
			
			List<CollectDTO> hMenuList = userService.getMainMenuOClassList(codNum);
			String hcn = hMenuList.get(0).getCodName();
			System.out.println(hcn);
		
			mav.addObject("hcn", hcn);
			mav.addObject("hMenuList",hMenuList);
			 mav.setViewName("menu");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mav;
	}
	
	
	
	// 검색필터
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView getSearchOClass(@RequestParam("clsLoc") String clsLoc,
			@RequestParam(value="startDate", required = false, defaultValue = "all") String startDate,
			@RequestParam(value="endDate", required = false, defaultValue = "all") String endDate,
			@RequestParam("clsCode") String clsCode 
			) {

		Date sqlStartDate = null;
		Date sqlEndDate = null;
		if(!startDate.equals("all")) {
			String[] start = startDate.split("-");
			String[] end = endDate.split("-");
			
			/*
			 * sqlStartDate = Date.valueOf(start[2]+"-"+start[1]+"-"+start[0]); sqlEndDate =
			 * Date.valueOf(end[2]+"-"+end[1]+"-"+end[0]);
			 */
			sqlStartDate = Date.valueOf(start[0]+"-"+start[1]+"-"+start[2]);
			sqlEndDate = Date.valueOf(end[0]+"-"+end[1]+"-"+end[2]);
		}
		
		ModelAndView mav = new ModelAndView();
		try {
			  List<CollectDTO> collectList = userService.getSearchOClass(clsLoc,
					  sqlStartDate, sqlEndDate, clsCode); 
			 // System.out.println(collectList.size());
			  mav.addObject("collectList", collectList);
			 
			  
			  
			 // List<CodeDTO> codeList= codeService.categoryInfoList();
			  //mav.addObject("codeList", codeList);
			  mav.setViewName("subClassList");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mav;
	}

}
