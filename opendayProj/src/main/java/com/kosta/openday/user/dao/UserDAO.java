package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.dto.UserProfileVO;

public interface UserDAO {

	void insertUser(UserDTO user) throws Exception;
	
	public void updateUserPrefer(Map<String,String> map) throws Exception;
	public List<String> selectUserPrefer(String id) throws Exception;
	public UserProfileVO selectUserVO(String id) throws Exception; 
	
}
