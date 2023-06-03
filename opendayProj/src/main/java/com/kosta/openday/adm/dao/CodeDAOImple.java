package com.kosta.openday.adm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDAOImple implements CodeDAO {
	@Autowired 
	private SqlSessionTemplate sqlSession;
	@Override
	public List<CodeDAO> codeList(String codClassfication) throws Exception {
		return sqlSession.selectList("mapper.code.codeList", codClassfication);
	}
}
