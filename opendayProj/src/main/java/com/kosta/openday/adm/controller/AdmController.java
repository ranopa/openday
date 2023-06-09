package com.kosta.openday.adm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.dto.OClassAndScheduleDTO;
import com.kosta.openday.adm.service.AdmService;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.service.OClassService;

@Controller
public class AdmController {
	@Autowired
	private AdmService admService;

	@Autowired
	private OClassService oClassService;

	@RequestMapping(value = "/adm", method = RequestMethod.GET)
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
	

	// 개설 승낙
	@RequestMapping(value = "/adm/adminallow", method = RequestMethod.POST)
	public String allowNewClass(@RequestParam Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			if (oClass == null) 
				throw new Exception("존재하지 않는 클래스");
			
			admService.allowOClass(clsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingList";
	}

	// 개설 거절 
	@RequestMapping(value = "/adm/adminrefuse", method = RequestMethod.POST)
	public String refuseNewClass(@RequestParam Integer clsId, Model model) {
		try {
			OClassDTO oClass = oClassService.findOne(clsId);
			if (oClass == null) 
				throw new Exception("존재하지 않는 클래스");
			
			admService.refuseOClass(clsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminWatingList";
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
	@RequestMapping(value="/admnoticelist")
	public String adminAnnouncementList(Model model) {
		try {
			List<AnnouncementDTO> ancList = admService.findAnnouncementList();
			System.out.println(ancList.isEmpty());
			model.addAttribute("ancList", ancList);
			model.addAttribute("page","admNoticeList");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/admMain";
	}
	
	// 공지사항 디테일
	@RequestMapping(value="/admnoticedetail/{ancId}")
	public String adminAnnouncementDetail(@PathVariable Integer ancId,  Model model) {
		try {
			System.out.println(ancId);
			AnnouncementDTO anc = admService.findAnnouncement(ancId); 
			model.addAttribute("anc", anc); 
			model.addAttribute("page","admNoticeDetail");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/admMain";
	}
	// 공지사항 작성 폼
	@RequestMapping(value="/admannouncementwriteform", method=RequestMethod.GET)
	public String writeAdmAnnouncementForm(Model model) {
		model.addAttribute("page","admNoticeWrite");
	 return "adm/admMain";
		
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
