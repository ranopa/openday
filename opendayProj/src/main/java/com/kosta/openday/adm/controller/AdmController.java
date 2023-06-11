package com.kosta.openday.adm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.dto.NotificationSourceType;
import com.kosta.openday.adm.dto.OClassAndScheduleDTO;

import com.kosta.openday.adm.service.AdmService;
import com.kosta.openday.adm.service.NotificationService;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.OClassService;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.service.AdmService;
import com.kosta.openday.user.dto.UserDTO; 

@Controller
public class AdmController {
	@Autowired
	private AdmService admService;

	@Autowired
	private OClassService oClassService;
	
	@Autowired
	private NotificationService notiService;
	
	@RequestMapping(value = "/adm/", method = RequestMethod.GET)
	public String main(@RequestParam(value = "page", required = false) String page, Model model) {
		model.addAttribute("page", page);
		return "admin/admMain";
	}

	// 개설신청 목록 조회
	@RequestMapping(value = "/admwaitinglist", method = RequestMethod.GET)
	public String watingList(Model model) {
		String status = "승인대기";
		try {
			List<OClassDTO> watingOClassList = admService.findOClassByStatus(status);
			model.addAttribute("list", watingOClassList);
			model.addAttribute("page","admWaitingList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin/admMain";
	}
		
	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public String inquiryForm(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    UserDTO user = (UserDTO) session.getAttribute("userId");
	    if (user == null) {
	        // 로그인되어 있지 않으면 로그인 페이지로 이동
	        return "redirect:/loginform";
	    }
	    
	    return "announceinquiry/inquiry";
	}
	
	// 개설 승낙
	@RequestMapping(value = "/adm/adminallow/{clsId}", method = RequestMethod.POST)
	public String allowNewClass(@PathVariable Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			if (oClass == null) 
				throw new Exception("존재하지 않는 클래스");
			
			admService.allowOClass(clsId);
			// 알림전송
			notiService.createNotification(
					oClass.getClsId(), // 알림 발생한 대상(클래스) 아이디 
					NotificationSourceType.OCLASS_ALLOW, // 알림 타입 
					oClass.getClsName(), // 알림 발생한 대상 이름 
					null, // 알림 발생시킨 사람 (관리자라 임시로 null) 
					oClass.getUserId()); // 알림 받을 사람(강사) 
			if (oClass.getClsOpenType().equals("요청")) {
				// 요청에 참여한 사람들에게도 알림 전송 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingList";
	}
	
	// 개설 거절 
	@RequestMapping(value = "/adm/adminrefuse/{clsId}", method = RequestMethod.POST)
	public String refuseNewClass(@PathVariable Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			if (oClass == null) 
				throw new Exception("존재하지 않는 클래스");
			
			admService.refuseOClass(clsId);
			notiService.createNotification(
					oClass.getClsId(), 
					NotificationSourceType.OCLASS_REFUSE, 
					oClass.getClsName(), 
					null, 
					oClass.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingList";
	}
	
	
	@RequestMapping(value="/inquiry", method=RequestMethod.POST)
	public ModelAndView inquiry(@ModelAttribute AdmInquiryDTO admInquiryDTO, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		try {
			UserDTO user = (UserDTO)session.getAttribute("userId");
			System.out.println(user.getUserId());
			admInquiryDTO.setUserId(user.getUserId());
			admService.inquiryInsert(admInquiryDTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/inquiryList");
		return mav;
	}
	
	@RequestMapping(value = "/inquiryList")
	public ModelAndView inquiryHistoryList() {
		ModelAndView mav = new ModelAndView();
		try {
			List<AdmInquiryDTO> AdmInquiryDTO = admService.inquiryListSelect();
			mav.addObject("ilist", AdmInquiryDTO);
			mav.setViewName("announceinquiry/inquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "/inquiryUpdate", method=RequestMethod.POST )
	public ModelAndView inquiryUpdate(@RequestParam("admNum") Integer admNum, @RequestParam("admTitle") String admTitle,
									  @RequestParam("admContent") String admContent)  {
		ModelAndView mav = new ModelAndView();
		try {
			admService.inquiryUpdate(admNum, admTitle, admContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/announceinquiry/inquiryDetail");
		return mav;
	}
	
	@RequestMapping(value = "/inquiryDelete",method=RequestMethod.GET)
	public ModelAndView inquiryDelete(@RequestParam("admNum") Integer admNum) {
		ModelAndView mav = new ModelAndView();
		try {
			admService.inquiryDelete(admNum);
			mav.setViewName("redirect:/announceinquiry/inquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "/inquiryDetail",method=RequestMethod.GET)
	public String inquiryHistoryDetial() {
		return "announceinquiry/inquiryDetail";
	}
	
	@RequestMapping(value = "/announcementList",method=RequestMethod.GET)
	public String announcementList() {
		return "announceinquiry/announcementList";
	}
	
	@RequestMapping(value = "/announcementDetail",method=RequestMethod.GET)
	public String announcementDetail() {
		return "announceinquiry/announcementDetail";
	}


	
	//개설신청 디테일
	@RequestMapping(value="/adm/adminwaitingdetail")
	public String watingDetail(@RequestParam Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			
			model.addAttribute("oClass", oClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingDetail";
	}
	
	

	
	//유저리스트
	@RequestMapping(value = "/admuserlist", method = RequestMethod.GET)
	public String admUserList(Model model) { 
		try {
			List<AdmUserViewDTO> users = admService.findAllUser();
			
			model.addAttribute("users", users);
			model.addAttribute("page","admUserList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin/admMain";
	}
	
	//클래스리스트
	@RequestMapping(value = "/admclasslist", method = RequestMethod.GET)
	public String classList(Model model) { 
		try {
			 List<OClassAndScheduleDTO> list = oClassService.findClassAndSchedules();
			 model.addAttribute("list", list);
			model.addAttribute("page","admClassList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "admin/admMain";
	}
	
	//정산대기목록
	@RequestMapping(value = "/admsettlewaitinglist", method = RequestMethod.GET)
	public String settleWaitingList(Model model) { 
		try {
			model.addAttribute("page","admSettleWaitingList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	//정산내역목록
	@RequestMapping(value = "/admsettlerecordlist", method = RequestMethod.GET)
	public String settleRecordList(Model model) { 
		try {
			model.addAttribute("page","admSettleRecordList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	//유저문의목록
	@RequestMapping(value = "/adminquirylist", method = RequestMethod.GET)
	public String admInquiryList(Model model) { 
		try {
			List<AdmInquiryDTO> inquiryList = admService.findAllAdmInquiryList();
			model.addAttribute("inquiryList", inquiryList);
			model.addAttribute("page","admInquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	//유저문의디테일 
	@RequestMapping(value = "/adminquirydetail", method = RequestMethod.GET)
	public String admInquiryDetail(@RequestParam Integer admNum, Model model) { 
		try {
			AdmInquiryDTO inquiry = admService.findAdmInquiry(admNum);
			model.addAttribute("inquiry", inquiry);
			model.addAttribute("page","admInquiryDetail");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	// 유저문의 답변 등록 
	@RequestMapping(value="/adminquriyanswer", method=RequestMethod.POST)
	public String admInquriyAnswer(@RequestParam Integer admNum, @RequestParam String answer, Model model) {
		
		try {
			AdmInquiryDTO inquiry = admService.findAdmInquiry(admNum);
			if (inquiry == null) {
				throw new Exception("not exist");
			}
			admService.inquiryAnswer(admNum, answer);
			
			// 목록으로리턴 
			List<AdmInquiryDTO> inquiryList = admService.findAllAdmInquiryList();
			model.addAttribute("inquiryList", inquiryList);
			model.addAttribute("page","admInquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "adm/admMain";
	}
	

	//매출확인
	@RequestMapping(value = "/admsaleslist", method = RequestMethod.GET)
	public String admSalesList(Model model) { 
		try {
			model.addAttribute("page","admSalesList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}

	// 공지사항 목록
	@RequestMapping(value="/adminannouncementlist")
	public String adminAnnouncementList(Model model) {
		try {
			List<AnnouncementDTO> ancList = admService.findAnnouncementList();
			model.addAttribute("ancList", ancList);
			model.addAttribute("page","admAnnouncementList");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/admMain";
	}
	
	// 공지사항 디테일
	@RequestMapping(value="/admannouncementdetail/{ancId}")
	public String adminAnnouncementDetail(@PathVariable Integer ancId,  Model model) {
		try {
			AnnouncementDTO anc = admService.findAnnouncement(ancId);
			model.addAttribute("anc", anc);
			
			List<AdmInquiryDTO> inquiryList = admService.findAllAdmInquiryList();
			model.addAttribute("inquiryList", inquiryList);
			model.addAttribute("page","admInquiryList");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/admMain";
	}
	
	// 공지사항 작성
	@RequestMapping(value="/admannouncementwrite", method=RequestMethod.POST)
	public String writeAdmAnnouncement(
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam String type,
			@RequestPart(value = "file", required = false) MultipartFile file,
			Model model) throws Exception{
		// 제목, 내용, 분류(일반,강사), 파일
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("title", title);
			map.put("content", content);
			map.put("type", type);
			map.put("file", file);
			admService.writeAdmAnnouncement(map);
			
			List<AnnouncementDTO> ancList = admService.findAnnouncementList();
			model.addAttribute("ancList", ancList);
			model.addAttribute("page","admAnnouncementList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "adm/admMain";
		
	
	}
	

	
}
