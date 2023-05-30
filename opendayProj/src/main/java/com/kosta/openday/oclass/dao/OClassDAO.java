package com.kosta.openday.oclass.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.RequestDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;

@Repository
public interface OClassDAO {
	void insertOClass(OClassDTO dto) throws Exception;
	
	OClassDTO selectOClassById(Integer clsId) throws Exception;
	
	List<OClassDTO> selectOClassList() throws Exception;

	List<OClassDTO> selectOClassListByParam(Map<String, Object> param) throws Exception;

	ScheduleDTO selectSchedule(Integer scdNum) throws Exception;
	
	List<ScheduleDTO> selectScheduleByOClass(Integer clsId) throws Exception;
	
	void insertRequest(RequestDTO request) throws Exception;

	List<RequestDTO> selectRequestList() throws Exception;

	RequestDTO selectRequest(Integer reqId) throws Exception;

	void updateReqViews(Integer reqId) throws Exception;

	void updateRequest(RequestDTO request) throws Exception;

	void deleteRequest(Integer reqId) throws Exception;

	Integer selectPartpaCntByReqId(Integer reqId) throws Exception;

	Integer selectPartpaYN(Map<String, Object> param) throws Exception;

	void insertParticipation(Map<String, Object> param) throws Exception;

	void deleteParticipation(Map<String, Object> param) throws Exception;
}
