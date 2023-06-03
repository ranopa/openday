package com.kosta.openday.user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.user.dao.UserDAO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.HeartDTO;
import com.kosta.openday.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private FileDAO fileDAO;
	@Autowired
	private UserDAO userDAO;

	private final String uploadDir = String.join(File.separator, System.getProperty("user.dir"), "resources", "upload")
			+ File.separator;

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

		if (file != null && !file.isEmpty()) {
			FileDTO fil = new FileDTO();
			fil.setFilClassification(file.getContentType());
			fil.setFilOrgName(file.getOriginalFilename());
			fil.setFilSaveName(file.getName());
			fil.setFilSize(file.getSize());
			fileDAO.insertFile(fil);

			filNum = fileDAO.selectNewFileId();

			filNum -= 1; // 왜 새로 얻어오는지.. INSERT하고 리턴해야할듯

			// File dfile = new
			// File("/resources/upload/"+filNum+file.getOriginalFilename());
			File dfile = new File(uploadDir + filNum + file.getOriginalFilename());

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

	/*
	 * @Override public UserDTO userLogin(Map<String, String> map) throws Exception
	 * { return userDAO.selectUserLogin(map);
	 * 
	 * }
	 */

	@Override
	public UserDTO userLogin(Map<String, String> map) throws Exception {
		UserDTO user = userDAO.selectUserLogin(map);

		if (user == null || user.getUserActivation().equals("0")) {
			// 회원 활성화가 0인 경우 로그인 실패 처리
			throw new Exception("로그인 실패");
		}

		return user;
	}

	@Override
	public List<CollectDTO> getSearchOClass( String clsLoc, Date startDate, Date endDate, String clsCode)
			throws Exception {
		Map<String, Object> param = new HashMap<>();
		
		param.put("clsLoc", clsLoc);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("clsCode", clsCode);
		System.out.println(param);
		// TODO Auto-generated method stub
		return userDAO.selectOClassList(param);

	}

	
	  @Override public List<CollectDTO> getMainNewOClassList() throws Exception {
	  return userDAO.selectmainNewOClassList();
	  
	  }
	 

	@Override
	public void fileView(Integer id, OutputStream out) throws Exception {
		FileDTO file = fileDAO.selectFile(id);
		System.out.println(uploadDir + file.getFilNum() + file.getFilOrgName());
		FileInputStream fis = new FileInputStream(uploadDir + file.getFilNum() + file.getFilOrgName());
		FileCopyUtils.copy(fis, out);
		out.flush();
	}

	@Override
	public void withdrawUser(String id) throws Exception {
		userDAO.updateUserDelete(id);

	}

	/*
	 * @Override
	 * 
	 * public List<CollectDTO> getMainHotOClassList() throws Exception { return
	 * userDAO.selectmainHotOClassList(); }
	 */

	public List<CollectDTO> HeartOClass(String userId) throws Exception {  
		List<CollectDTO> list = new ArrayList<>();  
		List<HeartDTO> hearts = userDAO.selectHeartList(userId);
		
		for(HeartDTO h:hearts) {  
			CollectDTO collect = userDAO.selectHeartOClass(h.getClsId());
			list.add(collect);
			System.out.println(collect.toString());
		} 
		return list;
				
	}
	
	/*
	 * public void func() { String preference = "C1_C3_C15"; String[] code =
	 * preference.split("_");
	 * 
	 * }
	 */


}
