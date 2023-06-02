package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.HeartDTO;
import com.kosta.openday.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 회원가입
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
	public UserDTO selectUserLogin(Map<String, String> map) throws Exception {
		return sqlSession.selectOne("mapper.user.userLogin", map);
	}

	public UserDTO selectUserInfo(String id) throws Exception {
		return sqlSession.selectOne("mapper.user.selectUser", id);
	}

	@Override
	public List<CollectDTO> selectmainNewOClassList() throws Exception {
		return sqlSession.selectList("mapper.user.mainNewOClassList");

	}

	@Override
	public List<CollectDTO> selectOClassList(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.search.searchSelect", param);
	}

	public void updateUser(Map<String, Object> map) throws Exception {
		sqlSession.update("mapper.user.updateUser", map);

	}

	@Override
	public void updateUserDelete(String id) throws Exception {
		sqlSession.update("mapper.user.updateUserDelete", id);

	}
	
	@Override
	public List<HeartDTO> selectHeartList(String userId) throws Exception {
		List<HeartDTO> list = sqlSession.selectList("mapper.user.selectHeartList",userId);
		System.out.println(list.get(0).getUserId());
		System.out.println(list.get(0).getScdNum());
		return list;
	}

	@Override
	public CollectDTO selectHeartOClass(Integer scdNum) throws Exception {
		return sqlSession.selectOne("mapper.user.selectHeartOClass",scdNum);
		
	}

	

	@Override
	public List<CollectDTO> selectmainHotOClassList() throws Exception {
		return sqlSession.selectList("mapper.user.mainHotOClassList");
	}
}
