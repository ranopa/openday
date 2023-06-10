package com.kosta.openday.user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.adm.service.FileService;
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
	private FileService fileService;;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	private final String uploadDir = "/resources/upload/";
  

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

//		Integer filNum = 0;
//
//		if (file != null && !file.isEmpty()) {
//			FileDTO fil = new FileDTO();
//			fil.setFilClassification(file.getContentType());
//			fil.setFilOrgName(file.getOriginalFilename());
//			fil.setFilSaveName(file.getName());
//			fil.setFilSize(file.getSize());
//			filNum = fileDAO.selectNewFileId();
//			fil.setFilNum(filNum);
//			fileDAO.insertFile(fil);

			// File dfile = new
			// File("/resources/upload/"+filNum+file.getOriginalFilename());
//			File dfile = new File(servletContext.getRealPath(uploadDir) + filNum);
//
//			file.transferTo(dfile);
//			map.put("filNum", filNum); 
		Integer fileNum = 0;
		try {
			fileNum = fileService.createFile(file);
			map.put("filNum", fileNum);
			userDAO.updateUser(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public List<CollectDTO> getSearchOClass(HashMap<String, Object> map)
			throws Exception {

		return userDAO.selectOClassList(map);

	}

	@Override
	public List<CollectDTO> getSearchInputOClass(HashMap<String, Object> map) throws Exception {
		return userDAO.selectInputOClassList(map);
	}

	@Override
	public List<CollectDTO> getMainNewOClassList() throws Exception {
		return userDAO.selectmainNewOClassList();

	}

	@Override
	public void fileView(Integer id, OutputStream out) throws Exception {
		FileInputStream fis = new FileInputStream(servletContext.getRealPath(uploadDir) + id);
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
	public List<CollectDTO> getMainMenuOClassList(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectMainMenuOClassList(map);
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

	@Override
	public List<CollectDTO> mainPreferenceOClassList(String userId) throws Exception {
		String userPreferStr = userDAO.selectUserPrefer(userId);
		String[] prefers = userPreferStr.split("_");
		
		List<String> preferList = Arrays.asList(prefers);

		return userDAO.mainPreferenceOClassList(preferList);
	}
	/*
	 * public void func() { String preference = "C1_C3_C15"; String[] code =
	 * preference.split("_");
	 * 
	 * }
	 */	 

	// 찜취소
	@Override
	public void removeHeart(Integer clsId, String userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("clsId", clsId);
		map.put("userId", userId);

		userDAO.deleteHeart(map);

	}

	// 찜하기
	@Override
	public void addHeart(Integer clsId, String userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("clsId", clsId);
		map.put("userId", userId);

		userDAO.insertHeart(map);

	}

	// 신청내역
	@Override
	public List<MyRecordDTO> getReservedList(String userId, String text) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("text", text);
		List<MyRecordDTO> list = userDAO.selectReserveList(map);
		for (MyRecordDTO mr : list) {
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
		for (TeacherFollowDTO f : followList) {
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
	public void sendEmail(UserDTO user, String div) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
		String hostSMTPid = "서버 이메일 주소(보내는 사람 이메일 주소)";
		String hostSMTPpwd = "서버 이메일 비번(보내는 사람 이메일 비번)";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "보내는 사람 이메일주소(받는 사람 이메일에 표시됨)";
		String fromName = "프로젝트이름 또는 보내는 사람 이름";
		String subject = "";
		String msg = "";

		if(div.equals("findpw")) {
			subject = "베프마켓 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += user.getUserId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += user.getUserPassword() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = user.getUserEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587); //네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	//비밀번호찾기
	@Override
	public void findPw(HttpServletResponse response, UserDTO user) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		UserDTO ck = userDAO.selectUserFindId(user.getUserId());
		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면
		if(userDAO.selectUserFindId(user.getUserId()) == null) {
			out.print("등록되지 않은 아이디입니다.");
			out.close();
		}
		// 가입된 이메일이 아니면
		else if(!user.getUserEmail().equals(ck.getUserEmail())) {
			out.print("등록되지 않은 이메일입니다.");
			out.close();
		}else {
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			user.setUserPassword(pw);
			// 비밀번호 변경
			userDAO.updatePw(user);
			// 비밀번호 변경 메일 발송
			sendEmail(user, "findpw");

			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}
	}
	
	@Override
	public void getResetPassword(UserDTO user) throws Exception {
		userDAO.resetPassword(user);

	}

	@Override
	public CodeDTO getCode(String codNum) throws Exception {
		return userDAO.selectCode(codNum);
	}
	
	public int searchOClassCount(HashMap<String, Object> map) throws Exception {
		return userDAO.searchOClassCount(map);
	}
	
	@Override
	public int mainMenuOClassListCount(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.mainMenuOClassListCount(map);
	}
	
	@Override
	public int searchInputSelectCount(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.searchInputSelectCount(map);
	}
	
}
