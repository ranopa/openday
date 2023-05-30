package com.kosta.openday.adm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dao.FileDAO;
import com.kosta.openday.adm.dto.FileDTO;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDAO fileDAO;
	@Override
	public void createFile(FileDTO file) throws Exception {
		fileDAO.insertFile(file); 
	}
	

}
