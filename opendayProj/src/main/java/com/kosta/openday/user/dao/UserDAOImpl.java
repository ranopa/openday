package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.dto.UserProfileVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
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
	public UserProfileVO selectUserVO(String id) throws Exception {
		UserProfileVO user = sqlSession.selectOne("mapper.user.selectUser", id);
		System.out.println(user.getUserId());
		return user;
	}
	
}
