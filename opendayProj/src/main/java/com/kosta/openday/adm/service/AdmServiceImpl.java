package com.kosta.openday.adm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void allowOClass(Integer clsId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "승인");
		map.put("clsId", clsId);
		
		admDAO.updateOClassStatus(map);
	}

	@Override
	public void refuseOClass(Integer clsId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "승인거절");
		map.put("clsId", clsId);
		
		admDAO.updateOClassStatus(map);
		
	}
	
}
