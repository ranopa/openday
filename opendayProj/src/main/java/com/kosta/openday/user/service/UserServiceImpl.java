package com.kosta.openday.user.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.user.dao.UserDAO;
import com.kosta.openday.user.dto.UserDTO;

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
}
