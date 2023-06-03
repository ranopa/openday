package com.kosta.openday.user.service;


import java.io.OutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.UserDTO;

public interface UserService {
	void joinUser(UserDTO user) throws Exception;


	void editUserProfile(Map<String, Object> map, MultipartFile file) throws Exception;

	UserDTO getUserInfo(String id) throws Exception;


	public UserDTO userLogin(Map<String, String> map) throws Exception;

	List<CollectDTO> getSearchOClass(String clsLoc, Date startDate, Date endDate, String clsCode)
			throws Exception;

	
	  public List<CollectDTO> getMainNewOClassList() throws Exception;
	 
	/*
	 * public List<CollectDTO> getMainHotOClassList() throws Exception;
	 */
	void fileView(Integer id, OutputStream out) throws Exception;

	void withdrawUser(String id) throws Exception;

	int idCheck(String id) throws Exception; 
	
	List<CollectDTO> HeartOClass(String userId) throws Exception;
}
