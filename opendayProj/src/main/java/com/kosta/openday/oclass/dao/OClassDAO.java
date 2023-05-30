package com.kosta.openday.oclass.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.user.dto.RequestDTO;


public interface OClassDAO {
	
	void insertRequest(RequestDTO request) throws Exception ;
	List<RequestDTO> selectRequestList(int startRow) throws Exception;
	RequestDTO selectRequest(Integer reqId) throws Exception;
	void updateReqViews(Integer reqId) throws Exception;
	void updateRequest(RequestDTO request) throws Exception;
	void deleteRequest(Integer reqId) throws Exception;
	Integer selectPartpaCntByReqId(Integer reqId) throws Exception;
	Integer selectPartpaYN(Map<String,Object> param) throws Exception;
	void insertParticipation(Map<String,Object> param) throws Exception;
	void deleteParticipation(Map<String,Object> param) throws Exception;
	Integer selectAllRequestCnt() throws Exception;
}
