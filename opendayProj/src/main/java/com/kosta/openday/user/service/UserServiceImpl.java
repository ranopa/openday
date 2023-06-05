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
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.teacher.dto.TeacherFollowDTO;
import com.kosta.openday.user.dao.UserDAO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.HeartDTO;
import com.kosta.openday.user.dto.MyRecordDTO;
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
	public List<CollectDTO> getSearchOClass(String clsLoc, Date startDate, Date endDate, String clsCode, String keyword)
			throws Exception {
		Map<String, Object> param = new HashMap<>();

		param.put("clsLoc", clsLoc);
		param.put("startDate", startDate);
		param.put("endDate", endDate);

		param.put("clsCode", clsCode);
		param.put("keyword", keyword);

		System.out.println(param);

	

		// TODO Auto-generated method stub
		return userDAO.selectOClassList(param);

	}

	@Override
	public List<CollectDTO> getSearchInputOClass(String keyword) throws Exception {
		return userDAO.selectInputOClassList(keyword);
	}

	@Override
	public List<CollectDTO> getMainNewOClassList() throws Exception {
		return userDAO.selectmainNewOClassList();

	}

	@Override
	public void fileView(Integer id, OutputStream out) throws Exception {
		FileDTO file = fileDAO.selectFile(id); 
		FileInputStream fis = new FileInputStream(uploadDir + file.getFilNum() + file.getFilOrgName());
		FileCopyUtils.copy(fis, out);
		out.flush();
	}

	@Override
	public void withdrawUser(String id) throws Exception {
		userDAO.updateUserDelete(id);

	}

	@Override

	public List<CollectDTO> getMainHotOClassList() throws Exception {
		return userDAO.selectmainHotOClassList();
	}

	@Override
	public List<CollectDTO> getMainRequestOClassList() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectMainRequestOClassList();
	}

	@Override
	public List<CollectDTO> getMainDeadlineOClassList() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectMainDeadlineOClassList();
	}
	
	@Override
	public List<CollectDTO> getMainMenuOClassList(String codNum) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectMainMenuOClassList(codNum);
	}
	
	public List<CollectDTO> HeartOClass(String userId) throws Exception {
		List<CollectDTO> list = new ArrayList<>();
		List<HeartDTO> hearts = userDAO.selectHeartList(userId);

		for (HeartDTO h : hearts) {
			CollectDTO collect = userDAO.selectHeartOClass(h.getClsId());

			list.add(collect); 
		} 

		return list;

	}


	/*
	 * public void func() { String preference = "C1_C3_C15"; String[] code =
	 * preference.split("_");
	 * 
	 * }
	 */

	//찜취소
	@Override
	public void removeHeart(Integer clsId, String userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("clsId", clsId);
		map.put("userId", userId);
		
		userDAO.deleteHeart(map);
		
		
	}
	//찜하기
	@Override
	public void addHeart(Integer clsId, String userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("clsId", clsId);
		map.put("userId", userId);
		
		userDAO.insertHeart(map);
		
		
	}
	//신청내역
	@Override
	public List<MyRecordDTO> getReservedList(String userId, String text) throws Exception {
		Map<String , String> map = new HashMap<>(); 
		map.put("userId", userId);
		map.put("text", text); 
		List<MyRecordDTO> list =  userDAO.selectReserveList(map);
		for(MyRecordDTO mr : list) {
			Date sqlDate = mr.getScdDate();
			java.util.Date uDate = new java.util.Date(sqlDate.getDate());
			
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
			mr.setStrDate(simpleDate.format(uDate)); 
		}
		 
		return list;
	}


	@Override

	public UserDTO getUserFindId(String userEmail) throws Exception {
		// TODO Auto-generated method stub

		return userDAO.selectUserFindId(userEmail);
	}

	public List<TeacherChannelDTO> getTchcList(String userId) throws Exception {
		List<TeacherFollowDTO> followList = userDAO.selectFollowList(userId);
		List<TeacherChannelDTO> channelList = new ArrayList<>();
		for(TeacherFollowDTO f : followList) { 
			channelList.add(userDAO.selectTchcChannel(f.getTchcNum()));
		}
		return channelList;
	}
	


	@Override
	public UserDTO getUserFindPw(String userId, String userEmail) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("userId", userId);
		param.put("userEmail", userEmail);
		return userDAO.selectUserFindPw(param);
	}

	@Override
	public void getResetPassword(UserDTO user) throws Exception {
		userDAO.resetPassword(user);

	}
}
