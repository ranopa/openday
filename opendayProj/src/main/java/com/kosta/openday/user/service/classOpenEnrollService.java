package com.kosta.openday.user.service;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.user.dto.OClassDTO;

public interface classOpenEnrollService {
	public void classCreate(OClassDTO dto, MultipartFile file) throws Exception;
	OClassDTO getOclass(Integer clsId) throws Exception;
}
