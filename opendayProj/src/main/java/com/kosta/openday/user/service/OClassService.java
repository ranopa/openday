package com.kosta.openday.user.service;

import java.sql.Date;
import java.util.List;

import java.util.Map;
import com.kosta.openday.user.dto.ApplyClassResponseDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.adm.dto.OClassAndScheduleDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.user.dto.RequestDTO;
import com.kosta.openday.user.dto.PageInfo;

public interface OClassService {

	List<OClassDTO> getSearchOClass(String loc, Date startDate, Date endDate, String clsCode) throws Exception;

	OClassDTO findOne(Integer clsId) throws Exception;

	List<OClassDTO> findAll() throws Exception;

	void save(OClassDTO dto) throws Exception;

	List<ScheduleDTO> findScheduleByClassId(Integer clsId) throws Exception;

	void requestClass(RequestDTO request) throws Exception;

	List<RequestDTO> getRequestList(PageInfo pageInfo) throws Exception;

	RequestDTO getRequest(Integer reqId) throws Exception;

	void plusViewCount(Integer reqId) throws Exception;

	void modifyRequest(RequestDTO request) throws Exception;

	void removeRequest(Integer reqId) throws Exception;

	Integer getPartpaCntByReqId(Integer reqId) throws Exception;

	Integer getPartPaYN(String userId, Integer req_id) throws Exception;

	Boolean coupleParticipation(String userId, Integer reqId) throws Exception;

	ScheduleDTO findScheduleById(Integer scdNum) throws Exception;

	ApplyClassResponseDTO getApplyClassResponse(Integer id) throws Exception;

	Map<String, Object> getOclassDetail(Integer clsId, String userId) throws Exception;

	Integer toggleHeartSchedule(Integer clsId, String userId) throws Exception;

	List<OClassAndScheduleDTO> findClassAndSchedules() throws Exception;

	void clsInquiry(String ciContent, String ciSecret, Integer clsId, String userId ) throws Exception;
	
	void modifyClsInquiry(String ciContent, String ciSecret, Integer ciNum) throws Exception;
	
	void removeReview(Integer rvNum) throws Exception;
	
	TeacherChannelDTO getTeacherChannel(String userId) throws Exception;
}
