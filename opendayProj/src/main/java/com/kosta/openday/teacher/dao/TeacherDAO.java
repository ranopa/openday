package com.kosta.openday.teacher.dao;

import java.util.List;

import com.kosta.openday.adm.dto.AnnouncementDTO;
public interface TeacherDAO {
	List<AnnouncementDTO> tcAnnouncement() throws Exception;
}
