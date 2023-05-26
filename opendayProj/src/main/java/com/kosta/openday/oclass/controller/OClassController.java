package com.kosta.openday.oclass.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.openday.oclass.service.OClassService;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.OClassDTO; 

@Controller
public class OClassController {
	
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
	public String paymentProcess(@RequestParam Map<String, String> map) {
		try {
			Integer clsId = Integer.valueOf(map.get("clsId"));
			OClassDTO oClass = oClassService.findOne(clsId);
			if (oClass == null)
				throw new Exception("oClass not found");
			
			String date = map.get("lastSelectedDate");
			
			
			/* // todo: 일정 고르면, 단순 시간이 아니라 스케줄 번호가 넘어와야함
			 * // 그렇다는건, 스케줄 시간을 뿌려줄때 해당 스케줄 id를 같이 뿌려줘야함 
			 * ScheduleDTO schedule = new ScheduleDTO();
			 * Integer price = schedule.getScdPrice();
			 */
			
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
