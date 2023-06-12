package com.kosta.openday.adm.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.AdmDAO;
import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.AdmUserViewDTO;
import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.user.dto.OClassDTO;

@Service
public class AdmServiceImpl implements AdmService {
	@Autowired
	private AdmDAO admDAO;
	
	@Autowired
	private FileDAO fileDAO;
	
	@Autowired
	private FileService fileService;
	
	private final String uploadDir = String.join(File.separator, System.getProperty("user.dir"), "resources", "upload")
			+ File.separator;

	/*
	 * @Override public void admInquiryInsert(AdmInquiryDTO dto, MultipartFile file)
	 * throws Exception { if(file!=null && !file.isEmpty()) { String dir =
	 * "C:/openday_file/";
	 * 
	 * Integer fileNum = admDAO.selectFileNum();
	 * 
	 * FileDTO fileDTO = new FileDTO(); fileDTO.setFilNum(fileNum);
	 * fileDTO.setFilOrgName(file.getOriginalFilename()); fileDTO.setFilSize((long)
	 * file.getSize()); fileDTO.setFilClassification(file.getContentType());
	 * admDAO.insertFile(fileDTO);
	 * 
	 * File dfile = new File(dir+fileDTO.getFilNum()); file.transferTo(dfile);
	 * dto.setFilNum(fileDTO.getFilNum()); } admDAO.insertInquiry(dto); }
	 */

	@Override
	public void fileView(Integer filNum, OutputStream out) throws Exception {
		FileDTO file = fileDAO.selectFile(filNum); 
		FileInputStream fis = new FileInputStream(uploadDir + file.getFilNum() + file.getFilOrgName());
		FileCopyUtils.copy(fis, out);
		out.flush();
	}

	@Override
	public void inquiryInsert(AdmInquiryDTO dto) throws Exception {
		admDAO.insertInquiry(dto);
	}

	@Override
	public List<AdmInquiryDTO> inquiryListSelect() throws Exception {
		return admDAO.selectInquiryList();
	}

	@Override
	public void inquiryDelete(Integer admNum) throws Exception {
		admDAO.deleteInquiry(admNum);
	}

	@Override
	public void inquiryUpdate(Integer admNum, String admTitle, String admContent) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("admNum", admNum);
		map.put("admTitle", admTitle);
		map.put("admContent", admContent);
		admDAO.updateInquiry(map);
	}

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

	@Override
	public void inquiryAnswer(Integer admNum, String admAnContent) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("admAnContent", admAnContent);
		map.put("admNum", admNum);
		admDAO.updateAnInquiry(map); 
	}

	@Override
	public void removeNotice(Integer ancId) throws Exception {
		admDAO.deleteNotice(ancId);
		
	}

	@Override
	public String getCodeName(String codNum) throws Exception { 
		return admDAO.selectCategoryByCode(codNum);
	}
}
