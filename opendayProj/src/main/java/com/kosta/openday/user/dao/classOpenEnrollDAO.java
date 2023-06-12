package com.kosta.openday.user.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.OClassDTO;

public interface classOpenEnrollDAO {
	public int classOpen(OClassDTO dto) throws Exception;
	public void insertFile(FileDTO file) throws Exception;
	Integer selectFileNum() throws Exception;
	OClassDTO selectOclass(Integer clsId) throws Exception;
	ScheduleDTO selectScheduleNum(Integer scdNum) throws Exception;
	FileDTO selectFile(Integer filNum) throws Exception;
	public int classEnrollment(ScheduleDTO dto) throws Exception;
	Map<String, Object> selectSchedule(Integer clsId) throws Exception;
	void updateClassInfo(OClassDTO dto) throws Exception; 
	void updateClassFile(FileDTO dto) throws Exception;
	void updateClassSchedule(ScheduleDTO dto) throws Exception;
}
