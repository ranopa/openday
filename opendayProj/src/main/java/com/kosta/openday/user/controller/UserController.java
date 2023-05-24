package com.kosta.openday.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.oclass.dto.CategoryDTO;
import com.kosta.openday.oclass.service.SbCategoryService;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private SbCategoryService cateService; 
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	//회원가입폼
	@RequestMapping("/joinform")
	public String joinForm() {
		return "mypage/join";
	}

	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinUser(@ModelAttribute UserDTO user) throws Exception {
		try { 
			userService.JoinUser(user); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage/joinResult";
	}

	
	//마이페이지 > 태희언니 헤더 가져오면 지움(테스트용) 
	@RequestMapping(value = "/mypage/", method=RequestMethod.GET)
	public ModelAndView myPayge() {
		ModelAndView mav = new ModelAndView();
		try {
			String id = "sbsb";
			session.setAttribute("id", id); 
			mav.setViewName("mypage/myPage");
		}catch(Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		return mav;
	}
	
	//선호카테고리
	@RequestMapping("/mypage/myprefer") 
	public ModelAndView myPrefer() throws Exception{ 
		ModelAndView mav = new ModelAndView();
		try {
			List<CategoryDTO> list = cateService.getCategoryList();
			mav.addObject("cateNames",list);
			mav.setViewName("mypage/myPreference");
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	//찜한클래스
	@RequestMapping("/mypage/myheart")
	public String df() {
		return "mypage/heart";
	}
	
	//팔로우
	@RequestMapping("/mypage/myfollow")
	public String fddsf() {
		return "mypage/follow";
	}
	
	//예약결제내역
	@RequestMapping("/mypage/reservedrecord")
	public String fdsdf() {
		return "mypage/reservedRecord";	
	}
	

}
