package com.kosta.openday.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class MainController {

	@Autowired
	private CodeService codeService;

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		try {
			List<CodeDTO> codeList = codeService.categoryInfoList();

			List<CollectDTO> nlist = userService.getMainNewOClassList();

			mav.addObject("nlist", nlist);

			mav.addObject("codeList", codeList);
			mav.setViewName("main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	
	@RequestMapping("/subClassList")
	public ModelAndView subClassList() {
		ModelAndView mav = new ModelAndView();
		try {
			List<CodeDTO> codeList = codeService.categoryInfoList();

			List<CollectDTO> nlist = userService.getMainNewOClassList();

			mav.addObject("nlist", nlist);

			mav.addObject("codeList", codeList);
			mav.setViewName("subClassList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		
	}

}
