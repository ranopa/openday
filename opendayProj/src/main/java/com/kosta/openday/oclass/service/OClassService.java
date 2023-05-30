package com.kosta.openday.oclass.service;

import java.util.List;

import com.kosta.openday.oclass.dto.PageInfo;
import com.kosta.openday.user.dto.RequestDTO;
 

public interface OClassService {
	
	void requestClass(RequestDTO request) throws Exception;
	List<RequestDTO> getRequestList(PageInfo pageInfo) throws Exception;
	RequestDTO getRequest(Integer reqId) throws Exception;
	void plusViewCount(Integer reqId) throws Exception;
	void modifyRequest(RequestDTO request) throws Exception;
	void removeRequest(Integer reqId) throws Exception;
	Integer getPartpaCntByReqId(Integer reqId) throws Exception;
	Integer getPartPaYN(String userId, Integer req_id) throws Exception;
	Boolean coupleParticipation(String userId, Integer reqId) throws Exception;
}
