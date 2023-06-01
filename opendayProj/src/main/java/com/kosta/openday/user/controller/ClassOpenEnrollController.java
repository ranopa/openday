package com.kosta.openday.user.controller;

import javax.servlet.http.HttpServletResponse;

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

import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.classOpenEnrollService;

@Controller
public class ClassOpenEnrollController {

	@Autowired
	private classOpenEnrollService classopenenrollService;

	@RequestMapping(value = "/classOpen", method = RequestMethod.GET)
	public String classOpenForm() {
		return "classOpenEnrollment/classOpen";
	}
	
	/*
	 * @RequestMapping(value = "/classOpen", method = RequestMethod.POST) public
	 * ModelAndView classOpen(@ModelAttribute OClassDTO dto) { ModelAndView mav =
	 * new ModelAndView(); try { classopenenrollService.classCreate(dto);
	 * System.out.println(11); } catch(Exception e) { e.printStackTrace();
	 * System.out.println(22); } mav.setViewName("redirect:/"); return mav; }
	 */

	@RequestMapping(value = "/classOpen", method = RequestMethod.POST)
	public ModelAndView classOpen(@ModelAttribute OClassDTO dto,
			@RequestPart(value = "file", required = false) MultipartFile file) {
		ModelAndView mav = new ModelAndView();
		try {
			classopenenrollService.classCreate(dto, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/tcHome");
		return mav;
	}

	
	@RequestMapping(value = "/classEnrollment", method = RequestMethod.GET)
	public ModelAndView classEnrollmentForm(@RequestParam(value="clsId", required = false) Integer clsId) {
		ModelAndView mav = new ModelAndView();
		try {
			OClassDTO oclassDTO = classopenenrollService.getOclass(clsId);
			ScheduleDTO scheduleDTO = classopenenrollService.getSchedule(clsId);
			mav.addObject("oclassDTO", oclassDTO);
			mav.addObject("scheduleDTO", scheduleDTO);
			mav.setViewName("classOpenEnrollment/classEnrollment");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	 

	@RequestMapping(value = "/classEnrollment", method = RequestMethod.POST)
	public ModelAndView classEnrollment(@ModelAttribute ScheduleDTO dto) {
		ModelAndView mav = new ModelAndView();
		try {
			classopenenrollService.classUpload(dto);
			System.out.println(11);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(22);
		}
		mav.setViewName("redirect:/tcHome");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/image/{filNum}", method = RequestMethod.GET)
	public void image(@PathVariable("filNum") Integer filNum, HttpServletResponse response) {
		try {
			classopenenrollService.fileView(filNum, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
