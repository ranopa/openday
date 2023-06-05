package com.kosta.openday.adm.service;

import java.util.List;

import com.kosta.openday.user.dto.OClassDTO;

public interface AdmService {
	List<OClassDTO> findOClassByStatus(String status) throws Exception;
}
