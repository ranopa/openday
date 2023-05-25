package com.kosta.openday.oclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.oclass.dao.OClassDAO;
import com.kosta.openday.oclass.dto.OClassDTO;
import com.kosta.openday.oclass.dto.ScheduleDTO;

@Service
public class OClassServiceImpl implements OClassService {

	@Autowired
	private OClassDAO oClassDAO;
	
	@Override
	public OClassDTO findOne(String id) throws Exception {
		return oClassDAO.selectClassById(id);
	}

	@Override
	public List<OClassDTO> findAll() throws Exception {
		return oClassDAO.selectClassList();
	}

	@Override
	public void save(OClassDTO dto) throws Exception {
		oClassDAO.insertClass(dto);
	}
	
	@Override
	public List<ScheduleDTO> findScheduleByClassId(Integer clsId) throws Exception {
		return oClassDAO.selectScheduleByClass(clsId);
	}
}
