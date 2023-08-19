package com.kosta.openday.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.teacher.dto.TeacherFollowDTO;
import com.kosta.openday.user.dto.CollectDTO;
import com.kosta.openday.user.dto.CollectOptionDTO;
import com.kosta.openday.user.dto.HeartDTO;
import com.kosta.openday.user.dto.MyRecordDTO;
import com.kosta.openday.user.dto.ReviewDTO;
import com.kosta.openday.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 회원가입
	@Override
	public void insertUser(UserDTO user) throws Exception {
		sqlSession.insert("mapper.user.insertUser", user);
	}

	@Override
	public void updateUserPrefer(Map<String, String> map) throws Exception {
		sqlSession.update("mapper.user.updateUserPrefer", map);
	}

	@Override
	public String selectUserPrefer(String id) throws Exception {
		return sqlSession.selectOne("mapper.user.selectUserPrefer", id);
	}

	@Override
	public UserDTO selectUserLogin(Map<String, String> map) throws Exception {
		return sqlSession.selectOne("mapper.user.userLogin", map);
	}

	public UserDTO selectUserInfo(String id) throws Exception {
		return sqlSession.selectOne("mapper.user.selectUser", id);
	}

	@Override
	public List<CollectDTO> selectmainNewOClassList() throws Exception {
		return sqlSession.selectList("mapper.user.mainNewOClassList");

	}

	@Override
	public List<CollectDTO> selectOClassList(HashMap<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		int count = param.size();
		/* System.out.println("Map의 갯수: " + count); */

		return sqlSession.selectList("mapper.search.searchSelect", param);
	}

	public void updateUser(Map<String, Object> map) throws Exception {
		sqlSession.update("mapper.user.updateUser", map);

	}

	@Override
	public void updateUserDelete(String id) throws Exception {
		sqlSession.update("mapper.user.updateUserDelete", id);

	}

	@Override
	public List<HeartDTO> selectHeartList(String userId) throws Exception {
		return sqlSession.selectList("mapper.user.selectHeartList", userId);
	}

	@Override
	public CollectDTO selectHeartOClass(Integer scdNum) throws Exception {
		return sqlSession.selectOne("mapper.user.selectHeartOClass", scdNum);

	}

	@Override
	public List<CollectDTO> selectInputOClassList(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List<CollectDTO> list = sqlSession.selectList("mapper.search.searchInputSelect", map);
		int count = list.size();
		/* System.out.println("Map의 갯수: " + count); */
		return list;
	}

	@Override
	public UserDTO selectUserFindId(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.user.userFindId", userEmail);
	}

	@Override
	public UserDTO selectUserFindPw(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.user.userFindPw", param);
	}

	@Override
	public void resetPassword(UserDTO user) throws Exception {
		sqlSession.selectOne("mapper.user.resetPassword", user);

	}

	@Override
	public List<CollectDTO> selectmainHotOClassList() throws Exception {
		return sqlSession.selectList("mapper.user.mainHotOClassList");
	}

	@Override
	public List<CollectDTO> selectMainRequestOClassList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.user.mainRequestOClassList");
	}

	@Override
	public List<CollectDTO> selectMainDeadlineOClassList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.user.mainDeadlineOClassList");
	}

	@Override
	public List<CollectDTO> selectMainMenuOClassList(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List<CollectDTO> list = sqlSession.selectList("mapper.user.mainMenuOClassList", map);
		return list;
	}

	@Override
	public void deleteHeart(Map<String, Object> map) throws Exception {
		sqlSession.delete("mapper.user.deleteHeart", map);

	}

	@Override
	public void insertHeart(Map<String, Object> map) throws Exception {
		sqlSession.insert("mapper.user.insertHeart", map);

	}

	@Override
	public List<MyRecordDTO> selectReserveList(Map<String, String> map) throws Exception {
		return sqlSession.selectList("mapper.user.selectReserveList", map);

	}

	@Override
	public List<TeacherFollowDTO> selectFollowList(String userId) throws Exception {
		return sqlSession.selectList("mapper.user.selectFollowList", userId);
	}

	@Override
	public TeacherChannelDTO selectTchcChannel(Integer tchcNum) throws Exception {
		return sqlSession.selectOne("mapper.user.selectChannelOne", tchcNum);
	}

	@Override
	public CodeDTO selectCode(String codNum) throws Exception {
		return sqlSession.selectOne("mapper.user.selectCode", codNum);
	}

	@Override
	public UserDTO selectUserByNickName(String userNickname) throws Exception { 
		System.out.println(userNickname);
		UserDTO user =  sqlSession.selectOne("mapper.user.selectUserByNickname",userNickname);
		if(user==null) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		System.out.println(user);
		System.out.println(user.getUserNickname());
		return user;
	} 
 
	public int searchOClassCount(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectOne("mapper.search.searchOClassCount", map);
	}

	@Override
	public int mainMenuOClassListCount(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.user.mainMenuOClassListCount", map);
	}

	@Override
	public int searchInputSelectCount(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.search.searchInputSelectCount", map);
	}
 
	@Override 
	public void updateUserAuthority(String userId) throws Exception {
		sqlSession.update("mapper.user.updateUserAuthorty", userId);
	} 
	public void updatePrefer(Map<String, String> map) throws Exception {
		sqlSession.update("mapper.user.updatePrefer", map);
		
	} 
	
	
	@Override
	public List<CollectDTO> mainPreferenceOClassList(List<String> preferences) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.user.mainPreferenceOClassList",preferences);
 
	}


	@Override
	public List<CollectOptionDTO> getSearchOClassByPopularity() throws Exception {
		// TODO Auto-generated method stub
		 return sqlSession.selectList("mapper.user.getSearchOClassByPopularity");
	}

	@Override
	public List<CollectOptionDTO> getSearchOClassByDate() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.user.getSearchOClassByDate");
	}

	@Override
	public List<CollectOptionDTO> getSearchOClassByHighPrice() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.user.getSearchOClassByHighPrice");
	}

	@Override
	public List<CollectOptionDTO> getSearchOClassByLowPrice() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.user.getSearchOClassByLowPrice");
	}
	 


	
	//최제인꺼 삭제하지 마시오
	@Override 
	public Integer selectReviewNum() throws Exception {
		return sqlSession.selectOne("mapper.user.selectReviewNum");
	}
	
	//최제인꺼 삭제하지 마시오
	@Override
	public void insertReview(ReviewDTO reviewDTO) throws Exception {
		sqlSession.selectOne("mapper.user.insertReview", reviewDTO);
	} 	

}