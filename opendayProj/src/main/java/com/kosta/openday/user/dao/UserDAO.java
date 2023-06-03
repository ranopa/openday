package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.HeartDTO;
import com.kosta.openday.user.dto.UserDTO; 

public interface UserDAO {

	void insertUser(UserDTO user) throws Exception;
	
	public void updateUserPrefer(Map<String,String> map) throws Exception;
	public List<String> selectUserPrefer(String id) throws Exception;
	public List<HeartDTO> selectHeartList(String userId) throws Exception;
	public CollectDTO selectHeartOClass(Integer scdNum) throws Exception;

	public UserDTO selectUserInfo(String id) throws Exception; 
	public UserDTO selectUserLogin(Map<String,String> map) throws Exception;
	List<CollectDTO> selectOClassList(Map<String, Object> param) throws Exception;
	public List<CollectDTO> selectmainNewOClassList() throws Exception;
	public List<CollectDTO> selectmainHotOClassList() throws Exception;
	
	
	public void updateUser(Map<String, Object> map)throws Exception;
	public void updateUserDelete(String id) throws Exception;
	
	public void deleteHeart(Map<String,Object> map)throws Exception;
	
}
