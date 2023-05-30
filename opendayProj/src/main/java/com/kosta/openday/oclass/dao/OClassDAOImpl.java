package com.kosta.openday.oclass.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
  
import com.kosta.openday.user.dto.RequestDTO;

@Repository
public class OClassDAOImpl implements OClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertRequest(RequestDTO request) throws Exception {
		sqlSession.insert("mapper.rclass.insertRequest", request);
	}

	@Override
	public List<RequestDTO> selectRequestList(int startRow) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.rclass.selectRequestList", startRow);
	}

	@Override
	public RequestDTO selectRequest(Integer reqId) throws Exception {
		return sqlSession.selectOne("mapper.rclass.selectRequest", reqId);
	}

	@Override
	public void updateReqViews(Integer reqId) throws Exception {
		
		sqlSession.update("mapper.rclass.updateReqViews", reqId);
		
	}

	@Override
	public void updateRequest(RequestDTO request) throws Exception {
		sqlSession.update("mapper.rclass.updateRequest", request);
		
	}

	@Override
	public void deleteRequest(Integer reqId) throws Exception {
		sqlSession.delete("mapper.rclass.deleteRequest", reqId);
		
	}

	@Override
	public Integer selectPartpaCntByReqId(Integer reqId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.rclass.selectPartpaCntByReqId", reqId);
	}

	@Override
	public Integer selectPartpaYN(Map<String,Object> param) throws Exception {
		return sqlSession.selectOne("mapper.rclass.selectPartpaYN", param);
	}

	@Override
	public void insertParticipation(Map<String,Object> param) throws Exception {
		sqlSession.insert("mapper.rclass.insertParticipation", param);
		
	}

	@Override
	public void deleteParticipation(Map<String,Object> param) throws Exception {
		sqlSession.insert("mapper.rclass.deleteParticipation", param);
		
	}

	@Override
	public Integer selectAllRequestCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.rclass.selectAllRequestCnt");
	}

}
