package com.kosta.openday.oclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;

@Repository
public class OClassDAOImpl implements OClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<OClassDTO> selectClassList() throws Exception {
		return sqlSession.selectList("mapper.oclass.selectOClassList");
	}
	
	public OClassDTO selectClassById(Integer clsId) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectOClassByClsId", clsId);
	}
	
	public void insertClass(OClassDTO dto) throws Exception {
		sqlSession.insert("mapper.oclass.insertOClass", dto);
	}
	
	public List<ScheduleDTO> selectScheduleByClass(Integer clsId) throws Exception {
		return sqlSession.selectList("mapper.schedule.selectScheduleListByClsId", clsId);
	}

}
