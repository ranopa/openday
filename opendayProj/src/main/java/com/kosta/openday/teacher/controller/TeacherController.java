package com.kosta.openday.teacher.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.teacher.dto.ClassScdUserDTO;
import com.kosta.openday.teacher.dto.ClassScheduleDTO;
import com.kosta.openday.teacher.dto.SettlementAmountDTO;
import com.kosta.openday.teacher.dto.TeacherScheduleDTO;
import com.kosta.openday.teacher.service.TeacherService;
import com.kosta.openday.teacher.util.PageUtil;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.UserService; 

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@Autowired
	private CodeService codeService;

	@Autowired
	private UserService userService;
	@RequestMapping("/tcHome")
	public ModelAndView tcHome() {
		ModelAndView mav = new ModelAndView("teacher/tcHome");
		
		try {
			List<AnnouncementDTO> list = teacherService.tcAnnouncementList();
			if(list.isEmpty()) {
				mav.addObject("err","데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcAnlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/tcClass")
	public ModelAndView tcClass(HttpSession session, @RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClass");
		try {
			List<CodeDTO> codeList = codeService.codeList("클래스상태");
			mav.addObject("codeList",codeList);
			
			//String id = (String) session.getAttribute("id");
			map.put("userId", "hong");
			int totalRowCount=teacherService.tcClassListCount(map);//전체글의 갯수
			PageUtil pu=new PageUtil(pageNum, 15, 5, totalRowCount);
			int startRow=pu.getStartRow();
			int endRow=pu.getEndRow();
			
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu",pu);
			mav.addObject("map", map);
			
			List<OClassDTO> list = teacherService.tcClassList(map);
			if(list.isEmpty()) {
				mav.addObject("err","데이터가 존재하지 않습니다.");
			}
			System.out.println(list);
			mav.addObject("tcCllist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("/tcClsUser")
	public ModelAndView tcClassUSer(@RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsUser");
		try {

			map.put("userId", "hong");
			int totalRowCount=teacherService.tcClassScheduleListCount(map);//전체글의 갯수
			PageUtil pu=new PageUtil(pageNum, 10, 5, totalRowCount);
			int startRow=pu.getStartRow();
			int endRow=pu.getEndRow();
			
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu",pu);
			mav.addObject("map", map);
			
			List<ClassScheduleDTO> list = teacherService.tcClassScheduleList(map);
			
			if(list.isEmpty()) {
				mav.addObject("err","데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcClassScdlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value="/classUserList",produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<ClassScdUserDTO> classUserList(@RequestParam Integer scdNum) {
		List<ClassScdUserDTO> list = null;
		try {
			list = teacherService.tcClassUserList(scdNum);
			if(list.isEmpty()) {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping("/tcClsInquiry")
	public ModelAndView tcClassInquery(@RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsInquiry");
		try {
			
			map.put("userId", "hong");
			int totalRowCount=teacherService.tcClassListCount(map);//전체글의 갯수
			PageUtil pu=new PageUtil(pageNum, 10, 5, totalRowCount);
			int startRow=pu.getStartRow();
			int endRow=pu.getEndRow();
			
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu",pu);
			mav.addObject("map", map);
			
			List<OClassDTO> list = teacherService.tcClassList(map);
			if(list.isEmpty()) {
				mav.addObject("err","데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcCllist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value="/classInquiryList",produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<ClsInquiryDTO> classInquiryList(@RequestParam Integer clsId) {
		List<ClsInquiryDTO> list = null;
		try {
			list = teacherService.tcClassInquiryList(clsId);
			if(list.isEmpty()) {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping("/tcClsSchedule")
	public ModelAndView tcClassSchedule(@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsSchedule");
		map.put("userId", "hong");
		try {
			List<TeacherScheduleDTO> list = teacherService.tcScheduleList(map);
			mav.addObject("tcScheduleList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	@RequestMapping("/tcClsSales")
	public ModelAndView tcClsSales(@RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsSales");
		try {
//			List<CodeDTO> codeList = codeService.codeList("수강상태");
//			mav.addObject("codeList",codeList);
			
			map.put("userId", "hong");
			int totalRowCount=teacherService.tcClassSalesListCount(map);//전체글의 갯수
			PageUtil pu=new PageUtil(pageNum, 15, 5, totalRowCount);
			int startRow=pu.getStartRow();
			int endRow=pu.getEndRow();
			
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu",pu);
			mav.addObject("map", map);
			
			List<OClassDTO> list = teacherService.tcClassSalesList(map);
			if(list.isEmpty()) {
				mav.addObject("err","데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcClsSaleslist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("/tcClsSalesList")
	public ModelAndView tcClsSalesList(@RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsSalesList");
		try {
			
			map.put("userId", "hong");
			mav.addObject("map", map);
			
			List<SettlementAmountDTO> list = teacherService.tcSalesList(map);
			if(list.isEmpty()) {
				mav.addObject("err","데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcSaleslist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
