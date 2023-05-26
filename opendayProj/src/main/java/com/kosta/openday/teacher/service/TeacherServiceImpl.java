package com.kosta.openday.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.teacher.dao.TeacherDAO;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDAO teacherDAO;
	@Override
	public List<AnnouncementDTO> tcAnnouncement() throws Exception {
		return teacherDAO.tcAnnouncement();
	}

}
