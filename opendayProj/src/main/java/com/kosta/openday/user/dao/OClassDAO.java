package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.OClassAndScheduleDTO;
import com.kosta.openday.teacher.dto.AnswerDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.user.dto.ApplyClassResponseDTO;
import com.kosta.openday.user.dto.ClsInquiryAndAnswerDTO;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.RequestDTO;
import com.kosta.openday.user.dto.ReviewDTO;

@Repository
public interface OClassDAO {
	void insertOClass(OClassDTO dto) throws Exception;

	void insertRequest(RequestDTO request) throws Exception;
 
	List<RequestDTO> selectRequestList(int startRow) throws Exception;

	RequestDTO selectRequest(Integer reqId) throws Exception;

	void updateReqViews(Integer reqId) throws Exception;

	void updateRequest(RequestDTO request) throws Exception;

	void deleteRequest(Integer reqId) throws Exception;

	Integer selectPartpaCntByReqId(Integer reqId) throws Exception;

	Integer selectPartpaYN(Map<String, Object> param) throws Exception;

	void insertParticipation(Map<String, Object> param) throws Exception;

	void deleteParticipation(Map<String, Object> param) throws Exception;

	Integer selectAllRequestCnt() throws Exception;

	List<OClassDTO> selectOClassListByParam(Map<String, Object> param) throws Exception;

	ScheduleDTO selectSchedule(Integer scdNum) throws Exception;

	List<OClassDTO> selectOClassList() throws Exception;

	OClassDTO selectOClassById(Integer clsId) throws Exception;

	List<ScheduleDTO> selectScheduleByOClass(Integer clsId) throws Exception;

	Map<String, Object> selectOclassDetail(Integer clsId) throws Exception;
	
	void insertSchedule(ScheduleDTO dto) throws Exception;

	List<ReviewDTO> selectReviewByClsId(Integer clsId) throws Exception;

	List<ClsInquiryDTO> selectInquiryByClsId(Integer clsId) throws Exception;
	
	List<ClsInquiryAndAnswerDTO> selectInquiryAndAnswerByClsId(Integer clsId) throws Exception;

	Integer selectHeartByClsIdAndUser(Map<String, Object> param) throws Exception;

	Integer selectHeartCntByClsId(Integer clsId) throws Exception;

	void insertHeartByClsIdAndUser(Map<String, Object> param) throws Exception;

	void deleteHeartByClsIdAndUser(Map<String, Object> param) throws Exception; 

	ApplyClassResponseDTO selectOClassAndScheduleForApplyClass(Integer clsId) throws Exception;

	List<OClassAndScheduleDTO> selectOClassAndSchedules() throws Exception;
	
	AnswerDTO selectReviewByCiNum(Integer ciNum) throws Exception;
	
	void insertClsInquiry(Map param) throws Exception;
	
	void updateClsInquiry(Map param) throws Exception;
	
	void deleteReview(Integer rvNum) throws Exception;
	
	TeacherChannelDTO selectteacherChannel(String userId) throws Exception;
}
