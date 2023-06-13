package com.kosta.openday.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.UserDTO;
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
			UserDTO user = (UserDTO)session.getAttribute("userId");
			
			List<CollectDTO> plist = new ArrayList<CollectDTO>();
			
			//<CodeDTO> codeList= codeService.categoryInfoList();
			if (user != null) {
				plist = userService.mainPreferenceOClassList(user.getUserId());
			}
			
			for(CollectDTO c : plist) {
				System.out.println(c.getClsId() + ": " + c.getClsName());
			}
			
			List<CollectDTO> nlist = userService.getMainNewOClassList();
			 List<CollectDTO> hlist = userService.getMainHotOClassList(); 
			 List<CollectDTO> rlist = userService.getMainRequestOClassList();
			 List<CollectDTO> dlist = userService.getMainDeadlineOClassList();
			 mav.addObject("plist", plist);
			 mav.addObject("dlist", dlist);
			 mav.addObject("nlist", nlist);
			 mav.addObject("hlist", hlist); 
			 mav.addObject("rlist", rlist);
			//mav.addObject("codeList", codeList);
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
			//List<CodeDTO> codeList = codeService.categoryInfoList();

			List<CollectDTO> nlist = userService.getMainNewOClassList();

			mav.addObject("nlist", nlist);

			//mav.addObject("codeList", codeList);
			mav.setViewName("subClassList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		
	}

}
