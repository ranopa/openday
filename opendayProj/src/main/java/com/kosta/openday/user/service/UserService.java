package com.kosta.openday.user.service;

import org.springframework.web.multipart.MultipartFile;
 
import com.kosta.openday.user.dto.UserDTO; 

public interface UserService {
	void joinUser(UserDTO user) throws Exception;
	void editUserProfile(String id, String nickname, String tel, MultipartFile file) throws Exception;
	UserDTO getUserInfo(String id) throws Exception;
}
