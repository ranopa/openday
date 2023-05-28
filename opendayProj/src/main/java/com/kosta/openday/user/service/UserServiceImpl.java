package com.kosta.openday.user.service;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.user.dao.UserDAO;
import com.kosta.openday.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private FileDAO fileDAO;
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
	public void editUserProfile(Map<String, String> map, MultipartFile file) throws Exception {
		//파일 insert
		if(file!=null && !file.isEmpty()) {
		System.out.println("not null");
			FileDTO fil = new FileDTO(); 
		fil.setFilClassification(file.getContentType());
		fil.setFilOrgName(file.getOriginalFilename());
		fil.setFilSaveName(file.getName());
		fil.setFilSize(file.getSize()); 
		fileDAO.insertFile(fil);
		
		File dfile = new File("resources/image/user/"+fil.getFilSaveName());
		
		System.out.println(dfile.getName());
		file.transferTo(dfile);
		}
		
		//유저 update
		userDAO.updateUser(map);

	}

	@Override
	public UserDTO getUserInfo(String id) throws Exception { 
		return userDAO.selectUserInfo(id);

	}
}
