package com.kosta.openday.teacher.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dao.CodeDAO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.teacher.dto.ClassScdUserDTO;
import com.kosta.openday.teacher.dto.ClassScheduleDTO;
import com.kosta.openday.teacher.dto.TeacherScheduleDTO;
import com.kosta.openday.teacher.service.TeacherService;
import com.kosta.openday.teacher.util.PageUtil;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO; 

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CodeService codeService;
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
	public ModelAndView tcClass(@RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClass");
		try {
			List<CodeDAO> codeList = codeService.codeList("클래스상태");
			mav.addObject("codeList",codeList);
			
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
			mav.addObject("tcCllist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("/tcClassUser")
	public ModelAndView tcClassUSer(@RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClassUser");
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
	@RequestMapping("/tcClassInquiry")
	public ModelAndView tcClassInquery(@RequestParam(value="pageNum",defaultValue = "1")int pageNum, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClassInquiry");
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
	@RequestMapping("/tcClassSchedule")
	public ModelAndView tcClassSchedule(@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClassSchedule");
		map.put("userId", "hong");
		try {
			List<TeacherScheduleDTO> list = teacherService.tcScheduleList(map);
			mav.addObject("tcScheduleList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
}
