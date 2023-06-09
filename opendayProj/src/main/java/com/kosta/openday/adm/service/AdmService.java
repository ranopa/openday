package com.kosta.openday.adm.service;

import java.io.OutputStream;
import java.util.List;

import com.kosta.openday.adm.dto.AdmInquiryDTO;

public interface AdmService {
	public void inquiryInsert(AdmInquiryDTO dto) throws Exception;
	public void fileView(Integer filNum, OutputStream out) throws Exception;
	List<AdmInquiryDTO> inquiryListSelect() throws Exception;
	void inquiryDelete(Integer admNum) throws Exception;
	void inquiryUpdate(Integer admNum, String admTitle, String admContent) throws Exception;
}
