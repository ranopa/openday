package com.kosta.openday.teacher.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.teacher.dto.ClassScdUserDTO;
import com.kosta.openday.teacher.dto.ClassScheduleDTO;
import com.kosta.openday.teacher.dto.SettlementAmountDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.teacher.dto.TeacherScheduleDTO;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	public List<AnnouncementDTO> tcAnnouncementList() {
		return sqlSession.selectList("mapper.teacherMain.tcAnnouncementList");
	}
	public List<OClassDTO> tcClassList(HashMap<String, Object> map) {
		return sqlSession.selectList("mapper.teacherClass.tcClassList", map);
	}
	@Override
	public int tcClassListCount(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectOne("mapper.teacherClass.tcClassListCount", map);
	}
	@Override
	public List<ClassScheduleDTO> tcClassScheduleList(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("mapper.teacherClass.tcClassScheduleList", map);
	}
	@Override
	public List<ClassScdUserDTO> tcClassUserList(Integer scdNum) throws Exception {
		return sqlSession.selectList("mapper.teacherClass.tcClassUserList", scdNum);
	}
	@Override
	public int tcClassScheduleListCount(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectOne("mapper.teacherClass.tcClassScheduleListCount", map);
	}
	@Override
	public List<ClsInquiryDTO> tcClassInquiryList(Integer clsId) throws Exception {
		return sqlSession.selectList("mapper.teacherClass.tcClassInquiryList", clsId);
	}
	@Override
	public List<TeacherScheduleDTO> tcScheduleList(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("mapper.teacherClass.tcScheduleList", map);
	}
	@Override
	public List<OClassDTO> tcClassSalesList(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("mapper.teacherClass.tcClassSalesList", map);
	}
	@Override
	public int tcClassSalesListCount(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectOne("mapper.teacherClass.tcClassSalesListCount", map);
	}
	@Override
	public List<SettlementAmountDTO> tcSalesList(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("mapper.teacherClass.tcSalesList", map);
	}
	@Override
	public void tcProfileAdd(FileDTO dto) throws Exception {
		sqlSession.insert("mapper.teacherMain.tcProfileAdd", dto);
		
	}
	@Override
	public void tcProfileUpdate(FileDTO dto) throws Exception {
		sqlSession.update("mapper.teacherMain.tcProfileUpdate", dto);
		
	}
	@Override
	public FileDTO tcProfileInfo(int filNum) throws Exception {
		return sqlSession.selectOne("mapper.teacherMain.tcProfileInfo", filNum);
	}
	@Override
	public void tcProfileUserUpdate(TeacherChannelDTO dto) throws Exception {
		sqlSession.update("mapper.teacherMain.tcProfileUserUpdate", dto);
	}
	
	
}
