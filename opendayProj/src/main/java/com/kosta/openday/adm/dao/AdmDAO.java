package com.kosta.openday.adm.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.user.dto.OClassDTO;

public interface AdmDAO {

	List<OClassDTO> selectOClassByStatus(String status) throws Exception;

	void updateOClassStatus(Map<String, Object> map) throws Exception;

	List<AdmUserViewDTO> selectUserList() throws Exception;
	
	List<AdmInquiryDTO> selectAdmInquiryList() throws Exception;
	
	AdmInquiryDTO selectAdmInquiry(Integer admNum) throws Exception;
}
