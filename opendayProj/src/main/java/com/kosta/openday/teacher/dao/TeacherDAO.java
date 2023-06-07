package com.kosta.openday.teacher.dao;

import java.util.HashMap;
import java.util.List;

import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.teacher.dto.ClassScdUserDTO;
import com.kosta.openday.teacher.dto.ClassScheduleDTO;
import com.kosta.openday.teacher.dto.TeacherScheduleDTO;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO;
public interface TeacherDAO {
	List<AnnouncementDTO> tcAnnouncementList() throws Exception;
	List<OClassDTO> tcClassList(HashMap<String, Object> map) throws Exception;
	int tcClassListCount(HashMap<String, Object> map) throws Exception;
	List<ClassScheduleDTO> tcClassScheduleList(HashMap<String, Object> map) throws Exception;
	List<ClassScdUserDTO> tcClassUserList(Integer scdNum) throws Exception;
	int tcClassScheduleListCount(HashMap<String, Object> map) throws Exception;
	List<ClsInquiryDTO> tcClassInquiryList(Integer clsId) throws Exception;
	List<TeacherScheduleDTO> tcScheduleList(HashMap<String, Object> map) throws Exception;
}	

