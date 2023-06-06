package com.kosta.openday.adm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
//			 List<OClassAndScheduleDTO> list = oClassService.findClassAndSchedules();
//			 model.addAttribute("list", list);
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
			model.addAttribute("page","admInquiryList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	//공지목록
	@RequestMapping(value = "/admnoticelist", method = RequestMethod.GET)
	public String admNoticeList(Model model) { 
		try {
			model.addAttribute("page","admNoticeList");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	//공지작성
	@RequestMapping(value = "/admnoticewrite", method = RequestMethod.GET)
	public String admNoticeWrtie(Model model) { 
		try {
			model.addAttribute("page","admNoticeWrite");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "admin/admMain";
	}
	
	
}
