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

import com.kosta.openday.adm.dao.AdmDAO;
import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.FileDTO;

@Service
public class AdmServiceImpl implements AdmService {
	@Autowired
	private AdmDAO admDAO;
	
	@Autowired
	private FileDAO fileDAO;
	
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

	
}
