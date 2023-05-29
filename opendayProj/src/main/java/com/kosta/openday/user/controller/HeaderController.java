package com.kosta.openday.user.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class HeaderController {
	@Autowired
	private HttpSession session;

	@Autowired
	UserService userService;

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
	            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
	            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
	            @RequestParam("clsCode") String clsCode)
	            {
			ModelAndView mav = new ModelAndView();
			try {
				List<OClassDTO> oclassList = userService.getSearchOClass(scdLoc, startDate, endDate, clsCode);
				mav.addObject("oclassList", oclassList);
		        mav.setViewName("subClassList");
			} catch (Exception e) {
				e.printStackTrace();

			}
			  return mav;
		}
	
}
