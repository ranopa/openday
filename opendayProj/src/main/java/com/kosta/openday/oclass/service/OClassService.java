package com.kosta.openday.oclass.service;


import java.sql.Date;
import java.util.List;

import com.kosta.openday.oclass.dto.CategoryDTO;
import com.kosta.openday.user.dto.OClassDTO;

import java.util.List;

import com.kosta.openday.oclass.dto.OclassDTO;
import com.kosta.openday.user.dto.RequestDTO;
 


public interface OClassService {

	List<OClassDTO> getSearchOClass(String loc, Date startDate, Date endDate, String clsCode) throws Exception;
	

	
	void requestClass(RequestDTO request) throws Exception;
	List<RequestDTO> getRequestList() throws Exception;
	RequestDTO getRequest(Integer reqId) throws Exception;
	void plusViewCount(Integer reqId) throws Exception;
	void modifyRequest(RequestDTO request) throws Exception;
	void removeRequest(Integer reqId) throws Exception;
	Integer getPartpaCntByReqId(Integer reqId) throws Exception;
	Integer getPartPaYN(String userId, Integer req_id) throws Exception;
	Boolean coupleParticipation(String userId, Integer reqId) throws Exception;



	void classCreate(OclassDTO dto);
}

