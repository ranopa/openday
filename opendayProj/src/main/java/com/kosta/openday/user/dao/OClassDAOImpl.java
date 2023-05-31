package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.ApplyClassResponseDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.RequestDTO;

@Repository
public class OClassDAOImpl implements OClassDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertRequest(RequestDTO request) throws Exception {
		sqlSession.insert("mapper.oclass.insertRequest", request);
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
	
	public List<ScheduleDTO> selectScheduleByOClass(Integer clsId) throws Exception {
		return sqlSession.selectList("mapper.schedule.selectScheduleListByClsId", clsId);
	}
	
	@Override
	public ScheduleDTO selectSchedule(Integer scdNum) throws Exception {
		return sqlSession.selectOne("mapper.schedule.selectSchedule", scdNum);
	}

	public List<RequestDTO> selectRequestList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.oclass.selectRequestList");
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
		sqlSession.insert("mapper.oclass.deleteParticipation", param);

	}
	@Override
	public ApplyClassResponseDTO selectClassAndScheduleForApplyClass(Integer clsId) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectClassAndScheduleForApplyClass", clsId);
	}
	
}
