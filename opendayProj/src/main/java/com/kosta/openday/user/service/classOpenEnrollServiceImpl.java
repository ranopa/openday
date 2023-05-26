package com.kosta.openday.user.service;

import org.springframework.stereotype.Service;

import com.kosta.openday.user.dao.classOpenEnrollDAO;
import com.kosta.openday.user.dto.OClassDTO;

@Service
public class classOpenEnrollServiceImpl implements classOpenEnrollService {
	
private classOpenEnrollDAO classopenenrollDAO;
	
	@Override
	public void classCreate(OClassDTO dto) throws Exception {
		classopenenrollDAO.classOpen(dto);
	}
}
