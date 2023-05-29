package com.kosta.openday.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.user.dao.OClassDAO;
import com.kosta.openday.teacher.dao.ScheduleDAO;
import com.kosta.openday.user.dao.ReviewDAO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class MainController {

	@Autowired
	private CodeService codeService;
	private UserService userService;

	@Autowired
	private HttpSession session;
	private SqlSessionTemplate sqlSession;
	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		try {
			List<CodeDTO> codeList = codeService.categoryInfoList();
			/* List<CollectDTO> newCollect = userService.getMainNewOClassList(); */
			
			OClassDAO oclassDAO = sqlSession.getMapper(OClassDAO.class);
			/*
			 * ScheduleDAO scheduleDAO= sqlSession.getMapper(ScheduleDAO.class); ReviewDAO
			 * reviewDAO=sqlSession.getMapper(ReviewDAO.class);
			 */CollectDTO collectoDTO =oclassDAO.collectDTO();
			/*
			 * CollectDTO collectsDTO =scheduleDAO.collectDTO(); CollectDTO collectrDTO
			 * =reviewDAO.collectDTO();
			 */
			
			
			mav.addObject("collectoDTO", collectoDTO);
			/*
			 * mav.addObject("collectsDTO", collectsDTO); mav.addObject("collectrDTO",
			 * collectrDTO);
			 */
			mav.addObject("codeList", codeList);
			mav.setViewName("main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/subClassList")
	public String subClassList() {
		return "subClassList";
	}

}
