package com.kosta.openday.user.service;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.user.dao.UserDAO; 
import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.adm.service.FileService;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.teacher.dto.TeacherFollowDTO;
import com.kosta.openday.user.dao.OClassDAO;
import com.kosta.openday.user.dao.UserDAO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.CollectOptionDTO;
import com.kosta.openday.user.dto.HeartDTO;
import com.kosta.openday.user.dto.MyRecordDTO;
import com.kosta.openday.user.dto.ReviewDTO;
import com.kosta.openday.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ServletContext servletContext;

//	private final String uploadDir = String.join(File.separator, System.getProperty("user.dir"), "resources", "upload")
//			+ File.separator;
	
	@Autowired
	private OClassDAO oclassDAO;
	
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
		/* System.out.println(id); */
		UserDTO user = userDAO.selectUserInfo(id);
		if (user == null) {

			return 0;
		}
		/* System.out.println(user.getUserId()); */
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
		// 파일 insert 
		Integer filNum = fileService.createFile(file); 
		// 유저 update
		map.put("filNum", filNum);
		
		userDAO.updateUser(map);

	}
	@Override
	public UserDTO getUserInfo(String id) throws Exception {
		return userDAO.selectUserInfo(id);

	}
			// File dfile = new
			// File("/resources/upload/"+filNum+file.getOriginalFilename());
			File dfile = new File(dir+filNum + file.getOriginalFilename());
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
	public void fileView(Integer id, OutputStream out) throws Exception {
		String dir = servletContext.getRealPath("/resources/upload/");
		FileDTO file = fileDAO.selectFile(id);
		FileInputStream fis = new FileInputStream(dir + file.getFilNum() + file.getFilOriginalname());
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
		    if (userPreferStr == null || userPreferStr.isEmpty()) {
		        return Collections.emptyList();
		    }

		    String[] prefers = userPreferStr.split("_");
		    List<String> preferList = Arrays.asList(prefers);

		    return userDAO.mainPreferenceOClassList(preferList);
		}
	
	
	/*
	 * @Override public List<CollectDTO> mainPreferenceOClassList(String userId)
	 * throws Exception { String userPreferStr = userDAO.selectUserPrefer(userId);
	 * String[] prefers = userPreferStr.split("_");
	 * 
	 * List<String> preferList = Arrays.asList(prefers);
	 * 
	 * return userDAO.mainPreferenceOClassList(preferList); }
	 */
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
	public void resetPassword(UserDTO user) throws Exception {
		userDAO.resetPassword(user);

	}

	@Override
	public CodeDTO getCode(String codNum) throws Exception {
		return userDAO.selectCode(codNum);
	}

	@Override
	public UserDTO userByNickname(String userNickname) throws Exception { 
		return userDAO.selectUserByNickName(userNickname);
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
	@Override
	public void addPrefer(String preferValues, String userId) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("preferValues", preferValues);
		map.put("userId", userId);
		userDAO.updatePrefer(map); 
	}

	@Override
	public List<CollectOptionDTO> getSearchOClassByPopularity() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getSearchOClassByPopularity();
	}

	@Override
	public List<CollectOptionDTO> getSearchOClassByDate() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getSearchOClassByDate();
	}

	@Override
	public List<CollectOptionDTO> getSearchOClassByHighPrice() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getSearchOClassByHighPrice();
	}

	@Override
	public List<CollectOptionDTO> getSearchOClassByLowPrice() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getSearchOClassByLowPrice();
	}
	
	//최제인꺼 삭제하지 마시오.
	@Override 
	public void reviewWrite(Map<String, String> param, String userId) throws Exception {
		
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setScdNum(Integer.valueOf(param.get("scdNum")));
		reviewDTO.setRvContent((String)param.get("content"));
		reviewDTO.setRvStar(Integer.valueOf(param.get("rating")));
		reviewDTO.setUserId(userId);
		Integer rvNum = userDAO.selectReviewNum();
		System.out.println(rvNum);
		reviewDTO.setRvNum(rvNum);
		System.out.println(param.get("scdNum"));
		ScheduleDTO scheduleDTO = oclassDAO.selectSchedule(Integer.valueOf(param.get("scdNum")));
		reviewDTO.setClsId(scheduleDTO.getClsId());
		System.out.println(reviewDTO.getRvNum());
		userDAO.insertReview(reviewDTO);
	} 	


	@Override 
	public void alterAuthorityTchc(String userId) throws Exception {
		userDAO.updateUserAuthority(userId);
	}
	 
	public String[] getUserPrefer(String userId) throws Exception {
		String[] userPrefer = null;
		String str = userDAO.selectUserInfo(userId).getUserPreference();  
		if(str!=null) {
			userPrefer = str.split("_");  
		}
		return userPrefer; 
		
	}  
}
