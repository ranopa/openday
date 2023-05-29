package com.kosta.openday.user.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.UserDTO;

public interface UserService {
	void joinUser(UserDTO user) throws Exception;

	void editUserProfile(String id, String nickname, String tel, MultipartFile file) throws Exception;

	UserDTO getUserInfo(String id) throws Exception;

	public UserDTO userLogin(Map<String, String> map) throws Exception;

	List<OClassDTO> getSearchOClass(String scdLoc, Date startDate, Date endDate, String clsCode)
			throws Exception;

	public List<CollectDTO> getMainNewOClassList() throws Exception;
	
	

}
