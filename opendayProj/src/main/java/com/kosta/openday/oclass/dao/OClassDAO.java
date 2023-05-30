package com.kosta.openday.oclass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.adm.dto.CodeDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;

@Repository
public interface OClassDAO {
	
	public List<OClassDTO> selectClassList() throws Exception;
	
	public OClassDTO selectClassById(Integer clsId) throws Exception;
	
	public void insertClass(OClassDTO dto) throws Exception;
	
	public List<ScheduleDTO> selectScheduleByClass(Integer clsId) throws Exception;

	public ScheduleDTO selectSchedule(Integer scdNum) throws Exception;
}
