package com.kosta.openday.adm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.adm.dto.FileDTO;

@Repository
public class AdmDAOImpl implements AdmDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertInquiry(AdmInquiryDTO dto) throws Exception {
		return sqlSession.insert("mapper.notice.insertAdmInquiry", dto);
	}

	@Override
	public void insertFile(FileDTO file) throws Exception {
		sqlSession.insert("mapper.amd.insertFile", file) ;	
	}

	@Override
	public Integer selectFileNum() throws Exception {
		return sqlSession.selectOne("mapper.amd.newFileId");
	}

	@Override
	public FileDTO selectFile(Integer filNum) throws Exception {
		return sqlSession.selectOne("mapper.amd.newFileId", filNum);
	}

	@Override
	public List<AdmInquiryDTO> selectInquiryList() throws Exception {
		return sqlSession.selectList("mapper.notice.selectAdmInquiryList");
	}

	@Override
	public void deleteInquiry(Integer admNum) throws Exception {
		sqlSession.delete("mapper.notice.deleteAdmInquiry", admNum);	
	}

	@Override
	public void updateInquiry(Map<String, Object> param) throws Exception {
		sqlSession.update("mapper.notice.updateAdmInquiry", param);		
	}
	
	// admin에서 개설신청 대기중인 클래스 목록 조회
	@Override
	public List<OClassDTO> selectOClassByStatus(String status) throws Exception {
		return sqlSession.selectList("mapper.adm.selectOClassByStatus", status);
	}

	@Override
	public void updateOClassStatus(Map<String, Object> map) throws Exception {
		sqlSession.update("mapper.adm.updateOClassStatus", map);
	}

	@Override
	public List<AdmUserViewDTO> selectUserList() throws Exception {
		return sqlSession.selectList("mapper.adm.selectAllUserWithTeacherInfo");
	}

	@Override
	public List<AdmInquiryDTO> selectAdmInquiryList() throws Exception {
		return sqlSession.selectList("mapper.adm.selectAdmInquiryList");
	}

	@Override
	public AdmInquiryDTO selectAdmInquiry(Integer admNum) throws Exception {
		return sqlSession.selectOne("mapper.adm.selectAdmInquiry", admNum);
	}

	@Override
	public List<AnnouncementDTO> selectAnnouncementList() throws Exception {
		return sqlSession.selectList("mapper.announcement.selectAnnouncementList");
	}

	@Override
	public AnnouncementDTO selectAnnouncement(Integer ancId) throws Exception {
		return sqlSession.selectOne("mapper.announcement.selectAnnouncement", ancId);
	}
	
	@Override
	public void insertAnnouncement(Map map) throws Exception {
		sqlSession.insert("mapper.announcement.insertAnnouncement", map);
	}
	
}
