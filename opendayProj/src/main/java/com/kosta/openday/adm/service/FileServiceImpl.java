package com.kosta.openday.adm.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.FileDTO;

@Service
public class FileServiceImpl implements FileService {
	
	private final String uploadDir = String.join(File.separator, System.getProperty("user.dir"), "resources", "upload")
			+ File.separator;

	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public Integer createFile(MultipartFile file) throws Exception {
		if (file == null || file.isEmpty()) {
			throw new Exception("file'"+ file.getName() + "' is null or empty");
		}
		Integer fileNum = 0;
		FileDTO fil = new FileDTO();
		
		fil.setFilClassification(file.getContentType());
		fil.setFilOrgName(file.getOriginalFilename());
		fil.setFilSaveName(file.getName());
		fil.setFilSize(file.getSize());
		
		fileDAO.insertFile(fil);

		fileNum = fileDAO.selectNewFileId() - 1;

		File dfile = new File(uploadDir + fileNum);

		file.transferTo(dfile);
		
		return fileNum;
	}
	
	
	

}
