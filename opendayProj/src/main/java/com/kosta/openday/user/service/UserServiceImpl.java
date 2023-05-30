package com.kosta.openday.user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
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
	@Autowired
	private ServletContext servletContext;

//	private final String uploadDir = String.join(File.separator, System.getProperty("user.dir"), "resources", "upload")
//			+ File.separator;

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

	// idcheck

	@Override
	public int idCheck(String id) throws Exception {
		UserDTO user = userDAO.selectUserInfo(id);
		if (user == null) {
			return 0;
		}
		return 1;

	}

	@Override
	public void editUserProfile(Map<String, Object> map, MultipartFile file) throws Exception {
		// 파일 insert
		Integer filNum = 0;
		String dir = servletContext.getRealPath("/resources/upload/");

		if (file != null && !file.isEmpty()) {
			FileDTO fil = new FileDTO();
			fil.setFilClassification(file.getContentType());
			fil.setFilOrginalname(file.getOriginalFilename());
			fil.setFilSavename(file.getName());
			fil.setFilSize(file.getSize());
			fileDAO.insertFile(fil);

			filNum = fileDAO.selectNewFileId();
			
			filNum -= 1; // 왜 새로 얻어오는지.. INSERT하고 리턴해야할듯
			
			// File dfile = new
			// File("/resources/upload/"+filNum+file.getOriginalFilename());
			File dfile = new File(dir+filNum + file.getOriginalFilename());
		

			file.transferTo(dfile);
			map.put("filNum", filNum);
		}
		// 유저 update
		userDAO.updateUser(map);

	}

	@Override
	public UserDTO getUserInfo(String id) throws Exception {
		return userDAO.selectUserInfo(id);

	}

	@Override
	public void fileView(Integer id, OutputStream out) throws Exception {
		String dir = servletContext.getRealPath("/resources/upload/");
		FileDTO file = fileDAO.selectFile(id);
		FileInputStream fis = new FileInputStream(dir + file.getFilNum() + file.getFilOriginalname());
		  
		FileCopyUtils.copy(fis, out);
		out.flush();
	}
//	
//	@Override
//	public String fileView(Integer id, HttpServletResponse response) throws Exception {
//		String dir = servletContext.getRealPath("/resources/upload/");
//		FileDTO file = fileDAO.selectFile(id);
//		return dir+""+file.getFilNum()+""+file.getFilOriginalname();
//		
//		
//	}

	@Override
	public void withdrawUser(String id) throws Exception {
		userDAO.updateUserDelete(id);

	}

}
