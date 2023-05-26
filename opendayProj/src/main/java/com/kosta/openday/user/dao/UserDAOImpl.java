package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.UserDTO; 

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//회원가입
	@Override
	public void insertUser(UserDTO user) throws Exception {
		sqlSession.insert("mapper.user.insertUser", user); 
	}
	
	@Override
	public void updateUserPrefer(Map<String,String> map) throws Exception {
		sqlSession.update("mapper.user.updateUserPrefer", map);
	}

	
	@Override
	public List<String> selectUserPrefer(String id) throws Exception {
		return sqlSession.selectList("mapper.user.selectUserPrefer", id);
	}


	@Override
	public UserDTO selectUserInfo(String id) throws Exception { 
		return sqlSession.selectOne("mapper.user.selectUser", id); 
				
	}
	
}
