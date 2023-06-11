package com.kosta.openday.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.MyRecordDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.OClassService;
import com.kosta.openday.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private CodeService codeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private OClassService oClassService;

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
	public String idCheck(@RequestParam("userId") String id) throws Exception {
		 
		
		int result = userService.idCheck(id);
		String mesg = "0";
		if (result == 1) {
			mesg = "1";
		}
		System.out.println(mesg);
		return mesg;
	}
	
	// 회원가입 닉네임 중복확인
		@RequestMapping(value = "/nicknamecheck", method = RequestMethod.GET)
		@ResponseBody
		public String nickNameCheck(@RequestParam("userNickname") String userNickname) throws Exception {
			System.out.println(userNickname);
			String mesg = null;
			UserDTO user = userService.userByNickname(userNickname); 
			if (user.getUserNickname().equals(userNickname)==true) {
				mesg = "1"; //불가능
			} else { 
				mesg = "0"; //가능
			}
			System.out.println(mesg);
			return mesg;
		}

	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public ModelAndView myPage() {
		ModelAndView mav = new ModelAndView("mypage/myMain");
		try {

			UserDTO user = (UserDTO)session.getAttribute("userId");
			mav.addObject("user", user);
			mav.addObject("page","myPage");

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return mav;
	}

	// 프로필수정
	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public ModelAndView editProfile(@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "nickname", required = false) String nickname,
			@RequestParam(value = "tel", required = false) String tel) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		try {
			UserDTO user = (UserDTO)session.getAttribute("userId");
			
			map.put("id", user.getUserId());
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
	public ModelAndView myPrefer() throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			List<CodeDTO> list = codeService.categoryInfoList();

			// + 유저의 선호카테고리
			UserDTO user = (UserDTO)session.getAttribute("userId");
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
			UserDTO user = (UserDTO)session.getAttribute("userId");
			List<CollectDTO> list = userService.HeartOClass(user.getUserId());  
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
	@RequestMapping(value = "/reservedrecord", method=RequestMethod.GET)
	public ModelAndView reservedList() {
		 ModelAndView mav = new  ModelAndView("mypage/myMain");
		 try {
			 UserDTO user = (UserDTO)session.getAttribute("userId");
			 String text = "수강예정"; 
			 List<MyRecordDTO> list = userService.getReservedList(user.getUserId(),text);
			 mav.addObject("page","reservedRecord");
			 mav.addObject("reservedList",list);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return mav; 
	}
	//ajax로 받아온 신청/수강/환불내역 요청   
	@RequestMapping(value = "/reservedmenuselect",  method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<MyRecordDTO> getData(@RequestParam(value="h2Text") String h2Text) {
		UserDTO user = (UserDTO)session.getAttribute("userId");
		String text = null;
		List<MyRecordDTO> reservedList = null; 
		try {
			if(h2Text.equals("신청내역")) text = "수강예정";
			else if(h2Text.equals("수강내역")) text ="수강완료";
			else text="수강취소"; 
			reservedList= userService.getReservedList(user.getUserId(),text);  
			System.out.println(reservedList.isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		} 
        return reservedList;
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
	@RequestMapping(value = "/removeheart", method=RequestMethod.POST)
	public String removeHeart(@RequestParam("clsId") String clsIdStr) {  
		try {
			Integer clsId = Integer.parseInt(clsIdStr);
			 UserDTO user = (UserDTO)session.getAttribute("userId");
			userService.removeHeart(clsId,user.getUserId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/myheart";
	}
	
	//찜 추가
	@RequestMapping(value = "/addheart", method=RequestMethod.POST)
	public String addHeart(@RequestParam("clsId") String clsIdStr) {  
		try {
			Integer clsId = Integer.parseInt(clsIdStr);
			 UserDTO user = (UserDTO)session.getAttribute("userId");
			userService.addHeart(clsId,user.getUserId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/myheart";
	}
	//class정보페이지로 이동
	@RequestMapping(value = "/toclassinfofrommy/{clsNum}", method = RequestMethod.GET)
	public ModelAndView toclassInfoFromMy(@PathVariable Integer clsNum) {
		ModelAndView mav = new ModelAndView();
		try { 
			OClassDTO oclass = oClassService.findOne(clsNum); 
			mav.addObject("oclass",oclass);
			mav.setViewName("classinfo/classInfo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	//follow 강사 목록 보기
	@RequestMapping(value = "/myfollow", method = RequestMethod.GET)
	public ModelAndView followList() {
		ModelAndView mav = new ModelAndView("mypage/myMain");
		 UserDTO user = (UserDTO)session.getAttribute("userId");
		try {
			List<TeacherChannelDTO> tchcList = userService.getTchcList(user.getUserId()); 
			mav.addObject("tchcList",tchcList);
			mav.addObject("page","follow");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	//follow 강사 목록 보기
//		@RequestMapping(value = "/totchcchannel/{tchcNum}", method = RequestMethod.GET)
//		public ModelAndView toTchcChannel(@PathVariable String tchcNum) {
//			ModelAndView mav = new ModelAndView();
//			try {
//				//getTchcChannel 만들어야함
//				TeacherChannelDTO tchcChannel = userService.getTchcChannel(tchcNum); 
//				mav.addObject("tchcList",tchcList);
//				mav.addObject("page","채널jsp");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return mav;
//		}
	
	
	
	// 선호카테고리 수정하기
	@RequestMapping(value = "/prefer", method = RequestMethod.POST)
//	public ModelAndView preferUpload(HttpSession session, @RequestParam("checkboxGroup") String c1, @RequestParam("checkboxGroup") String c2, @RequestParam("checkboxGroup") String c3) {
	public ModelAndView preferUpload( @RequestParam(value = "checkboxGroup1", required = false) String c1,
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
	
	//회원탈퇴
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String userWithdraw() throws Exception {
		UserDTO user = (UserDTO)session.getAttribute("userId");
		userService.withdrawUser(user.getUserId());
		session.removeAttribute("userId");
		return "redirect:/";
	}
	


}
