package com.kosta.openday.oclass.service;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.oclass.dto.OclassDTO;

public interface OClassService {
	public void classCreate(OclassDTO dto) throws Exception;
	//public void classCreate(OclassDTO dto, MultipartFile file) throws Exception;
}
