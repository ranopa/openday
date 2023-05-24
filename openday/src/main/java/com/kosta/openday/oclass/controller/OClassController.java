package com.kosta.openday.oclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller
public class OClassController {
	
	@RequestMapping(value="/applyclass")
	public String applyClass() {
		return "applyClass";
	}
	@RequestMapping(value="/paymentprocess")
	public String paymentProcess() {
		return "paymentProcess";
	}
}
