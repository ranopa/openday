package com.kosta.openday.adm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.AdmDAO;
import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.user.dto.OClassDTO;

@Service
public class AdmServiceImpl implements AdmService {
	
	@Autowired
	private AdmDAO admDAO;
	
	@Autowired
	private FileService fileService;

	@Override
	public List<OClassDTO> findOClassByStatus(String status) throws Exception {
		return admDAO.selectOClassByStatus(status);
	}

	@Override
	public void allowOClass(Integer clsId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "승인");
		map.put("clsId", clsId);
		
		admDAO.updateOClassStatus(map);
	}

	@Override
	public void refuseOClass(Integer clsId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "승인거절");
		map.put("clsId", clsId);
		
		admDAO.updateOClassStatus(map);
	}
	
	@Override
	public List<AdmUserViewDTO> findAllUser() throws Exception {
		return admDAO.selectUserList();
	}

	@Override
	public List<AdmInquiryDTO> findAllAdmInquiryList() throws Exception {
		return admDAO.selectAdmInquiryList();
	}

	@Override
	public AdmInquiryDTO findAdmInquiry(Integer admNum) throws Exception {
		return admDAO.selectAdmInquiry(admNum);
	}

	@Override
	public List<AnnouncementDTO> findAnnouncementList() throws Exception {
		return admDAO.selectAnnouncementList();
	}

	@Override
	public AnnouncementDTO findAnnouncement(Integer ancId) throws Exception {
		return admDAO.selectAnnouncement(ancId);
	}

	@Override
	public void writeAdmAnnouncement(Map<String, Object> map) throws Exception {
		MultipartFile file = null;
		if (!(map.get("file") instanceof MultipartFile)) {
			throw new Exception("file is not instance of MultipartFile");
		} 
		
		try {
			file = (MultipartFile)map.get("file");
			Integer fileNum = fileService.createFile(file);
			
			map.remove("file");
			map.put("fileNum", fileNum);
			
			admDAO.insertAnnouncement(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
