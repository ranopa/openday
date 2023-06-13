package com.kosta.openday.user.service;

import java.io.OutputStream;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dto.OClassDTO;

public interface classOpenEnrollService {
	public void classCreate(OClassDTO dto, MultipartFile file) throws Exception;
	OClassDTO getOclass(Integer clsId) throws Exception;
	ScheduleDTO getScheduleNum(Integer scdNum) throws Exception;
	public void fileView(Integer filNum, OutputStream out) throws Exception;	
	void classUpload(ScheduleDTO dto) throws Exception;
	Map<String, Object> getSchedule(Integer clsId) throws Exception; 
	void classInfoUpdate(OClassDTO dto) throws Exception;
	void classFileUpdate(FileDTO dto) throws Exception;
	void classScheduleUpdate(ScheduleDTO dto) throws Exception; 
}
