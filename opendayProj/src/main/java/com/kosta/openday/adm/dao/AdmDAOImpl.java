package com.kosta.openday.adm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.OClassDTO;

@Repository
public class AdmDAOImpl implements AdmDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// admin에서 개설신청 대기중인 클래스 목록 조회
	@Override
	public List<OClassDTO> selectOClassByStatus(String status) throws Exception {
		return sqlSession.selectList("mapper.adm.selectOClassByStatus", status);
	}
}
