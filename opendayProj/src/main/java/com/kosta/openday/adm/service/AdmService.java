package com.kosta.openday.adm.service;

import java.util.List;
import java.util.Map;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.teacher.dto.SettlementAmountDTO;
import com.kosta.openday.user.dto.OClassDTO;
import java.io.OutputStream;
import java.util.List;

import com.kosta.openday.adm.dto.AdmInquiryDTO;

public interface AdmService {
	List<OClassDTO> findOClassByStatus(String status) throws Exception;

	void allowOClass(Integer clsId) throws Exception;
	
	void refuseOClass(Integer clsId) throws Exception;
	
	List<AdmUserViewDTO> findAllUser() throws Exception;
	
	List<AdmInquiryDTO> findAllAdmInquiryList() throws Exception;
	
	AdmInquiryDTO findAdmInquiry(Integer admNum) throws Exception;

	List<AnnouncementDTO> findAnnouncementList() throws Exception;

	AnnouncementDTO findAnnouncement(Integer ancId) throws Exception;

	void writeAdmAnnouncement(Map<String, Object> map) throws Exception;

	public void inquiryInsert(AdmInquiryDTO dto) throws Exception;
	public void fileView(Integer filNum, OutputStream out) throws Exception;
	List<AdmInquiryDTO> inquiryListSelect() throws Exception;
	void inquiryDelete(Integer admNum) throws Exception;
	void inquiryUpdate(Integer admNum, String admTitle, String admContent) throws Exception;

	void inquiryAnswer(Integer admNum, String answer) throws Exception;

	List<SettlementAmountDTO> findSettlementListByStatus(String status) throws Exception;
}
