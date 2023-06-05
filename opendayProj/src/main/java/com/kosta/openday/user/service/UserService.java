package com.kosta.openday.user.service;


import java.io.OutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.MyRecordDTO;
import com.kosta.openday.user.dto.UserDTO;

public interface UserService {
	void joinUser(UserDTO user) throws Exception;


	void editUserProfile(Map<String, Object> map, MultipartFile file) throws Exception;

	UserDTO getUserInfo(String id) throws Exception;


	public UserDTO userLogin(Map<String, String> map) throws Exception;

	List<CollectDTO> getSearchOClass(String clsLoc, Date startDate, Date endDate, String clsCode, String keyword)
			throws Exception;

	public List<CollectDTO> getSearchInputOClass(String keyword)
			throws Exception;
	
	  public List<CollectDTO> getMainNewOClassList() throws Exception;
	 
		
		  public List<CollectDTO> getMainHotOClassList() throws Exception;
		 
		  public List<CollectDTO> getMainRequestOClassList() throws Exception;
		  public List<CollectDTO> getMainDeadlineOClassList() throws Exception;
		  public List<CollectDTO> getMainMenuOClassList(String codNum) throws Exception;
		  
	void fileView(Integer id, OutputStream out) throws Exception;

	void withdrawUser(String id) throws Exception;

	int idCheck(String id) throws Exception; 
	
	List<CollectDTO> HeartOClass(String userId) throws Exception;

	
	UserDTO getUserFindId(String userEmail) throws Exception;
	UserDTO getUserFindPw(String userId, String userEmail) throws Exception; 
	void getResetPassword(UserDTO user) throws Exception;


	//찜하기, 찜취소
	public void removeHeart(Integer clsId,String userId)throws Exception;
	public void addHeart(Integer clsId,String userId)throws Exception;

	//마이페이지 클래스 신청 내역
	public List<MyRecordDTO> getReservedList(String userId,String text)throws Exception;
	
	//팔로우강사목록보기
	List<TeacherChannelDTO> getTchcList(String userId)throws Exception;


}
