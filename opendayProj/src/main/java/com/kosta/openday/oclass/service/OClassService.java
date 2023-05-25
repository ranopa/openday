package com.kosta.openday.oclass.service;

import java.util.List;

import com.kosta.openday.oclass.dto.OClassDTO;
import com.kosta.openday.oclass.dto.ScheduleDTO;

public interface OClassService {
	
	public OClassDTO findOne(String id) throws Exception;
	
	public List<OClassDTO> findAll() throws Exception;
	
	public void save(OClassDTO dto) throws Exception;
	
	public List<ScheduleDTO> findScheduleByClassId(Integer clsId) throws Exception;
	// todo: update, delete
}
