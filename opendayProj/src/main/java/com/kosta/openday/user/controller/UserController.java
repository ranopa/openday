package com.kosta.openday.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private CodeService codeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;


	// 회원가입폼
	@RequestMapping("/joinform")
	public String joinForm() {
		return "mypage/join";
	}

	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinUser(@ModelAttribute UserDTO user) throws Exception {
		try {
			userService.joinUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage/joinResult";
	}

	// 회원가입 id중복확인
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(@RequestParam("userId") String id, @RequestParam("userPassword") String pw) throws Exception {
		System.out.println("success");
		int result = userService.idCheck(id);
		String mesg = "사용가능한 아이디입니다.";
		if (result == 1) {
			mesg = "이미 존재하는 아이디입니다.";
		}
		return mesg;
	}

	// 마이페이지 (테스트용)
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public ModelAndView myPage() {
		ModelAndView mav = new ModelAndView("mypage/myMain");
		try {
			String id = "sbsb";
			session.setAttribute("id", id);
			UserDTO user = userService.getUserInfo(id);
			mav.addObject("user", user);
			mav.addObject("page","myPage");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return mav;
	}

	// 프로필수정
	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public ModelAndView editProfile(HttpSession session,
			@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "nickname", required = false) String nickname,
			@RequestParam(value = "tel", required = false) String tel) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		try {
			String id = (String) session.getAttribute("id");

			UserDTO user = userService.getUserInfo(id);

			map.put("id", id);
			map.put("nickname", nickname);
			map.put("tel", tel);

			if (nickname.isEmpty()) {
				map.put("nickname", user.getUserNickname());
			}
			if (tel.isEmpty()) {
				map.put("tel", user.getUserTel());
			}
			if (file.isEmpty()) {
				map.put("filNum", user.getFilNum());
			}

			userService.editUserProfile(map, file);
			
			// mav.addObject("user", user);
			mav.setViewName("redirect:/mypage");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 선호카테고리
	@RequestMapping("/myprefer")
	public ModelAndView myPrefer(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			List<CodeDTO> list = codeService.categoryInfoList();

			// + 유저의 선호카테고리
			String id = (String) session.getAttribute("id");
			UserDTO user = userService.getUserInfo(id);
			if (user.getUserPrefer() != null) {
				mav.addObject("user", user);
			}
			mav.addObject("cateNames", list);
			mav.setViewName("mypage/myPreference");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/img/{filNum}", method = RequestMethod.GET)
	public void image(@PathVariable("filNum") Integer filNum, HttpServletResponse response) {
		try {
			System.out.println("seucess");
			userService.fileView(filNum, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 찜한클래스
	@RequestMapping("/myheart")
	public ModelAndView heart(){
		ModelAndView mav = new ModelAndView("mypage/myMain");
		try {
			String userId = (String)session.getAttribute("id");
			List<CollectDTO> list = userService.HeartOClass(userId);  
			mav.addObject("heartList",list);
			mav.addObject("page","heart");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 팔로우
	@RequestMapping("/mypage/myfollow")
	public String fddsf() {
		return "mypage/follow";
	}

	// 예약결제내역
	@RequestMapping("/mypage/reservedrecord")
	public String sdfsdf() {
		return "mypage/reservedRecord";
	}
	
	//찜목록 -> 클래스 상세 
//	@RequestMapping(" /classinfo/{clsId}")
//	public ModelAndView classInfoFromHeart(@PathVariable("clsId") Integer clsId) {
//		ModelAndView mav = new ModelAndView("mypage/myMain");
//		try {
//			
//		}catch(){
//			
//		}
//		
//		return mav;
//	}
	//찜 제거
	
	// 선호카테고리 수정하기
	@RequestMapping(value = "/prefer", method = RequestMethod.POST)
//	public ModelAndView preferUpload(HttpSession session, @RequestParam("checkboxGroup") String c1, @RequestParam("checkboxGroup") String c2, @RequestParam("checkboxGroup") String c3) {
	public ModelAndView preferUpload(HttpSession session,
			@RequestParam(value = "checkboxGroup1", required = false) String c1,
			@RequestParam(value = "checkboxGroup2", required = false) String c2,
			@RequestParam(value = "checkboxGroup3", required = false) String c3) {

		ModelAndView mav = new ModelAndView();
		try {
			System.out.println(c1 + c2 + c3);
//			mav.addObject("cateNames",user);

			mav.setViewName("redirect:/myprefer");
			// 변경, 받아오고 리다이렉

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String userWithdraw() throws Exception {
		String id = (String) session.getAttribute("id");
		userService.withdrawUser(id);
		return "redirect:/";
	}
	


}
