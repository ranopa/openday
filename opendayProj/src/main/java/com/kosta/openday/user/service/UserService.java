package com.kosta.openday.user.service;

import java.io.OutputStream;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.user.dto.UserDTO; 

public interface UserService {
	void joinUser(UserDTO user) throws Exception;
	void editUserProfile(Map<String, Object> map,MultipartFile file)throws Exception;
	UserDTO getUserInfo(String id) throws Exception;
	void fileView(Integer id, OutputStream out) throws Exception;
	void withdrawUser(String id)throws Exception; 
}
