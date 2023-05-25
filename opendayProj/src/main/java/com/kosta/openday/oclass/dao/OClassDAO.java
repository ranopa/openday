package com.kosta.openday.oclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.oclass.dto.OClassDTO;
import com.kosta.openday.oclass.dto.ScheduleDTO;

@Repository
public class OClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<OClassDTO> selectClassList() throws Exception {
		return sqlSession.selectList("mapper.oclass.selectClassList");
	}
	
	public OClassDTO selectClassById(String id) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectClass", id);
	}
	
	public void insertClass(OClassDTO dto) throws Exception {
		sqlSession.insert("mapper.oclass.insertClass", dto);
	}
	
	public List<ScheduleDTO> selectScheduleByClass(Integer clsId) throws Exception {
		return sqlSession.selectList("mapper.schedule.selectScheduleByClassId", clsId);
	}
}
