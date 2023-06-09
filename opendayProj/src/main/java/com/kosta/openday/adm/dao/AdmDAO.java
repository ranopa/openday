package com.kosta.openday.adm.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.FileDTO;

public interface AdmDAO {
	public int insertInquiry(AdmInquiryDTO dto) throws Exception;
	public void insertFile(FileDTO file) throws Exception;
	Integer selectFileNum() throws Exception;
	FileDTO selectFile(Integer filNum) throws Exception;
	List<AdmInquiryDTO> selectInquiryList() throws Exception;
	void deleteInquiry(Integer admNum) throws Exception;
	void updateInquiry(Map<String,Object> param) throws Exception; 
}
