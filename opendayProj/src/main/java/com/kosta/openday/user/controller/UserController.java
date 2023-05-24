package com.kosta.openday.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@RequestMapping("/joinform")
	public String joinForm() {
		return "join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinUser(@ModelAttribute UserDTO user) throws Exception {
		try { 
			System.out.println("success");
			userService.JoinUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "joinviewtest";
	}
}
