package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.user.dto.UserDTO; 

public interface UserDAO {

	void insertUser(UserDTO user) throws Exception;
	
	public void updateUserPrefer(Map<String,String> map) throws Exception;
	public List<String> selectUserPrefer(String id) throws Exception;
	public UserDTO selectUserInfo(String id) throws Exception; 
	
}
