package com.kosta.openday.user.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
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
	
	
	@RequestMapping(value="/findid", method=RequestMethod.POST)
	public ModelAndView getUserFindId(@RequestParam("userEmail") String userEmail) {
		ModelAndView mav = new ModelAndView();
		try {
			
			UserDTO findId = userService.getUserFindId(userEmail);
			mav.addObject("findId",findId);
			mav.setViewName("/login/idConfirm");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mav;
	}
	
	
	  @RequestMapping(value="/findpw", method=RequestMethod.POST) 
	  public ModelAndView getUserFindPw(@RequestParam("userId") String userId,@RequestParam("userEmail") String userEmail)
	  {
	  System.out.println(userEmail);
	  
	  ModelAndView mav = new ModelAndView(); 
	 
	  try {
	 
		  UserDTO findPw = userService.getUserFindPw(userId, userEmail);
	  
	  mav.addObject("findPw",findPw);
	  mav.setViewName("/login/pwConfirm");
	  
	  } 
	  catch (Exception e) 
	  { 
		  e.printStackTrace();
	  
	  } 
	  
	  return mav; 
	  
	  }
	 
	
	
	/*
	 * @RequestMapping(value="findpw", method=RequestMethod.POST) public
	 * ModelAndView getUserFindPw(@RequestParam("userId") String
	 * userId,@RequestParam("userEmail") String userEmail) { ModelAndView mav = new
	 * ModelAndView(); } try { UserDTO user = userService.getUserFindPw(userId,
	 * userEmail); if (user != null) { // If user exists, generate a new password
	 * String newPassword = UUID.randomUUID().toString().substring(0, 8); // Or use
	 * a better password generation method user.setPassword(newPassword);
	 * userService.getResetPassword(user);
	 * 
	 * // TODO: Send the new password to user's email. This is beyond the scope of
	 * this example.
	 * 
	 * mav.addObject("message", "A new password has been sent to your email.");
	 * mav.setViewName("pwConfirm"); // Or wherever you want to redirect } else {
	 * mav.addObject("message", "No account found with that email address.");
	 * mav.setViewName("findPw"); // Or wherever you want to redirect }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * 
	 * } return mav; }
	 */
	 


}	

