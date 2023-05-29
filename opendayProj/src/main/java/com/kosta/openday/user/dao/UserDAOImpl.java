package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Override
	public CollectDTO collectDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertUser(UserDTO user) throws Exception {
		sqlSession.insert("mapper.user.insertUser", user);

	}

	@Override
	public void updateUserPrefer(Map<String, String> map) throws Exception {
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

	@Override
	public UserDTO selectUserLogin(Map<String, String> map) throws Exception {
		return sqlSession.selectOne("mapper.user.userLogin", map);
	}

	@Override

	public List<OClassDTO> selectOClassList(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.oclass.searchSelect", param);
	}

	public List<CollectDTO> selectmainNewOClassList() throws Exception {
		return sqlSession.selectList("mapper.user.mainNewOClassList");

	}

}
