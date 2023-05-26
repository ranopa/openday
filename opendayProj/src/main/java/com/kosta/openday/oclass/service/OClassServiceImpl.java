package com.kosta.openday.oclass.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.oclass.dao.OClassDAO;
import com.kosta.openday.user.dto.OClassDTO;

@Service
public class OClassServiceImpl implements OClassService {

	@Autowired
	private OClassDAO oClassDAO;
	
	@Override
	public List<OClassDTO> getSearchOClass(String loc, Date startDate, Date endDate, String clsCode) throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("scdLoc", loc);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("clsCode", clsCode);
		// TODO Auto-generated method stub
		return oClassDAO.selectOClassList(param);
	}


}
