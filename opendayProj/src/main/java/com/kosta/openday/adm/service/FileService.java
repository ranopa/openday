package com.kosta.openday.adm.service;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dto.FileDTO;

public interface FileService {
	Integer createFile(MultipartFile file) throws Exception;
}