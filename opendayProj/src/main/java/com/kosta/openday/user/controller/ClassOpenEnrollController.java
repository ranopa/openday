package com.kosta.openday.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;
import com.kosta.openday.user.service.classOpenEnrollService;

@Controller
public class ClassOpenEnrollController {

	@Autowired
	private classOpenEnrollService classopenenrollService;
	
	@Autowired 
	private UserService userService;
	 
	private ServletContext sc;
	
	@Autowired
	private HttpSession session;

	private ScheduleDTO oclassDTO;

	private ScheduleDTO scheduleDTO;
 
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
	public ModelAndView classOpen(@ModelAttribute OClassDTO dto, HttpSession session,
			@RequestPart(value = "file", required = false) MultipartFile file) {
		ModelAndView mav = new ModelAndView();
		try {
			UserDTO user = (UserDTO)session.getAttribute("userId");
			dto.setUserId(user.getUserId());
			classopenenrollService.classCreate(dto, file);
			
			userService.alterAuthorityTchc(user.getUserId()); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/tcHome");
		return mav;
	}

	@RequestMapping(value = "/classEnrollment", method = RequestMethod.GET)
	public ModelAndView classEnrollmentForm(@ModelAttribute OClassDTO dto, HttpSession session, @RequestParam Map<String, Object> map, Integer clsId) {
		ModelAndView mav = new ModelAndView();
		try {
			UserDTO user = (UserDTO)session.getAttribute("userId");
			dto.setUserId(user.getUserId());
			Map<String, Object> scheduleDetail = classopenenrollService.getSchedule(clsId);
			mav.addObject("scheduleDetail", scheduleDetail);
			mav.setViewName("classOpenEnrollment/classEnrollment");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	/*
	 * @RequestMapping(value = "/classEnrollment", method = RequestMethod.POST)
	 * public ModelAndView classEnrollment(@ModelAttribute ScheduleDTO dto) {
	 * ModelAndView mav = new ModelAndView(); try {
	 * classopenenrollService.classUpload(dto); System.out.println(11); } catch
	 * (Exception e) { e.printStackTrace(); System.out.println(22); }
	 * mav.setViewName("redirect:/tcHome"); return mav; }
	 */

	@RequestMapping(value = "/classEnrollment", method = RequestMethod.POST)
	public ModelAndView classEnrollment(@RequestParam("jsondata") String jsondata, @ModelAttribute ScheduleDTO dto) {
	    ModelAndView mav = new ModelAndView();
	    try {
	        JSONArray selectedEventArray = new JSONArray(jsondata);
	        JSONObject selectedEvent = selectedEventArray.getJSONObject(0); // 첫 번째 이벤트 선택
	        String start = selectedEvent.getString("start");
	        String end = selectedEvent.getString("end");

	        // ScheduleDTO에 추출한 정보 설정
	        dto.setStart(start);
	        dto.setEnd(end);

	        // 추가된 부분: 이벤트 정보 추출하여 변수에 할당
	        for (int j = 0; j < selectedEventArray.length(); j++) {
	            JSONObject schedule = selectedEventArray.getJSONObject(j);
	            String scdDate = schedule.getString("start").substring(0, 10); // yyyy-mm-dd 형식의 날짜 추출
	            String scdStartTime = schedule.getString("start").substring(11, 19); // hh:mm:ss 형식의 시작 시간 추출
	            String scdEndTime = schedule.getString("end").substring(11, 19); // hh:mm:ss 형식의 종료 시간 추출

	            // 추출한 정보를 활용하여 필요한 작업 수행
	            // ...

	            // DB에 값 전달
	            dto.setScdDate(scdDate);
	            dto.setScdStartTime(scdStartTime);
	            dto.setScdEndTime(scdEndTime);
	            classopenenrollService.classUpload(dto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
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
	
	@RequestMapping(value = "/classUpdate", method = RequestMethod.GET)
	public ModelAndView classUpdatetForm(@ModelAttribute OClassDTO dto, @RequestParam Map<String, Object> map, Integer clsId) {
		ModelAndView mav = new ModelAndView();
		try {
			Map<String, Object> scheduleDetail = classopenenrollService.getSchedule(clsId);
			mav.addObject("scheduleDetail", scheduleDetail);
			mav.setViewName("classOpenEnrollment/classUpdate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	

	@RequestMapping(value = "/classUpdate", method=RequestMethod.POST )
	public ModelAndView classUpdate(@RequestParam(value = "file", required = false) MultipartFile file, 
			@RequestBody OClassDTO odto, @RequestBody ScheduleDTO sdto) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		try {
			OClassDTO olcass = (OClassDTO)session.getAttribute("clsId");
			map.put("clsId", olcass.getClsId());
			map.put("clsCode", odto.getClsCode());
			map.put("clsDescription", odto.getClsDescription());
			map.put("clsPrice", odto.getClsPrice());
			map.put("clsCurri", odto.getClsCurri());
			map.put("clsCarrer", odto.getClsCareer());
			map.put("clsLoc", odto.getClsLoc());
			map.put("clsDiscount", odto.getClsDiscount());
			map.put("clsfilNum", odto.getFilNum());
			map.put("scdRunTime", sdto.getScdRunTime());
			map.put("scdStartTime", sdto.getScdStartTime());
			map.put("scdEndTime", sdto.getScdEndTime());
			map.put("scdPlace", sdto.getScdPlace());
			map.put("scdPlaceDetail", sdto.getScdPlaceDetail());
			map.put("scdMinPersonnel", sdto.getScdMinPersonnel());
			map.put("scdMaxPersonnel", sdto.getScdMaxPersonnel());
			
		String path = sc.getRealPath("/resources/upload");
		String orgfilename = file.getOriginalFilename();// 전송된 파일명
		String savefilename = UUID.randomUUID() + "_" + orgfilename; // 저장할 파일명(중복되지 않는 이름으로 만들기)
		new File(path + "\\" + savefilename);
			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(path + "\\" + savefilename);
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
			FileDTO fileDTO = new FileDTO(odto.getFilNum(), file.getContentType(), orgfilename, savefilename, file.getSize(), null );
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("classOpenEnrollment/classUpdate");
		return mav;
		
	}

}
