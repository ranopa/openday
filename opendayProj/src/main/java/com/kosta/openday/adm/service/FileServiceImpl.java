package com.kosta.openday.adm.service;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.FileDTO;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private ServletContext servletContext;
	
	private final String uploadDir = "/resources/upload/";
	
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public Integer createFile(MultipartFile file) throws Exception {
		if (file == null || file.isEmpty()) {
			throw new Exception("file'"+ file.getName() + "' is null or empty");
		}
		Integer filNum = 0;
		FileDTO fil = new FileDTO();
		
		fil.setFilClassification(file.getContentType());
		fil.setFilOrgName(file.getOriginalFilename());
		fil.setFilSaveName(file.getName());
		fil.setFilSize(file.getSize());
		filNum = fileDAO.selectNewFileId();
		fil.setFilNum(filNum);
		fileDAO.insertFile(fil);


		File dfile = new File(servletContext.getRealPath(uploadDir) + filNum);

		file.transferTo(dfile);
		
		return filNum;
	}
	
	
	

}


