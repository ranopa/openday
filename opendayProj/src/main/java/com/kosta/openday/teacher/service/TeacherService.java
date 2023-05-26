package com.kosta.openday.teacher.service;

import java.util.List;

import com.kosta.openday.adm.dto.AnnouncementDTO;

public interface TeacherService {
	List<AnnouncementDTO> tcAnnouncement() throws Exception;
}
