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
	@Override
	public void joinUser(UserDTO user) throws Exception {
		System.out.println("util.date -> sql.date");
//		user.setUserEmail(user.getEmailVal()+"@"+user.getDomain());
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
//		
//		System.out.println(dateFormat.parse(user.getBirthVal()));
//		user.setUserBirth(dateFormat.parse(user.getBirthVal()));
//		userDAO.insertUser(user); 
	} 
}
