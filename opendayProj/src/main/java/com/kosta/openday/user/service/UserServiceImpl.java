package com.kosta.openday.user.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.user.dao.UserDAO;
import com.kosta.openday.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	// 회원가입 > 데베에 insert
	@Override
	public void joinUser(UserDTO user) throws Exception {
		user.setUserEmail(user.getEmailVal() + "@" + user.getDomain());

		String str = user.getBirthVal();
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date tempDate = null;

		tempDate = beforeFormat.parse(str);
		String transDate = afterFormat.format(tempDate);
		user.setUserBirth(Date.valueOf(transDate));

		userDAO.insertUser(user);
	}

	@Override
	public void editUserProfile(String id, String nickname, String tel, MultipartFile file) throws Exception {
		String src = "C:\\Users\\KOSTA\\Desktop\\proj_img";

	}

	@Override
	public UserDTO getUserInfo(String id) throws Exception { 
		return userDAO.selectUserInfo(id);

	}
}
