package com.kosta.openday.adm.service;

import java.util.List;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.user.dto.OClassDTO;

public interface AdmService {
	List<OClassDTO> findOClassByStatus(String status) throws Exception;

	void allowOClass(Integer clsId) throws Exception;
	
	void refuseOClass(Integer clsId) throws Exception;
	
	List<AdmUserViewDTO> findAllUser() throws Exception;
	
	List<AdmInquiryDTO> findAllAdmInquiryList() throws Exception;
	
	AdmInquiryDTO findAdmInquiry(Integer admNum) throws Exception;
}
