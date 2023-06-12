package com.kosta.openday.teacher.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
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
	public ModelAndView tcHome() {
		ModelAndView mav = new ModelAndView("teacher/tcHome");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String id = (String) session.getAttribute("id");
			map.put("userId", id);

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

			// String id = (String) session.getAttribute("id");
			map.put("userId", "hong");
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

			map.put("userId", "hong");
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

			map.put("userId", "hong");
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
	public ModelAndView tcClsSales(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("teacher/tcClsSales");
		try {
//			List<CodeDTO> codeList = codeService.codeList("수강상태");
//			mav.addObject("codeList",codeList);

			map.put("userId", "hong");
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

			map.put("userId", "hong");
			mav.addObject("map", map);

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
	public void profileUpdate(@RequestParam MultipartFile fileProfile,  HashMap<String, Object> map) {
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
			String id = (String) session.getAttribute("id");
			id = "hong";
			//TeacherChannelDTO tcDTO = classOpenEnrollService.selectteacherChannel
			UserDTO userDTO = userService.getUserInfo(id);
			if(userDTO.getFilNum() == null) {
				//teacherService.tcProfileUserUpdate(id);
				userDTO = userService.getUserInfo(id);
				FileDTO fileDTO = new FileDTO(userDTO.getFilNum(), fileProfile.getContentType(), orgfilename, savefilename, fileProfile.getSize(), null);
				teacherService.tcProfileAdd(fileDTO);
			}else {
				FileDTO fileDTO = new FileDTO(userDTO.getFilNum(), fileProfile.getContentType(), orgfilename, savefilename, fileProfile.getSize(), null);
				teacherService.tcProfileUpdate(fileDTO);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/profileImage")
	@ResponseBody
	public FileDTO profileImage(@RequestParam String id) {
		FileDTO file = null;
		try {
			UserDTO user = userService.getUserInfo(id);
			if(user.getFilNum() == null) {
				file = null;
			}else {
				file = teacherService.tcProfileInfo(user.getFilNum());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
}
