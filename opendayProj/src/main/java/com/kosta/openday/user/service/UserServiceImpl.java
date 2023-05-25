package com.kosta.openday.user.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.user.dao.UserDAO;
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.dto.UserProfileVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	//회원가입 > 데베에 insert
	@Override
	public void JoinUser(UserDTO user) throws Exception {
		user.setUserEmail(user.getEmailVal()+"@"+user.getDomain());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		System.out.println(dateFormat.parse(user.getBirthVal()));
		user.setUserBirth(dateFormat.parse(user.getBirthVal()));
		userDAO.insertUser(user); 
	}

	@Override
	public void editUserProfile(String id, String nickname, String tel, MultipartFile file) throws Exception {
		String src = "C:\\Users\\KOSTA\\Desktop\\proj_img";
		
		
	}

	@Override
	public UserProfileVO getUserProfile(String id) throws Exception { 
		UserProfileVO user = userDAO.selectUserVO(id);
		return user;
				
	} 
}
