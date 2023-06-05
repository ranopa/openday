package com.kosta.openday.adm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dao.AdmDAO;
import com.kosta.openday.user.dto.OClassDTO;

@Service
public class AdmServiceImpl implements AdmService {
	
	@Autowired
	private AdmDAO admDAO;

	@Override
	public List<OClassDTO> findOClassByStatus(String status) throws Exception {
		return admDAO.selectOClassByStatus(status);
	}
	
	
}
