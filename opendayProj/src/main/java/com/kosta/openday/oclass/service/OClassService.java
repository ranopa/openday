package com.kosta.openday.oclass.service;

import java.sql.Date;
import java.util.List;

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.RequestDTO;

public interface OClassService {

	List<OClassDTO> getSearchOClass(String loc, Date startDate, Date endDate, String clsCode) throws Exception;

	OClassDTO findOne(Integer clsId) throws Exception;

	List<OClassDTO> findAll() throws Exception;

	void save(OClassDTO dto) throws Exception;

	List<ScheduleDTO> findScheduleByClassId(Integer clsId) throws Exception;

	void requestClass(RequestDTO request) throws Exception;

	List<RequestDTO> getRequestList() throws Exception;

	RequestDTO getRequest(Integer reqId) throws Exception;

	void plusViewCount(Integer reqId) throws Exception;

	void modifyRequest(RequestDTO request) throws Exception;

	void removeRequest(Integer reqId) throws Exception;

	Integer getPartpaCntByReqId(Integer reqId) throws Exception;

	Integer getPartPaYN(String userId, Integer req_id) throws Exception;

	Boolean coupleParticipation(String userId, Integer reqId) throws Exception;

}
