package com.kosta.openday.teacher.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.InputSource;

import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.adm.service.CodeService;
import com.kosta.openday.teacher.dto.ClassScdUserDTO;
import com.kosta.openday.teacher.dto.ClassScheduleDTO;
import com.kosta.openday.teacher.dto.SettlementAmountDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.teacher.dto.TeacherScheduleDTO;
import com.kosta.openday.teacher.service.TeacherService;
import com.kosta.openday.teacher.util.PageUtil;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;
import com.kosta.openday.user.service.classOpenEnrollService;

@Controller
public class TeacherController {
	@Autowired
	private ServletContext sc;
	@Autowired
	private TeacherService teacherService;

	@Autowired
	private CodeService codeService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private classOpenEnrollService classOpenEnrollService;

	@Autowired
	private HttpSession session;

	@RequestMapping("/tcHome")
	public ModelAndView tcHome(@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcHome");
		try {
			UserDTO dto = (UserDTO) session.getAttribute("userId");
			map.put("userId", dto.getUserId());
			
			int tcSalesTotal = teacherService.tcSalesTotal(map);
			int tcSalesMonthTotal = teacherService.tcSalesMonthTotal(map);
			NumberFormat formatter = NumberFormat.getNumberInstance();
			mav.addObject("tcSalesTotal",  formatter.format(tcSalesTotal));
			mav.addObject("tcSalesMonthTotal", formatter.format(tcSalesMonthTotal));
			
			int tcClassListStatus1Count = teacherService.tcClassListStatus1Count(map);
			int tcClassListStatus2Count = teacherService.tcClassListStatus2Count(map);
			int tcClassListReviewCount = teacherService.tcClassListReviewCount(map);
			double tcClassListAvgStarCount = teacherService.tcClassListAvgStarCount(map);
			mav.addObject("tcClassListAvgStarCount", tcClassListAvgStarCount);
			mav.addObject("tcClassListReviewCount", tcClassListReviewCount);
			mav.addObject("tcClassListStatus1Count", tcClassListStatus1Count);
			mav.addObject("tcClassListStatus2Count", tcClassListStatus2Count);
			
			
			List<AnnouncementDTO> list = teacherService.tcAnnouncementList();
			if (list.isEmpty()) {
				mav.addObject("err", "데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcAnlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/tcClass")
	public ModelAndView tcClass(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClass");
		try {
			List<CodeDTO> codeList = codeService.codeList("클래스상태");
			mav.addObject("codeList", codeList);

			UserDTO dto = (UserDTO) session.getAttribute("userId");
			map.put("userId", dto.getUserId());
			int totalRowCount = teacherService.tcClassListCount(map);// 전체글의 갯수
			PageUtil pu = new PageUtil(pageNum, 15, 5, totalRowCount);
			int startRow = pu.getStartRow();
			int endRow = pu.getEndRow();

			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu", pu);
			mav.addObject("map", map);

			List<OClassDTO> list = teacherService.tcClassList(map);
			if (list.isEmpty()) {
				mav.addObject("err", "데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcCllist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/tcClsUser")
	public ModelAndView tcClassUSer(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsUser");
		try {

			UserDTO dto = (UserDTO) session.getAttribute("userId");
			map.put("userId", dto.getUserId());
			int totalRowCount = teacherService.tcClassScheduleListCount(map);// 전체글의 갯수
			PageUtil pu = new PageUtil(pageNum, 10, 5, totalRowCount);
			int startRow = pu.getStartRow();
			int endRow = pu.getEndRow();

			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu", pu);
			mav.addObject("map", map);
			
			List<ClassScheduleDTO> list = teacherService.tcClassScheduleList(map);
			if (list.isEmpty()) {
				mav.addObject("err", "데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcClassScdlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/classUserList", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<ClassScdUserDTO> classUserList(@RequestParam Integer scdNum) {
		List<ClassScdUserDTO> list = null;
		try {
			list = teacherService.tcClassUserList(scdNum);
			if (list.isEmpty()) {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping("/tcClsInquiry")
	public ModelAndView tcClassInquery(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsInquiry");
		try {

			UserDTO dto = (UserDTO) session.getAttribute("userId");
			map.put("userId", dto.getUserId());
			int totalRowCount = teacherService.tcClassListCount(map);// 전체글의 갯수
			PageUtil pu = new PageUtil(pageNum, 10, 5, totalRowCount);
			int startRow = pu.getStartRow();
			int endRow = pu.getEndRow();

			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu", pu);
			mav.addObject("map", map);

			List<OClassDTO> list = teacherService.tcClassList(map);
			if (list.isEmpty()) {
				mav.addObject("err", "데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcCllist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/classInquiryList", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<ClsInquiryDTO> classInquiryList(@RequestParam Integer clsId) {
		List<ClsInquiryDTO> list = null;
		try {
			list = teacherService.tcClassInquiryList(clsId);
			if (list.isEmpty()) {
				list = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/tcAnInfo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody AnnouncementDTO tcAnInfo(@RequestParam Integer ancId) {
		AnnouncementDTO dto = null;
		try {
			dto = teacherService.tcAnnouncementInfo(ancId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	@RequestMapping(value = "/SalesAdd", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody void SalesAdd(@RequestParam HashMap<String, Object> map) {
		try {
			UserDTO dto = (UserDTO) session.getAttribute("userId");
			map.put("userId", dto.getUserId());
			teacherService.SalesAdd(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/tcClsSchedule")
	public ModelAndView tcClassSchedule(@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsSchedule");
		UserDTO dto = (UserDTO) session.getAttribute("userId");
		map.put("userId", dto.getUserId());
		try {
			List<TeacherScheduleDTO> list = teacherService.tcScheduleList(map);
			mav.addObject("tcScheduleList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping("/tcClsSales")
	public ModelAndView tcClsSales(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsSales");
		try {
//			List<CodeDTO> codeList = codeService.codeList("수강상태");
//			mav.addObject("codeList",codeList);

			UserDTO dto = (UserDTO) session.getAttribute("userId");
			map.put("userId", dto.getUserId());
			int totalRowCount = teacherService.tcClassSalesListCount(map);// 전체글의 갯수
			PageUtil pu = new PageUtil(pageNum, 15, 5, totalRowCount);
			int startRow = pu.getStartRow();
			int endRow = pu.getEndRow();

			map.put("startRow", startRow);
			map.put("endRow", endRow);
			mav.addObject("pu", pu);
			mav.addObject("map", map);

			List<OClassDTO> list = teacherService.tcClassSalesList(map);
			if (list.isEmpty()) {
				mav.addObject("err", "데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcClsSaleslist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/tcClsSalesList")
	public ModelAndView tcClsSalesList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsSalesList");
		try {

			UserDTO dto = (UserDTO) session.getAttribute("userId");
			map.put("userId", dto.getUserId());
			mav.addObject("map", map);

			int tcSalesTotal = teacherService.tcSalesTotal(map);
			mav.addObject("tcSalesTotal", tcSalesTotal);
			List<SettlementAmountDTO> list = teacherService.tcSalesList(map);
			if (list.isEmpty()) {
				mav.addObject("err", "데이터가 존재하지 않습니다.");
			}
			mav.addObject("tcSaleslist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/profileUpdate")
	@ResponseBody
	public void profileUpdate(@RequestParam MultipartFile fileProfile,@RequestParam  HashMap<String, Object> map) {
		// 업로드할 폴더의 절대 경로 구하기
		String path = sc.getRealPath("/resources/upload");
		String orgfilename = fileProfile.getOriginalFilename();// 전송된 파일명
		String savefilename = UUID.randomUUID() + "_" + orgfilename; // 저장할 파일명(중복되지 않는 이름으로 만들기)
		new File(path + "\\" + savefilename);
		try {
			InputStream is = fileProfile.getInputStream();
			FileOutputStream fos = new FileOutputStream(path + "\\" + savefilename);
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
			UserDTO dto = (UserDTO) session.getAttribute("userId");
			String id = dto.getUserId();
			TeacherChannelDTO tcDTO = teacherService.tcChannelInfo(id);
			tcDTO.setTchcNickname((String)map.get("nickName"));
			tcDTO.setTchcIntro((String)map.get("tcIntroduction"));
			teacherService.tcProfileUserUpdate(tcDTO);
			if((String)map.get("file") != null) {
				if(tcDTO.getFilNum() == null) {
					teacherService.tcProfileUserImgUpdate(tcDTO);
					tcDTO = teacherService.tcChannelInfo(id);
					FileDTO fileDTO = new FileDTO(tcDTO.getFilNum(), fileProfile.getContentType(), orgfilename, savefilename, fileProfile.getSize(), null);
					teacherService.tcProfileAdd(fileDTO);
				}else {
					FileDTO fileDTO = new FileDTO(tcDTO.getFilNum(), fileProfile.getContentType(), orgfilename, savefilename, fileProfile.getSize(), null);
					teacherService.tcProfileUpdate(fileDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/profileImage")
	@ResponseBody
	public FileDTO profileImage(HttpServletRequest request) {
		FileDTO file = null;
		try {
			UserDTO dto = (UserDTO) session.getAttribute("userId");
			TeacherChannelDTO tcDTO = teacherService.tcChannelInfo(dto.getUserId());
			if(tcDTO.getFilNum() == null) {
				file = null;
			}else {
				file = teacherService.tcProfileInfo(tcDTO.getFilNum());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	@RequestMapping(value="/timer")
	public ModelAndView refreshSessionTimeout(@RequestParam Map<String, Object> commandMap) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
	 
		modelAndView.addObject("result", "ok");
	 
		return modelAndView;
	}
}
