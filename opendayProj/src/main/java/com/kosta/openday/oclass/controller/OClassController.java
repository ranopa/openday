package com.kosta.openday.oclass.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView; 

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.RequestDTO;
import com.kosta.openday.user.dto.UserDTO; 

import com.kosta.openday.oclass.service.OClassService;

@Controller
public class OClassController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private OClassService oClassService;
	
	/**
	 *  클래스 상세 화면에서, "신청하기" 버튼 클릭 시
	 * */
	@RequestMapping(value="/apply")
	public String applyClass(@RequestParam("clsId") Integer id, Model model) {
		try {
			OClassDTO oclass = oClassService.findOne(id);
			List<ScheduleDTO> scheduels = oClassService.findScheduleByClassId(oclass.getClsId());
			
			model.addAttribute("oclass", oclass);
			model.addAttribute("schedules", scheduels);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "apply/applyClass";
	}
	
	/**
	 * 클래스 신청 화면에서, "다음으로" 버튼 클릭 시
	 * */
	@RequestMapping(value="/paymentProcess")
	public String paymentProcess() {
		return "apply/paymentProcess";
	}
	
	/**
	 * 클래스 결제정보 확인 화면에서, "결제하기 버튼 클릭 시
	 * */
	@RequestMapping(value="/payment")
	public String payment() {
		return "apply/paymentResult";
	}

	@RequestMapping(value = "/requestwrite", method=RequestMethod.GET)
	public String requestWriteForm() {
		return "requestboard/requestWrite";
		
	}
	@RequestMapping(value = "/requestwrite", method=RequestMethod.POST)
	public String requestWrite(@RequestParam("location") String location,
			@RequestParam("title") String title, @RequestParam("content") String content) {
		RequestDTO request = new RequestDTO();
		request.setReqTitle(title);
		request.setReqContent(content);
		request.setReqLocation(location);
		request.setUserId("jane");
		try {
			oClassService.requestClass(request);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/requestlist";
		
	}
	@RequestMapping(value = "/requestlist", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView requestList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("requestboard/requestList");
		try {
			List<RequestDTO> requestList =  oClassService.getRequestList();
			mav.addObject("requestList", requestList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "/requestdetail", method=RequestMethod.GET)
	public ModelAndView requestDetail(@RequestParam("reqId") Integer reqId) {
		ModelAndView mav = new ModelAndView("requestboard/requestDetail");
		
		UserDTO user = new UserDTO();
		user.setUserId("jane");
		user.setAuthority("1");
		session.setAttribute("user", user);
		try {
			RequestDTO request = oClassService.getRequest(reqId);
			Integer partpaCnt = oClassService.getPartpaCntByReqId(reqId);
			mav.addObject("request", request);
			mav.addObject("partpaCnt", partpaCnt);
			mav.addObject("partpaYN",oClassService.getPartPaYN(user.getUserId(), reqId));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/modrequest", method=RequestMethod.POST,produces="application/json; charset=utf-8")
	public ResponseEntity<String> modifyRequest(@ModelAttribute RequestDTO request, HttpServletResponse response) {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try {
			oClassService.modifyRequest(request);
			return new ResponseEntity<String>("클래스 개설 요청이 수정되었습니다.", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("클래스 개설 요청이 수정을 실패했습니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/delrequest", method=RequestMethod.GET)
	public String deleteRequest(@RequestParam("reqId") Integer reqId) {
		try {
			oClassService.removeRequest(reqId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/requestlist";
	}
	
	@ResponseBody
	@RequestMapping(value="/participation", method=RequestMethod.POST) 
	public ResponseEntity<String> participation(@RequestParam("reqId") Integer reqId) {
		System.out.println(reqId);
		try {
			UserDTO user = (UserDTO)session.getAttribute("user");
			Boolean yn = oClassService.coupleParticipation(user.getUserId(), reqId);
			return new ResponseEntity<String>(String.valueOf(yn), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
