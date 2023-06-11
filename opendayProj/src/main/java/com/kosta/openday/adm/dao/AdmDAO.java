package com.kosta.openday.adm.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.FileDTO;

public interface AdmDAO {


	List<OClassDTO> selectOClassByStatus(String status) throws Exception;
	void updateOClassStatus(Map<String, Object> map) throws Exception;
	List<AdmUserViewDTO> selectUserList() throws Exception;
	List<AdmInquiryDTO> selectAdmInquiryList() throws Exception;
	AdmInquiryDTO selectAdmInquiry(Integer admNum) throws Exception;
	List<AnnouncementDTO> selectAnnouncementList() throws Exception;
	AnnouncementDTO selectAnnouncement(Integer ancId) throws Exception;
	void insertAnnouncement(Map map) throws Exception;

	public int insertInquiry(AdmInquiryDTO dto) throws Exception;
	public void insertFile(FileDTO file) throws Exception;
	Integer selectFileNum() throws Exception;
	FileDTO selectFile(Integer filNum) throws Exception;
	List<AdmInquiryDTO> selectInquiryList() throws Exception;
	void deleteInquiry(Integer admNum) throws Exception;
	void updateInquiry(Map<String,Object> param) throws Exception; 
	void updateAnInquiry(Map<String,Object> map)throws Exception;

	void deleteNotice(Integer ancId) throws Exception;
}
