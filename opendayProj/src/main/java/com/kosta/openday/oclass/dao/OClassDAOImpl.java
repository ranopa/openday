package com.kosta.openday.oclass.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.board.dto.FileVO;
import com.kosta.openday.oclass.dto.OclassDTO;

@Repository
public class OClassDAOImpl implements OClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int classOpen(OclassDTO dto) throws Exception {
		return sqlSession.insert("mapper.oclass.classOpen", dto);
	}
	
	@Override
	public void insertFile(FileVO file) throws Exception {
		sqlSession.insert("mapper.oclass.insertFile", file);
	}
}
