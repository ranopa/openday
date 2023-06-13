package com.kosta.openday.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.teacher.dto.TeacherFollowDTO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.HeartDTO;
import com.kosta.openday.user.dto.MyRecordDTO;
import com.kosta.openday.user.dto.ReviewDTO;
import com.kosta.openday.user.dto.UserDTO;

//test
public interface UserDAO {

	public void insertUser(UserDTO user) throws Exception;

	public void updateUserPrefer(Map<String, String> map) throws Exception;

	public String selectUserPrefer(String id) throws Exception;

	public List<HeartDTO> selectHeartList(String userId) throws Exception;

	public CollectDTO selectHeartOClass(Integer scdNum) throws Exception;

	public UserDTO selectUserInfo(String id) throws Exception;

	public UserDTO selectUserLogin(Map<String, String> map) throws Exception;

	List<CollectDTO> selectOClassList(HashMap<String, Object> param) throws Exception;

	public List<CollectDTO> selectmainNewOClassList() throws Exception;

	public List<CollectDTO> selectmainHotOClassList() throws Exception;

	public List<CollectDTO> selectMainRequestOClassList() throws Exception;

	public List<CollectDTO> selectMainMenuOClassList(HashMap<String, Object> map) throws Exception;

	public List<CollectDTO> selectMainDeadlineOClassList() throws Exception;

	public List<CollectDTO> selectInputOClassList(HashMap<String, Object> map) throws Exception;

	public void updateUser(Map<String, Object> map) throws Exception;

	public void updateUserDelete(String id) throws Exception;

	public UserDTO selectUserFindId(String userEmail) throws Exception;

	public UserDTO selectUserFindPw(Map<String, Object> param) throws Exception;

	public void resetPassword(UserDTO user) throws Exception;

	public void deleteHeart(Map<String, Object> map) throws Exception;

	public void insertHeart(Map<String, Object> map) throws Exception;

	public List<MyRecordDTO> selectReserveList(Map<String, String> map) throws Exception;

	public List<TeacherFollowDTO> selectFollowList(String userId) throws Exception;

	public TeacherChannelDTO selectTchcChannel(Integer tchcNum) throws Exception;
	
	public CodeDTO selectCode(String codNum) throws Exception;
	
	public UserDTO selectUserByNickName(String userNickname) throws Exception;

	public int searchOClassCount(HashMap<String, Object> map) throws Exception;
	
	public int mainMenuOClassListCount(HashMap<String, Object> map) throws Exception;
	
	public int searchInputSelectCount(HashMap<String, Object> map) throws Exception;

	public Integer selectReviewNum() throws Exception;
	public void insertReview(ReviewDTO reviewDTO) throws Exception;
	public void updateUserAuthority(String userId) throws Exception;
  
	public void updatePrefer(Map<String,String> map)throws Exception;  

	public List<CollectDTO> mainPreferenceOClassList(List<String> preferences) throws Exception;
 
 
}
