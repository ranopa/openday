package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.OClassDTO;

@Repository
public class classOpenEnrollDAOImpl implements classOpenEnrollDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int classOpen(OClassDTO dto) throws Exception {
		return sqlSession.insert("mapper.oclass.insertOClass", dto);
	}

	@Override
	public void insertFile(FileDTO file) throws Exception {
		sqlSession.insert("mapper.oclass.insertFile", file) ;	
	}

	@Override
	public Integer selectFileNum() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.adm.newFileId");
	}

	@Override
	public OClassDTO selectOclass(Integer clsId) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectOclass",clsId);
	}

	@Override
	public FileDTO selectFile(Integer filNum) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectFile",filNum);
	}

	@Override
	public int classEnrollment(ScheduleDTO dto) throws Exception {
		return sqlSession.insert("mapper.teacher.classEnrollemnt", dto);
	}

	@Override
	public Map<String, Object> selectSchedule(Integer clsId) throws Exception {
		return sqlSession.selectOne("mapper.teacher.selectSchedule", clsId);
	}

	@Override
	public void updateClassInfo(Map<String, Object> map) throws Exception {
		sqlSession.update("mapper.oclass.updateclassOpen", map);		
	}

	@Override
	public void updateClassFile(FileDTO dto) throws Exception {
		sqlSession.update("mapper.oclass.updateThumbnail", dto);
	}

	@Override
	public void updateClassSchedule(Map<String, Object> map) throws Exception {
		sqlSession.update("mapper.teacher.updateclassEnrollment", map);
		
	}

	@Override
	public ScheduleDTO selectScheduleNum(Integer scdNum) throws Exception {
		return sqlSession.selectOne("mapper.oclass.selectSchedule",scdNum);
	}

}
