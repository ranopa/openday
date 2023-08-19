package com.kosta.openday.adm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.ModelAttribute;  
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
import com.kosta.openday.teacher.dto.SettlementAmountDTO;
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

	@RequestMapping(value = "/adm", method = RequestMethod.GET)
	public String main(@RequestParam(value = "page", required = false) String page, Model model) throws Exception {
		String status = "검토중";
		List<OClassDTO> watingOClassList = admService.findOClassByStatus(status);
		model.addAttribute("list", watingOClassList);
		model.addAttribute("page","admWaitingList");
		return "admin/admMain";
	}
	
	
	@Autowired
	private NotificationService notiService;
	

	// 개설신청 목록 조회
	@RequestMapping(value = "/admwaitinglist", method = RequestMethod.GET)
	public String watingList(Model model) {
		String status = "검토중";
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
	@RequestMapping(value = "/adm/adminallow", method = RequestMethod.POST)
	public String allowNewClass(@RequestParam Integer clsId, Model model) {
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
		return "redirect:/admwaitinglist";
	}
	
	// 개설 거절 
	@RequestMapping(value = "/adm/adminrefuse/", method = RequestMethod.POST)
	public String refuseNewClass(@RequestParam Integer clsId, Model model) {
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
	
	@RequestMapping(value = "/inquiryList", method=RequestMethod.GET)
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
		mav.setViewName("redirect:/inquiryList");
		return mav;
	}
	
	@RequestMapping(value = "/inquiryDelete",method=RequestMethod.GET)
	public ModelAndView inquiryDelete(@RequestParam("admNum") Integer admNum) {
		ModelAndView mav = new ModelAndView();
		try {
			admService.inquiryDelete(admNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("announceinquiry/inquiryList");
		return mav;
	}
	
	@RequestMapping(value = "/inquiryDetail",method=RequestMethod.GET)
	public ModelAndView inquiryHistoryDetail(@RequestParam("admNum") Integer admNum) {
		ModelAndView mav = new ModelAndView();
		try {
			AdmInquiryDTO inquiry = admService.findAdmInquiry(admNum);
			mav.addObject("inquiry", inquiry);
			mav.setViewName("announceinquiry/inquiryDetail");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return mav; 
	}
	
	//개설신청 디테일
	@RequestMapping(value="/adm/adminwaitingdetail/{clsId}")
	public String watingDetail(@PathVariable Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			oClass.setClsCode(admService.getCodeName(oClass.getClsCode())); 
			model.addAttribute("oclass", oClass);
			model.addAttribute("page","admWaitingDetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/admMain";
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
			List<SettlementAmountDTO> list = admService.findSettlementListByStatus("정산대기");
			model.addAttribute("page","admSettleWaitingList");
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	//정산내역목록
	@RequestMapping(value = "/admsettlerecordlist", method = RequestMethod.GET)
	public String settleRecordList(Model model) { 
		try {
			List<SettlementAmountDTO> list = admService.findSettlementListByStatus("정산완료");
			model.addAttribute("page","admSettleRecordList");
			model.addAttribute("list", list);
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
	@RequestMapping(value = "/adminquirydetail/{admNum}", method = RequestMethod.GET)
	public String admInquiryDetail(@PathVariable Integer admNum, Model model) { 
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
			notiService.createNotification(admNum, 
					NotificationSourceType.ADMIN_INQUIRY_ANSWER, 
					inquiry.getAdmTitle(), 
					null, 
					inquiry.getUserId()
			);
			
			// 목록으로리턴 
			List<AdmInquiryDTO> inquiryList = admService.findAllAdmInquiryList();
			model.addAttribute("inquiryList", inquiryList);
			model.addAttribute("page","admInquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "adm/admMain";
	} 
	
	//문의답변
	@RequestMapping(value = "/adminquiryanswer", method = RequestMethod.POST)
	public String admInquiryAnswer(@RequestParam("admNum") Integer admNum, @RequestParam("answer") String admAnContent , Model model) { 
		try {
			admService.inquiryAnswer(admNum, admAnContent); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "redirect:/adminquirylist";
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
	@RequestMapping(value="/announcementList")
	public ModelAndView adminAnnouncementList() {
		ModelAndView mav = new ModelAndView(); 
		try {
			List<AnnouncementDTO> ancList = admService.findAnnouncementList();  
			mav.addObject("ancList", ancList);
			mav.setViewName("announceinquiry/announcementList"); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	// 공지사항 디테일

	@RequestMapping(value="/announcementDetail", method=RequestMethod.GET)
	public ModelAndView adminAnnouncementDetail(@RequestParam("ancId") Integer ancId) {
		ModelAndView mav = new ModelAndView();
		try {
			AnnouncementDTO anc = admService.findAnnouncement(ancId);
			mav.addObject("anc", anc);
			mav.setViewName("announceinquiry/announcementDetail");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	// 공지사항 작성 폼
	@RequestMapping(value="/admannouncementwriteform", method=RequestMethod.GET)
	public String writeAdmAnnouncementForm(Model model) { 
		model.addAttribute("page","admNoticeWrite");
	 return "admin/admMain";
		
	}
	// 공지사항 작성
	@RequestMapping(value="/admannouncementwrite", method=RequestMethod.POST)
	public String writeAdmAnnouncement(
			@RequestParam("ancTitle") String title,
			@RequestParam("ancContent") String content,
			@RequestParam("ancType") String type,
			@RequestPart(value = "file", required = false) MultipartFile file,
			Model model) throws Exception{
		// 제목, 내용, 분류(일반,강사), 파일
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("title", title);
			map.put("content", content);
			map.put("type", type);
			if(file!=null) {
				map.put("file", file); 				
			}
			admService.writeAdmAnnouncement(map); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admnoticelist";
	}
 
	//공지사항 삭제
	@RequestMapping(value="/admnoticedelete", method=RequestMethod.GET)
	public String removeNotice(@RequestParam("ancId") Integer ancId, Model model) throws Exception {
		admService.removeNotice(ancId);
	 return "redirect:/admnoticelist";
		
	}
	  
} 