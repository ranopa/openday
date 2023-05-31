package com.kosta.openday.user.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.user.dao.classOpenEnrollDAO;
import com.kosta.openday.user.dto.OClassDTO;

@Service
public class classOpenEnrollServiceImpl implements classOpenEnrollService {

	@Autowired
	private classOpenEnrollDAO classopenenrollDAO;

	@Override
	public void classCreate(OClassDTO dto, MultipartFile file) throws Exception {
		if(file!=null && !file.isEmpty()) {
			String dir = "D:/MJS/openday_file/";
			
			Integer fileNum = classopenenrollDAO.selectFileNum();
			
			FileDTO fileDTO = new FileDTO();
			fileDTO.setFilNum(fileNum);
			fileDTO.setFilOriginalname(file.getOriginalFilename());
			fileDTO.setFilSize((int) file.getSize());
			fileDTO.setFilClassification(file.getContentType());
			classopenenrollDAO.insertFile(fileDTO);
			
			File dfile = new File(dir+fileDTO.getFilNum());
			file.transferTo(dfile);
			dto.setFilNum(fileDTO.getFilNum());
		}
		classopenenrollDAO.classOpen(dto);
	}

	@Override
	public OClassDTO getOclass(Integer clsId) throws Exception {
		return classopenenrollDAO.selectOclass(clsId);
	}
}
