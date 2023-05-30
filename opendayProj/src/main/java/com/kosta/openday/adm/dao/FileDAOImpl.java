package com.kosta.openday.adm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.FileDTO;

@Repository
public class FileDAOImpl implements FileDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Override
	public void insertFile(FileDTO file) throws Exception {
		sqlSession.insert("mapper.adm.insertFile", file);

	}
	@Override
	public FileDTO selectFile(Integer filNum) throws Exception { 
		return sqlSession.selectOne("mapper.adm.selectFile", filNum);
	}
	
	@Override
	public Integer selectNewFileId() throws Exception {
		return sqlSession.selectOne("mapper.adm.newFileId");
	}

}
