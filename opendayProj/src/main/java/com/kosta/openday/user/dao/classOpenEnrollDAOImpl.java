package com.kosta.openday.user.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.OClassDTO;
@Repository
public class classOpenEnrollDAOImpl implements classOpenEnrollDAO {
		@Autowired
		private SqlSessionTemplate sqlSession;

		@Override
		public int classOpen(OClassDTO dto) throws Exception {
			return sqlSession.insert("mapper.oclass.classOpen", dto);
		}

}
