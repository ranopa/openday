package com.kosta.openday.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/findid", method = RequestMethod.GET)
	public String findId(){
		return "/login/findId";
	}
	
	@RequestMapping(value="/findpw", method = RequestMethod.GET)
	public String findPw(){
		return "/login/findPw";
	}
	@RequestMapping(value="/idconfirm", method = RequestMethod.GET)
	public String idConfirm(){
		return "/login/idConfirm";
	}
}
