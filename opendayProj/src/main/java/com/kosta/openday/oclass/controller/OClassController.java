package com.kosta.openday.oclass.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.openday.oclass.service.OClassService;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.PaymentProcessDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService; 

@Controller
public class OClassController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private OClassService oClassService;
	
	@Autowired
	private UserService userService;
	
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
	@RequestMapping(value="/paymentProcess", method=RequestMethod.POST)
	public String paymentProcess(PaymentProcessDTO paymentProcessDto, Model model) {
		try {
			// 신청한 클래스 정보
			Integer clsId = paymentProcessDto.getClsId();
			OClassDTO oClass = oClassService.findOne(clsId);
			
			// 해당 클래스의 일정 정보
			Integer scdNum = paymentProcessDto.getScdNum();
			
			Time time = paymentProcessDto.getSelectTime();

			
			if (oClass == null)
				throw new Exception("oClass not found");
			
			
			model.addAttribute("oClass", oClass);
			
			// todo: 하단의 todo붙은건 일종의 테스트용 더미데이터 코드 
			
			// todo: service에서 가져오는걸로 대체  
			// ScheduleDTO schedule = teacherService.findSchedule(scdNum);
			
			ScheduleDTO schedule = new ScheduleDTO();
			schedule.setScdDate(new Date(2022-1900, 3, 1));
			schedule.setScdTime(new Time(14,00,00));
			schedule.setClsId(1);
			schedule.setScdLoc("seoul");
			model.addAttribute("schedule", schedule);
			
			
			// todo: userid session에서 읽어오는걸로 대체 
			String userId = "hong";
			UserDTO user = userService.getUserInfo(userId);
			session.setAttribute("user", user);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "apply/paymentProcess";
	}
	
	/**
	 * 클래스 결제정보 확인 화면에서, "결제하기 버튼 클릭 시
	 * */
	@RequestMapping(value="/payment")
	public String payment() {
		return "apply/paymentResult";
	}

}
