package com.kosta.openday.user.service;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.dto.UserProfileVO;

public interface UserService {
	void JoinUser(UserDTO user) throws Exception;
	void editUserProfile(String id,String nickname,String tel,MultipartFile file)throws Exception;
	UserProfileVO getUserProfile(String id) throws Exception;
}
