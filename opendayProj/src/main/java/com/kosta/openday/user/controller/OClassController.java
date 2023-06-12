package com.kosta.openday.user.controller;
 
import java.util.List;  
import java.util.Map; 
import java.util.Properties;
import java.util.ResourceBundle; 
import java.util.Map; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.NotificationSourceType;
import com.kosta.openday.adm.service.NotificationService;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.ApplicationPaymentDTO;
import com.kosta.openday.user.dto.ApplyClassResponseDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.PageInfo;
import com.kosta.openday.user.dto.PaymentProcessDTO;
import com.kosta.openday.user.dto.PaymentProcessResponseDTO;
import com.kosta.openday.user.dto.PaymentRequestDTO;
import com.kosta.openday.user.dto.PaymentResultDTO;
import com.kosta.openday.user.dto.RequestDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.OClassService;
import com.kosta.openday.user.service.PaymentService;
import com.kosta.openday.user.service.UserService;

@Controller
public class OClassController {
	@Autowired
	private HttpSession session;

	@Autowired
	private OClassService oClassService;

	@Autowired
	private UserService userService;

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private NotificationService notiService;

	/**
	 * 클래스 상세 화면에서, "신청하기" 버튼 클릭 시
	 */
	@RequestMapping(value = "/apply")
	public String applyClass(@RequestParam("clsId") Integer id, Model model) {
		try {
			ApplyClassResponseDTO applyClassDto = oClassService.getApplyClassResponse(id);

			model.addAttribute("data", applyClassDto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "apply/applyClass";
	}

	/**
	 * 클래스 신청 화면에서, "다음으로" 버튼 클릭 시
	 */
	@RequestMapping(value = "/paymentProcess", method = RequestMethod.POST)
	public String paymentProcess(PaymentProcessDTO paymentProcessDto, Model model) {
		try {
			// 신청한 클래스 정보
			Integer clsId = paymentProcessDto.getClsId();
			OClassDTO oClass = oClassService.findOne(clsId);
			// 해당 클래스의 일정 정보
			Integer scdNum = paymentProcessDto.getScdNum();
			ScheduleDTO schedule = oClassService.findScheduleById(scdNum);

			ResourceBundle rd = ResourceBundle.getBundle("config/payment");
			String storeIdCode = rd.getString("portone.storeIdCode");
			String kakaopayCID = rd.getString("portone.kakaopayCID");
			
			if (oClass == null || schedule == null) {
				throw new Exception("oClass or schedule not found");
			}

			// todo: userid session에서 읽어오는걸로 대체
			String userId = "kkm";
			UserDTO user = userService.getUserInfo(userId);

			Integer applyPersonnel = paymentProcessDto.getApplyPersonnel();

			PaymentProcessResponseDTO responseDto = new PaymentProcessResponseDTO(user, oClass, schedule,
					applyPersonnel);

			model.addAttribute("data", responseDto);
			model.addAttribute("storeIdCode", storeIdCode);
			model.addAttribute("kakaopayCID", kakaopayCID);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "apply/paymentProcess";
	}

	/**
	 * 클래스 결제정보 확인 화면에서, "결제하기 버튼 클릭 시
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(PaymentRequestDTO paymentRequest, Model model) {
		try {
			Integer apNum = paymentService.doPay(paymentRequest);

			ApplicationPaymentDTO payment = paymentService.findOne(apNum);

			PaymentResultDTO paymentResult = paymentService.buildPaymentResult(payment);
			
			model.addAttribute("result", paymentResult);
			
			// 알림 생성 
			notiService.createNotification(null, NotificationSourceType.OCLASS_APPLY_DONE, "", "", payment.getUserId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "apply/paymentResult";
	}

	@RequestMapping(value = "/requestwrite", method = RequestMethod.GET)
	public String requestWriteForm() {
		return "requestboard/requestWrite";

	}

	@RequestMapping(value = "/requestwrite", method = RequestMethod.POST)
	public String requestWrite(@RequestParam("location") String location, @RequestParam("title") String title,
			@RequestParam("content") String content) {
		RequestDTO request = new RequestDTO();
		request.setReqTitle(title);
		request.setReqContent(content);
		request.setReqLocation(location);
		UserDTO user = (UserDTO)session.getAttribute("userId");
		request.setUserId(user.getUserId());
		try {
			oClassService.requestClass(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/requestlist";

	}

	@RequestMapping(value = "/requestlist", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView requestList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		ModelAndView mav = new ModelAndView();
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCurPage(page);
		mav.setViewName("requestboard/requestList");
		try { 
			List<RequestDTO> requestList = oClassService.getRequestList(pageInfo); 
			mav.addObject("requestList", requestList);
			mav.addObject("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/requestdetail", method = RequestMethod.GET)
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
			mav.addObject("partpaYN", oClassService.getPartPaYN(user.getUserId(), reqId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/modrequest", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ResponseEntity<String> modifyRequest(@ModelAttribute RequestDTO request, HttpServletResponse response) {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try {
			oClassService.modifyRequest(request);
			return new ResponseEntity<String>("클래스 개설 요청이 수정되었습니다.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("클래스 개설 요청이 수정을 실패했습니다.", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delrequest", method = RequestMethod.GET)
	public String deleteRequest(@RequestParam("reqId") Integer reqId) {
		try {
			oClassService.removeRequest(reqId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/requestlist";
	}

	@ResponseBody
	@RequestMapping(value = "/participation", method = RequestMethod.POST)
	public ResponseEntity<String> participation(@RequestParam("reqId") Integer reqId) {
		try {
			UserDTO user = (UserDTO) session.getAttribute("user");
			Boolean yn = oClassService.coupleParticipation(user.getUserId(), reqId);
			return new ResponseEntity<String>(String.valueOf(yn), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	} 
	
	@ResponseBody
	@RequestMapping(value="/heart", method=RequestMethod.POST)
	public ResponseEntity<Integer> heart(@RequestParam("clsId") Integer clsId) {
		try {
			UserDTO user = (UserDTO)session.getAttribute("user");
//			Integer heartCnt = oClassService.toggleHeartSchedule(clsId, user.getUserId());
			Integer heartCnt = oClassService.toggleHeartSchedule(clsId, "jane");
			return new ResponseEntity<Integer>(heartCnt, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/classinfo/{clsId}", method=RequestMethod.GET)
	public ModelAndView classInfo(@PathVariable(value="clsId") Integer clsId) {
  
		ModelAndView mav = new ModelAndView("classinfo/classInfo");
		try { 
			//로그인 처리 완료후 삭제
			UserDTO user = new UserDTO();
			user.setUserId("jane");
			session.setAttribute("user", user);
			
			//로그인 처리 완료후 주석 풀기
			//UserDTO user = (UserDTO)session.getAttribute("user");
			
			Map<String,Object> result = oClassService.getOclassDetail(clsId, user.getUserId());
  
			mav.addObject("res", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/clsinquiry", method=RequestMethod.POST ,produces="application/json; charset=utf-8")
	public ResponseEntity<String> clsInquiry(@RequestParam("ciContent") String ciContent, 
				@RequestParam(value="ciSecret", required = false, defaultValue = "false") String ciSecret, 
				@RequestParam("clsId") Integer clsId) {
		System.out.println(ciContent);
		try {
			UserDTO user = (UserDTO)session.getAttribute("user");
			oClassService.clsInquiry(ciContent, ciSecret, clsId, user.getUserId());
			return new ResponseEntity<String>("문의하였습니다.", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("문의에 에러가 발생했습니다.", HttpStatus.BAD_REQUEST);
		}
	}
 
	@ResponseBody
	@RequestMapping(value="/modClsInquiry", method=RequestMethod.POST ,produces="application/json; charset=utf-8")
	public ResponseEntity<String> modClsInquiry(@RequestParam("ciContent") String ciContent, 
				@RequestParam(value="ciSecret", required = false, defaultValue = "false") String ciSecret, 
				@RequestParam("ciNum") Integer ciNum) {
		System.out.println(ciSecret);
		try {
			oClassService.modifyClsInquiry(ciContent, ciSecret, ciNum);
			return new ResponseEntity<String>("true", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("false", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/removeReview",  method=RequestMethod.POST ,produces="application/json; charset=utf-8")
	public ResponseEntity<String> removeReview(@RequestParam("rvNum") Integer rvNum) {
		System.out.println(rvNum);
		try {
			oClassService.removeReview(rvNum);
			return new ResponseEntity<String>("true", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("false", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/reviewwrite", method=RequestMethod.GET) 
	public ModelAndView reviewWriteForm(Map<String,Object> param) {
		ModelAndView mav = new ModelAndView("mypage/reviewWrite");
		mav.addObject("param", param);
		return mav;
	}
	
	@RequestMapping(value = "/reviewwrite", method=RequestMethod.POST) 
	public ModelAndView reviewWrite(@RequestParam Map<String, String> param) {
		ModelAndView mav = new ModelAndView("redirect:/reservedrecord");
		System.out.println(param);
		try {
			// 로그인 처리 완성후 삭제
			UserDTO iuser = new UserDTO();
			iuser.setUserId("jane");
			session.setAttribute("user", iuser);
			/////////////////////////////////////
			
			UserDTO user = (UserDTO)session.getAttribute("user");
			userService.reviewWrite(param, user.getUserId());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}	
}
