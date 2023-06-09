package com.kosta.openday.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OClassDAOImpl implements OClassDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertRequest(RequestDTO request) throws Exception {
		sqlSession.insert("mapper.rclass.insertRequest", request);
	}

	@Override
	public List<OClassDTO> selectOClassList() throws Exception {
		return sqlSession.selectList("mapper.oclass.selectOClassList");
	}
	
	@Override
	public List<OClassDTO> selectOClassListByParam(Map<String, Object> param) throws Exception {
		return sqlSession.selectList("mapper.oclass.searchSelect", param);
	}

	public OClassDTO selectOClassById(Integer clsId) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectOClassByClsId", clsId);
	}
	

	@Override
	public void insertOClass(OClassDTO dto) throws Exception {
		sqlSession.insert("mapper.oclass.insertOClass", dto);
	}
	
	@Override
	public List<ScheduleDTO> selectScheduleByOClass(Integer clsId) throws Exception {
		return sqlSession.selectList("mapper.oclass.selectScheduleListByClsId", clsId);
	}
	
	@Override
	public ScheduleDTO selectSchedule(Integer scdNum) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectSchedule", scdNum);
	}
 
	
	@Override
	public void insertSchedule(ScheduleDTO dto) throws Exception {
		sqlSession.insert("mapper.oclass.insertSchedule", dto);
	}

	@Override
	public RequestDTO selectRequest(Integer reqId) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectRequest", reqId);
	}

	@Override
	public void updateReqViews(Integer reqId) throws Exception {

		sqlSession.update("mapper.oclass.updateReqViews", reqId);

	}

	@Override
	public void updateRequest(RequestDTO request) throws Exception {
		sqlSession.update("mapper.oclass.updateRequest", request);

	}

	@Override
	public void deleteRequest(Integer reqId) throws Exception {
		sqlSession.delete("mapper.oclass.requestDelete", reqId);

	}

	@Override
	public Integer selectPartpaCntByReqId(Integer reqId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.oclass.selectPartpaCntByReqId", reqId);
	}

	@Override
	public Integer selectPartpaYN(Map<String, Object> param) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectPartpaYN", param);
	}

	@Override
	public void insertParticipation(Map<String, Object> param) throws Exception {
		sqlSession.insert("mapper.oclass.insertParticipation", param);

	}

	@Override
	public void deleteParticipation(Map<String, Object> param) throws Exception {
		sqlSession.delete("mapper.oclass.deleteParticipation", param);

	}
	@Override
	public ApplyClassResponseDTO selectOClassAndScheduleForApplyClass(Integer clsId) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectOClassAndScheduleForApplyClass", clsId);
	}
	
 
	public List<RequestDTO> selectRequestList(int startRow) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.rclass.selectRequestList", startRow);
	}

	@Override
	public Integer selectAllRequestCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.rclass.selectAllRequestCnt");
	}

	@Override
	public Map<String, Object> selectOclassDetail(Integer clsId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.rclass.selectOclassDetail", clsId);
	}

	@Override
	public List<ReviewDTO> selectReviewByClsId(Integer clsId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.rclass.selectReviewByClsId", clsId);
	}

	@Override
	public List<ClsInquiryDTO> selectInquiryByClsId(Integer clsId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.rclass.selectInquiryByClsId", clsId);
	}

	@Override
	public List<ClsInquiryAndAnswerDTO> selectInquiryAndAnswerByClsId(Integer clsId) throws Exception {
		List<ClsInquiryAndAnswerDTO> inquiryAndAnswerList = new ArrayList<>();
		List<ClsInquiryDTO> inquiryList = selectInquiryByClsId(clsId);
		for(ClsInquiryDTO inquiry : inquiryList) {
			ClsInquiryAndAnswerDTO inquiryAndAnswer = new ClsInquiryAndAnswerDTO();
			inquiryAndAnswer.setClsInquiry(inquiry);
			AnswerDTO answer = selectReviewByCiNum(inquiry.getCiNum());
			if(answer!=null) {
				inquiryAndAnswer.setAnswer(answer);
			}
			inquiryAndAnswerList.add(inquiryAndAnswer);
		}
		return inquiryAndAnswerList;
	}
	
	@Override
	public Integer selectHeartByClsIdAndUser(Map<String, Object> param) throws Exception {

		return sqlSession.selectOne("mapper.rclass.selectHeartByClsIdAndUser", param);
	}

	@Override
	public Integer selectHeartCntByClsId(Integer clsId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.rclass.selectHeartCntByClsId", clsId);
	}

	@Override
	public void insertHeartByClsIdAndUser(Map<String,Object> param) throws Exception {
		sqlSession.insert("mapper.rclass.insertHeartByClsIdAndUser", param);		
	}

	@Override
	public void deleteHeartByClsIdAndUser(Map<String,Object> param) throws Exception {
		sqlSession.delete("mapper.rclass.deleteHeartByClsIdAndUser", param);		
	}
	
	@Override
	public List<OClassAndScheduleDTO> selectOClassAndSchedules() throws Exception {
		return sqlSession.selectList("mapper.oclass.selectOClassAndSchedules");
	}

	@Override
	public AnswerDTO selectReviewByCiNum(Integer ciNum) throws Exception {
		return sqlSession.selectOne("mapper.rclass.selectReviewByCiNum", ciNum);
	}

	@Override
	public void insertClsInquiry(Map param) throws Exception {
		sqlSession.selectOne("mapper.rclass.insertClsInquiry", param);
		
	}

	@Override
	public void updateClsInquiry(Map param) throws Exception {
		sqlSession.selectOne("mapper.rclass.updateClsInquiry", param);
		
	}

	@Override
	public void deleteReview(Integer rvNum) throws Exception {
		sqlSession.insert("mapper.rclass.deleteReview", rvNum);
		
	}

	@Override
	public TeacherChannelDTO selectteacherChannel(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.teacher.selectteacherChannel", userId);
	}
}
