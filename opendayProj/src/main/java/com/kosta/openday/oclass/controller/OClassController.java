package com.kosta.openday.oclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.oclass.service.OClassService; 

@Controller
public class OClassController {
	
	@Autowired
	private OClassService oClassService;
	
	/**
	 *  클래스 상세 화면에서, "신청하기" 버튼 클릭 시
	 * */
	@RequestMapping(value="/apply")
	public String applyClass(@RequestParam("clsId") Integer id, Model model) {
		System.out.println("1 apply controoler");
		try {
			System.out.println("2 apply controoler");
			OClassDTO oclass = oClassService.findOne(id);
			List<ScheduleDTO> scheduels = oClassService.findScheduleByClassId(oclass.getClsId());
			
			// class + schedule:list 긁어와야함
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
	@RequestMapping(value="/paymentprocess")
	public String paymentProcess() {
		return "paymentProcess";
	}
	
	/**
	 * 클래스 결제정보 확인 화면에서, "결제하기 버튼 클릭 시
	 * */
	@RequestMapping(value="/payment")
	public String payment() {
		return "paymentResult";
	}
}
